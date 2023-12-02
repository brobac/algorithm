/*
 - https://www.acmicpc.net/problem/18111
 - 실버2
 - 구현, 브루트포스

 가장 낮은 땅높이 ~ 가장 높은 땅높이까지만 반복문을 돌면 체크 했었는데 그 범위를
 벗어나는 경우가 있었다.
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [n, m, b] = input[0].split(" ").map(Number);
const arr = input
  .slice(1)
  .map((line) => line.split(" ").map(Number))
  .flat()
  .sort((a, b) => b - a);
const results = [];
for (let i = 0; i <= 256; i++) {
  const target = i;
  let able = true;
  let extra = b;
  let time = 0;
  for (let j = 0; j < arr.length; j++) {
    if (target === arr[j]) continue;

    if (target < arr[j]) {
      extra += arr[j] - target;
      time += 2 * (arr[j] - target);
    } else if (extra < target - arr[j]) {
      able = false;
      break;
    } else {
      extra -= target - arr[j];
      time += target - arr[j];
    }
  }
  if (able) results.push([time, target]);
}
results.sort((a, b) => {
  if (a[0] < b[0]) return -1;
  if (a[0] > b[0]) return 1;
  if (a[1] > b[1]) return -1;
  if (a[1] < b[1]) return 1;
  return 0;
});
console.log(results[0].join(" "));
