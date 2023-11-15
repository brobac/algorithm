const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

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
}
const string = input[0];
const list = input.slice(2);
const linkedList = new DoublyLinkedList();

for (let c of string) {
  linkedList.addLast(c);
}
let cursor = linkedList.tail;

const operation = {
  L() {
    if (cursor.prev !== linkedList.head) cursor = cursor.prev;
  },
  D() {
    if (cursor.next !== null) cursor = cursor.next;
  },
  B() {
    if (cursor.prev !== linkedList.head) linkedList.remove(cursor.prev);
  },
  P(v) {
    if (cursor === linkedList.head) {
      linkedList.addFirst(v);
    } else {
      linkedList.addBetween(v, cursor.prev, cursor);
    }
  },
};

list.forEach((v) => {
  if (v.length === 1) {
    operation[v]();
  } else {
    operation.P(v.split(" ")[1]);
  }
});

let node = linkedList.head;
const result = [];
while (node.next.value !== null) {
  result.push(node.next.value);
  node = node.next;
}

console.log(result.join(""));
