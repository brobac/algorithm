//https://www.acmicpc.net/problem/10866
// 실버4
/*
명령마다 출력했더니 시간초과나서 출력할 내용 배열에 담아뒀다가 한번에 join해서 출력하니 통과
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const arr = input.slice(1);

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
const result = [];
arr.forEach((v) => {
  if (v.startsWith("push_front")) {
    deque.pushFront(v.split(" ")[1]);
  } else if (v.startsWith("push_back")) {
    deque.pushBack(v.split(" ")[1]);
  } else if (v.startsWith("pop_front")) {
    if (deque.isEmpty()) {
      result.push(-1);
    } else {
      result.push(deque.popFront());
    }
  } else if (v.startsWith("pop_back")) {
    if (deque.isEmpty()) {
      result.push(-1);
    } else {
      result.push(deque.popBack());
    }
  } else if (v.startsWith("size")) {
    result.push(deque.size);
  } else if (v.startsWith("empty")) {
    if (deque.isEmpty()) {
      result.push(1);
    } else {
      result.push(0);
    }
  } else if (v.startsWith("front")) {
    if (deque.isEmpty()) {
      result.push(-1);
    } else {
      result.push(deque.head.v);
    }
  } else if (v.startsWith("back")) {
    if (deque.isEmpty()) {
      result.push(-1);
    } else {
      result.push(deque.tail.v);
    }
  }
});
console.log(result.join("\n"));
