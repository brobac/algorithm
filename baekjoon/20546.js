/*
 - https://www.acmicpc.net/problem/20546
 - 실버5
 - 구현
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

let upDown = 0;
for (let i = 1; i < arr.length; i++) {
  const bnpBuy = Math.trunc(bnp.money / arr[i]);
  bnp.money -= bnpBuy * arr[i];
  bnp.stock += bnpBuy;

  if (arr[i - 1] < arr[i]) {
    //상승
    if (0 < upDown) upDown++;
    else upDown = 1;
  } else if (arr[i - 1] > arr[i]) {
    //히락
    if (upDown < 0) upDown--;
    else upDown = -1;
  }

  if (upDown === 3) {
    timing.money += timing.stock * arr[i];
    timing.stock = 0;
  } else if (upDown === -3) {
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
