/*
 - https://www.acmicpc.net/problem/6550
 - 실버5
 - 그리디, 문자열
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

arr.forEach((line) => {
  const [s, p] = line.split(" ");
  let check = 0;
  for (let i = 0; i < p.length; i++) {
    if (p[i] === s[check]) check++;
  }
  console.log(check === s.length ? "Yes" : "No");
});
