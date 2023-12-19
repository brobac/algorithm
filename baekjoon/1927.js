/*
 - https://www.acmicpc.net/problem/1927
 - 실버2
 - 자료구조, 우선순위 큐
 */
class MinHeap {
  constructor() {
    this.arr = [null];
  }

  push(n) {
    this.arr.push(n);
    let i = this.size();
    while (i != 1) {
      const pi = Math.trunc(i / 2);
      if (this.arr[pi] <= n) break;
      this.arr[i] = this.arr[pi];
      i = pi;
    }
    this.arr[i] = n;
  }
  pop() {
    if (this.size() === 0) return 0;
    const root = this.arr[1];
    const last = this.arr[this.size()];
    let pi = 1;
    let i = 2;
    while (i <= this.size()) {
      if (i < this.size() && this.arr[i + 1] < this.arr[i]) i++;
      if (last <= this.arr[i]) break;

      this.arr[pi] = this.arr[i];
      pi = i;
      i *= 2;
    }
    this.arr[pi] = last;
    this.arr.pop();

    return root;
  }
  size() {
    return this.arr.length - 1;
  }
}

const instructions = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map(Number);

const heap = new MinHeap();
const result = [];
instructions.forEach((n) => {
  if (!n) result.push(heap.pop());
  else heap.push(n);
});

console.log(result.join("\n"));
