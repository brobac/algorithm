class Node {
  constructor(value, prev = null, next = null) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}

class DoublyLinkedList {
  constructor() {
    this.size = 0;
    this.head = new Node(null);
    this.tail = new Node(null, this.head);
    this.head.next = this.tail;
  }

  isEmpty() {
    return this.size === 0;
  }

  addFirst(v) {
    this.addBetween(v, this.head, this.head.next);
  }

  removeFirst() {
    if (!this.isEmpty()) this.remove(this.head.next);
  }

  removeLast() {
    if (!this.isEmpty()) this.remove(this.tail.prev);
  }

  addLast(v) {
    this.addBetween(v, this.tail.prev, this.tail);
  }

  addBetween(value, predecessor, successor) {
    const newNode = new Node(value, predecessor, successor);
    predecessor.next = newNode;
    successor.prev = newNode;
    this.size++;
  }

  remove(n) {
    if (this.isEmpty()) return;
    const predecessor = n.prev;
    const successor = n.next;
    predecessor.next = successor;
    successor.prev = predecessor;
    this.size--;
  }

  getAllValues() {
    const result = [];
    let n = this.head.next;
    while (n !== this.tail) {
      result.push(n.value);
      n = n.next;
    }
    return result;
  }
}
const testList = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const getPW = (input) => {
  const list = new DoublyLinkedList();
  let cursor = list.tail;
  const keys = input.split("");
  keys.forEach((k) => {
    if (k === "<") {
      if (cursor.prev !== list.head) cursor = cursor.prev;
    } else if (k === ">") {
      if (cursor.next !== null) cursor = cursor.next;
    } else if (k === "-") {
      if (!list.isEmpty() && cursor.prev !== list.head && cursor.prev !== null)
        list.remove(cursor.prev);
    } else {
      list.addBetween(k, cursor.prev, cursor);
    }
  });
  return list.getAllValues().join("");
};

testList.forEach((v) => {
  console.log(getPW(v));
});
