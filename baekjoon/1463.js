/*
 - https://www.acmicpc.net/problem/1463
 - 실버3
 - 다이나믹프로그래밍
 */
const x = +require("fs").readFileSync("test.txt").toString().trim();

const ans = [null, 0, 1, 1];

if (x < 4) {
  console.log(ans[x]);
  return;
}

const solution = (n) => {
  if (n < 4) return;
  const ableList = [];
  if (n % 2 === 0) {
    if (!ans[n / 2]) solution(n / 2);
    ableList.push(ans[n / 2]);
  }
  if (n % 3 === 0) {
    if (!ans[n / 3]) solution(n / 3);
    ableList.push(ans[n / 3]);
  }
  if (!ans[n - 1]) solution(n - 1);
  ableList.push(ans[n - 1]);
  ans[n] = Math.min(...ableList) + 1;
};
solution(x);
console.log(ans[x]);
