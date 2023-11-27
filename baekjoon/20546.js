/*
 - https://www.acmicpc.net/problem/20546
 - 실버5
 - 구현

 - 맞았습니다 나왔지만 잘못 풀었던 문제여서 수정
*/
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const money = +input[0];
const arr = input[1].split(" ").map(Number);

let bnp = {
  money,
  stock: 0,
};
let timing = {
  money,
  stock: 0,
};

const firstDayBuy = Math.trunc(money / arr[0]);
bnp.money -= firstDayBuy * arr[0];
bnp.stock += firstDayBuy;

for (let i = 1; i < arr.length; i++) {
  const bnpBuy = Math.trunc(bnp.money / arr[i]);
  bnp.money -= bnpBuy * arr[i];
  bnp.stock += bnpBuy;
}
for (let i = 3; i < arr.length; i++) {
  if (
    arr[i - 3] < arr[i - 2] &&
    arr[i - 2] < arr[i - 1] &&
    arr[i - 1] < arr[i]
  ) {
    timing.money += timing.stock * arr[i];
    timing.stock = 0;
  } else if (
    arr[i] < arr[i - 1] &&
    arr[i - 1] < arr[i - 2] &&
    arr[i - 2] < arr[i - 3]
  ) {
    const timingBuy = Math.trunc(timing.money / arr[i]);
    timing.money -= timingBuy * arr[i];
    timing.stock += timingBuy;
  }
}

const bnpResult = bnp.money + bnp.stock * arr[arr.length - 1];
const timingResult = timing.money + timing.stock * arr[arr.length - 1];
if (timingResult < bnpResult) {
  console.log("BNP");
} else if (bnpResult < timingResult) {
  console.log("TIMING");
} else {
  console.log("SAMESAME");
}
