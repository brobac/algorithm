/*
 - https://www.acmicpc.net/problem/20365
 - 실버3
 - 그리디, 문자열
 */
const s = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")[1];

let count1 = 1;
if (s[0] === "R") count1++;
for (let i = 1; i < s.length; i++) {
  const cur = s[i];
  const prev = s[i - 1];
  if (cur === "R" && prev === "B") count1++;
}
let count2 = 1;
if (s[0] === "B") count2++;
for (let i = 1; i < s.length; i++) {
  const cur = s[i];
  const prev = s[i - 1];
  if (cur === "B" && prev === "R") count2++;
}

console.log(Math.min(count1, count2));
