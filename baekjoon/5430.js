/*
 - https://www.acmicpc.net/problem/5430
 - 골드5
 
 R이 나왔을 때 reverse 하는 작업을 했더니 시간초과가 나왔다
 R이 연속 2번 나오면 reverse를 안하게 고쳤지만 그래도 reverse하는데 O(N) 소요
 R이 나왔을 때 isReverse 하는 flag를 두어서 true 이면 뒤에서 pop하고 pop이면 앞에서 pop 하는 방식으로
 reverse하는 시간을 줄였다.
 그런데 틀렸습니다가 나왔다. 
 n 이 0일때
 arr = "".split(",").map(Number) 의 결과가 [0] 이 나와버러서
 빈배열이 출력되야되는데 [0]이 출력되서 틀렸다.
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

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

  reverse() {
    let temp;
    let current = this.head;
    for (let i = 0; i < this.size; i++) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;
      current = current.prev;
    }
    const prevHead = this.head;
    this.head = this.tail;
    this.tail = prevHead;
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

for (let i = 1; i < input.length; i += 3) {
  const func = input[i].split("");
  const n = Number(input[i + 1]);
  const deleteCount = func.reduce(
    (sum, cur) => (cur === "D" ? (sum += 1) : sum),
    0
  );

  if (n < deleteCount) {
    console.log("error");
    continue;
  }

  const deque = new Deque();
  let isReverse = false;
  const arr = input[i + 2]
    .slice(1, input[i + 2].length - 1)
    .split(",")
    .map(Number);
  arr.forEach((v) => deque.pushBack(v));
  for (let j = 0; j < func.length; j++) {
    if (func[j] === "D") {
      if (isReverse) deque.popBack();
      else deque.popFront();
    } else {
      isReverse = !isReverse;
    }
  }
  const result = [];
  if (isReverse) {
    let cur = deque.tail;
    for (let j = 0; j < deque.size; j++) {
      result.push(cur.v);
      cur = cur.prev;
    }
  } else {
    let cur = deque.head;
    for (let j = 0; j < deque.size; j++) {
      result.push(cur.v);
      cur = cur.next;
    }
  }
  console.log(`[${result.join(",")}]`);
}
