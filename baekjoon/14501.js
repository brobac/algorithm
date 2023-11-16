/*
당일 상담을 하는 것보다 당일 상담을 안하고 다음날 상담할 때 돈을 더 많이 벌 수 있는 경우가 있다.
오늘 vs 내일을 이득을 비교하기위해 마지막날 부터 계산을 해서 첫날까지 계산한다음 가장 많이 번 값을 출력했다.
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = parseInt(input[0]);
const arr = input.slice(1).map((line) => line.split(" ").map(Number));
const result = Array(n).fill(0);
for (let i = n - 1; 0 <= i; i--) {
  const [t, p] = arr[i];
  let today = 0;
  let tomorrow = i + 1 < n ? result[i + 1] : 0;
  if (i + t - 1 < n) {
    today += p;
    if (i + t < n) today += result[i + t];
  }
  result[i] = Math.max(today, tomorrow);
}
console.log(Math.max(...result));
