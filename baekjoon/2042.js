const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, m, k] = input[0].split(" ").map((v) => +v);
const nums = input.slice(1, n + 1).map((v) => +v);
const ops = input.slice(n + 1).map((line) => line.split(" ").map((v) => +v));

let idx = 1;
while (idx < n) {
  idx *= 2;
}
const arr = Array(idx * 2 + 1).fill(0);
const update = (pos) => {
  let p = pos;
  while (p != 0) {
    arr[p] = BigInt(arr[p * 2]) + BigInt(arr[p * 2 + 1]);
    p = Math.trunc(p / 2);
  }
};

// 트리 채우기
for (let i = 0; i < n; i++) {
  let pos = idx + i;
  arr[pos] = BigInt(nums[i]);
  pos = Math.trunc(pos / 2);
  update(pos);
}
const solve = (idx, cl, cr, left, right) => {
  if (left <= cl && cr <= right) return arr[idx];

  if (cr < left) return 0;
  if (right < cl) return 0;

  const v1 = solve(idx * 2, cl, Math.trunc((cl + cr) / 2), left, right);
  const v2 = solve(idx * 2 + 1, Math.trunc((cl + cr) / 2) + 1, cr, left, right);
  return BigInt(v1) + BigInt(v2);
};

ops.forEach((v) => {
  const [a, b, c] = v;
  if (a === 1) {
    const pos = idx + b - 1;
    arr[pos] = BigInt(c);
    update(Math.trunc(pos / 2));
  } else {
    console.log(solve(1, 1, n, b, c) + "");
  }
});
