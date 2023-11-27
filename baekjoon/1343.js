/*
 - https://www.acmicpc.net/problem/1343
 - 실버5
 - 구현, 그리디 
 */

const input = require("fs").readFileSync("test.txt").toString().trim();

const arr = input.split(".").filter((v) => v !== "");

if (arr.some((v) => v.length % 2 === 1)) {
  console.log(-1);
  return;
}

for (let i = 0; i < arr.length; i++) {
  if (arr[i].length % 4 === 0) {
    arr[i] = "A".repeat(arr[i].length);
  } else if (4 < arr[i].length) {
    arr[i] = "A".repeat(arr[i].length - 2) + "BB";
  } else {
    arr[i] = "BB";
  }
}
let result = "";
let flag = false;
let idx = 0;
for (let i = 0; i < input.length; i++) {
  if (input[i] === ".") result += ".";
  else {
    result += arr[idx];
    i += arr[idx].length - 1;
    idx++;
  }
}
console.log(result);
