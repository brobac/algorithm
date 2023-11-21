// https://www.acmicpc.net/problem/18258
// 실버4
/* 명령마다 출력해서 시간초과 발생함. 배열에 담았다가 join해서 출력하는걸로 해결
 */
const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  push(n) {
    const obj = {
      v: n,
      next: null,
    };
    if (this.size === 0) {
      this.head = obj;
      this.tail = obj;
    } else {
      this.tail.next = obj;
      this.tail = obj;
    }
    this.size++;
  }
  pop() {
    if (this.size === 0) return;
    if (this.size === 1) {
      const result = this.head;
      this.head = null;
      this.tail = null;
      this.size--;
      return result.v;
    } else {
      const head = this.head;
      this.head = head.next;
      this.size--;
      return head.v;
    }
  }
}
const queue = new Queue();
const result = [];
arr.forEach((v) => {
  if (v.startsWith("push")) {
    queue.push(v.split(" ")[1]);
  } else if (v.startsWith("pop")) {
    if (queue.size === 0) {
      result.push("-1");
    } else {
      result.push(queue.pop());
    }
  } else if (v.startsWith("size")) {
    result.push(queue.size);
  } else if (v.startsWith("empty")) {
    result.push(queue.size === 0 ? 1 : 0);
  } else if (v.startsWith("front")) {
    if (queue.size === 0) {
      result.push("-1");
    } else {
      result.push(queue.head.v);
    }
  } else if (v.startsWith("back")) {
    if (queue.size === 0) {
      result.push("-1");
    } else {
      result.push(queue.tail.v);
    }
  }
});

console.log(result.join("\n"));
