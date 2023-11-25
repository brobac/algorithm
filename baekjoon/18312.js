/*
 - https://www.acmicpc.net/problem/18312
 - 브론즈2
 - 구현, 문자열, 브루트포스

 - 02시, 02분, 03초  처럼 앞에 0붙은 경우를 생각안하고 풀었다가 늦게 알아차림
 */

const [n, k] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let count = 0;
for (let a = 0; a <= n; a++) {
  for (let b = 0; b <= 59; b++) {
    for (let c = 0; c <= 59; c++) {
      const strA = a < 10 ? "0" + a : "" + a;
      const strB = b < 10 ? "0" + b : "" + b;
      const strC = c < 10 ? "0" + c : "" + c;
      if ([strA, strB, strC].some((v) => v.includes(String(k)))) {
        count++;
      }
    }
  }
}
console.log(count);
