//https://www.acmicpc.net/problem/2164
// 실버4

const n = +require("fs").readFileSync("test.txt").toString().trim();

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  append(n) {
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
for (let i = 1; i <= n; i++) {
  queue.append(i);
}
while (1 < queue.size) {
  queue.pop();
  queue.append(queue.pop());
}
console.log(queue.pop());
