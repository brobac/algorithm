/*
 - https://www.acmicpc.net/problem/1021
 - 실버3
 
 Deque 메소드 구현을 잘못해서 3시간이나 써버렸다
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
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
  isEmpty() {
    return this.size === 0;
  }
  pushFront(v) {
    if (this.isEmpty()) {
      const n = new Node(v);
      this.head = n;
      this.tail = n;
      this.size++;
    } else {
      const n = new Node(v);
      const prevHead = this.head;
      prevHead.prev = n;
      n.next = prevHead;
      n.prev = this.tail;
      this.tail.next = n;
      this.head = n;
      this.size++;
    }
  }
  pushBack(v) {
    if (this.isEmpty()) {
      const n = new Node(v);
      this.head = n;
      this.tail = n;
      this.size++;
    } else {
      const n = new Node(v);
      const prevTail = this.tail;
      prevTail.next = n;
      n.prev = prevTail;
      n.next = this.head;
      this.head.prev = n;
      this.tail = n;
      this.size++;
    }
  }
  popFront() {
    if (this.isEmpty()) {
      return undefined;
    } else if (this.size === 1) {
      const head = this.head;
      this.head = null;
      this.tail = null;
      this.size--;
      return head.v;
    } else if (this.size === 2) {
      const head = this.head;
      const newHead = head.next;
      newHead.prev = null;
      newHead.next = null;
      this.head = newHead;
      this.tail = newHead;
      this.size--;
      return head.v;
    } else {
      const head = this.head;
      const newHead = head.next;
      newHead.prev = this.tail;
      this.tail.next = newHead;
      this.head = newHead;
      this.size--;
      return head.v;
    }
  }
  popBack() {
    if (this.isEmpty()) {
      return undefined;
    } else if (this.size === 1) {
      const tail = this.tail;
      this.head = null;
      this.tail = null;
      this.size--;
      return tail.v;
    } else if (this.size === 2) {
      const tail = this.tail;
      const newTail = tail.prev;
      newTail.prev = null;
      newTail.next = null;
      this.head = newTail;
      this.tail = newTail;
      this.size--;
      return tail.v;
    } else {
      const tail = this.tail;
      const newTail = tail.prev;
      newTail.next = this.head;
      this.head.prev = newTail;
      this.tail = newTail;
      this.size--;
      return tail.v;
    }
  }

  front() {
    if (this.size === 0) return undefined;
    else {
      return this.head.v;
    }
  }
  back() {
    if (this.size === 0) return undefined;
    else {
      return this.tail.v;
    }
  }
}

const deque = new Deque();
for (let i = 1; i <= n; i++) {
  deque.pushBack(i);
}

let result = 0;
for (let i = 0; i < m; i++) {
  if (deque.front() === arr[i]) {
    deque.popFront();
  } else {
    let twoCount = 0;
    let threeCount = 0;
    let cur = deque.head;
    while (cur.v != arr[i]) {
      cur = cur.next;
      twoCount++;
    }
    cur = deque.head;
    while (cur.v != arr[i]) {
      cur = cur.prev;
      threeCount++;
    }
    if (twoCount <= threeCount) {
      result += twoCount;
      for (let j = 0; j < twoCount; j++) {
        deque.pushBack(deque.popFront());
      }
    } else {
      result += threeCount;
      for (let j = 0; j < threeCount; j++) {
        deque.pushFront(deque.popBack());
      }
    }
    deque.popFront();
  }
}
console.log(result);
