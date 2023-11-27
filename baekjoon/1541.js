/*
 - https://www.acmicpc.net/problem/1541
 - 실버2
 - 수학, 그리디, 문자열, 파싱

 2년전에 푼 문제여서 다시 풀어봤다
 최저값을 만들기 위해 최대한 많은 숫자를 뺄셈하기 위해
 처음 - 이후로 나오는 숫자논 모두 뺐다
 - 뒤에 나오는 수는 빼면되고 + 뒤에 나오는 수는 괄호로 묶으면 뺄 수 있기 때문이다

 */
const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .replaceAll("+", " + ")
  .replaceAll("-", " - ")
  .split(" ")
  .map((v) => (Number.isInteger(+v) ? +v : v));

const idx = arr.findIndex((v) => v === "-");
if (idx === -1) {
  console.log(
    arr.reduce((sum, cur) => (Number.isInteger(cur) ? (sum += cur) : sum), 0)
  );
} else {
  const sum = arr
    .slice(0, idx)
    .reduce((sum, cur) => (Number.isInteger(cur) ? (sum += cur) : sum), 0);

  const minus = arr
    .slice(idx + 1)
    .reduce((sum, cur) => (Number.isInteger(cur) ? (sum += cur) : sum), 0);
  console.log(sum - minus);
}
