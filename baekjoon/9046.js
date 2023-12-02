/*
 - https://www.acmicpc.net/problem/9046
 - 브론즈2
 - 구현, 문자열
 */
const sentences = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

const result = [];
sentences.forEach((s) => {
  const counts = {};
  s.split("")
    .filter((c) => c !== " ")
    .forEach((c) => (counts[c] ? counts[c]++ : (counts[c] = 1)));
  const arr = Object.entries(counts).sort((a, b) => b[1] - a[1]);
  if (arr.length === 1 || arr[0][1] !== arr[1][1]) result.push(arr[0][0]);
  else result.push("?");
});

console.log(result.join("\n"));
