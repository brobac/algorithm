/*
- https://www.acmicpc.net/problem/18115
- 실버3
*/

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const arr = input[1].split(" ").map(Number);

class Node {
  constructor(v, next = null, prev = null) {
    this.v = v;
    this.next = next;
    this.prev = prev;
  }
}
class Deque {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  pushFront(v) {
    const node = new Node(v);
    if (this.isEmpty()) {
      this.head = node;
      this.tail = node;
    } else {
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }
    this.size++;
  }
  pushBack(v) {
    const node = new Node(v);
    if (this.isEmpty()) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
    }
    this.size++;
  }

  popFront() {
    if (this.isEmpty()) return undefined;
    if (this.size === 1) {
      const v = this.head.v;
      this.head = null;
      this.tail = null;
      this.size--;
      return v;
    } else {
      const head = this.head;
      this.head = head.next;
      head.prev = null;
      this.size--;
      return head.v;
    }
  }
  popSecond() {
    if (this.size < 2) return undefined;
    if (this.size === 2) {
      return this.popBack();
    } else {
      const h = this.head;
      const second = h.next;
      h.next = second.next;
      this.size--;
      return second.v;
    }
  }
  popBack() {
    if (this.isEmpty()) return undefined;
    if (this.size === 1) {
      const v = this.head.v;
      this.head = null;
      this.tail = null;
      this.size--;
      return v;
    } else {
      const tail = this.tail;
      const prev = tail.prev;
      prev.next = null;
      this.tail = prev;
      this.size--;
      return tail.v;
    }
  }
  isEmpty() {
    return this.size === 0;
  }
}

const deque = new Deque();
const result = Array(n);

for (let i = 0; i < n; i++) {
  deque.pushBack(i);
}

arr.forEach((v, i) => {
  let index;
  if (v === 1) {
    index = deque.popFront();
  } else if (v === 2) {
    index = deque.popSecond();
  } else {
    index = deque.popBack();
  }
  result[index] = n - i;
});

console.log(result.join(" "));
