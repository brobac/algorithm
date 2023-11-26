/*
 - https://www.acmicpc.net/problem/2609
 - 브론즈1
 - 수학, 정수론, 유클리드 호제법
 */
const [a, b] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const gcd = (a, b) => {
  if (b === 0) return a;
  return gcd(b, a % b);
};

console.log(gcd(a, b));
console.log((a * b) / gcd(a, b));
