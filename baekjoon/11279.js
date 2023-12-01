/**
 - https://www.acmicpc.net/problem/11279
 - 실버2
 - 자료구조, 우선순위 큐
 */
const instructions = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map(Number);

/*  ----- 시간초과
const arr = [];
const result = [];
instructions.forEach((v) => {
  if (v === 0 && arr.length === 0) {
    result.push(0);
  } else if (v === 0) {
    let maxIdx = 0;
    let max = 0;
    for (let i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
        maxIdx = i;
      }
    }
    let temp = arr[arr.length - 1];
    arr[arr.length - 1] = arr[maxIdx];
    arr[maxIdx] = temp;
    result.push(arr.pop());
  } else {
    arr.push(v);
  }
});
console.log(result.join("\n"));
*/

class Heap {
  constructor() {
    this.arr = [null];
  }

  push(n) {
    this.arr.push(n);
    let i = this.size();
    while (i != 1) {
      const pi = Math.trunc(i / 2);
      if (n <= this.arr[pi]) break;
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
      if (i < this.size() && this.arr[i] < this.arr[i + 1]) i++;
      if (last >= this.arr[i]) break;

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

const heap = new Heap();
const result = [];
instructions.forEach((v) => {
  if (v === 0) {
    result.push(heap.pop());
  } else {
    heap.push(v);
  }
});
console.log(result.join("\n"));
