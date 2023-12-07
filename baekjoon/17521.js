/*
 - https://www.acmicpc.net/problem/17521
 - 실버4
 - 그리디
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, w] = input[0].split(" ").map(Number);
const prices = input.slice(1).map(Number);

let money = w;
let coin = 0;
for (let i = 0; i < n - 1; i++) {
  if (prices[i] < prices[i + 1]) {
    coin += Math.trunc(money / prices[i]);
    money -= Math.trunc(money / prices[i]) * prices[i];
  } else if (prices[i + 1] < prices[i]) {
    money += coin * prices[i];
    coin = 0;
  }
}

if (coin) {
  money += coin * prices[n - 1];
}
console.log(money);
