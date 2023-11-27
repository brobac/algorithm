/*
 - https://www.acmicpc.net/problem/21314
 - 실버2
 - 구현, 그리디
  */

const s = require("fs").readFileSync("test.txt").toString().trim();
let min = "";
let i = 0;
while (i < s.length) {
  if (s[i] === "M") {
    let count = 0;
    while (i < s.length - 1 && s[i + 1] === "M") {
      count++;
      i++;
    }
    min += "1" + "0".repeat(count);
  } else {
    min += "5";
  }
  i++;
}

let max = "";
i = 0;
while (i < s.length) {
  if (s[i] === "K") {
    max += "5";
    i++;
  } else {
    let count = 1;
    while (i < s.length - 1 && s[i + 1] === "M") {
      count++;
      i++;
    }
    if (s[i] === "M" && i === s.length - 1) {
      max += "1".repeat(count);
    } else {
      max += "5" + "0".repeat(count);
      i++;
    }
    i++;
  }
}
console.log(max);
console.log(min);
