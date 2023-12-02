/*
 - https://www.acmicpc.net/problem/9342
 - 실버3
 - 문자열, 정규표현식
 */
const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((line) => line.split(""));

const chromosome = ["A", "B", "C", "D", "E", "F"];
const isInfected = (s) => {
  if (s.some((c) => !chromosome.includes(c))) return false;

  if (s[0] !== "A" && s[1] !== "A") return false;
  let pos = s[1] === "A" ? 1 : 0;
  while (pos < s.length && s[pos] === "A") {
    pos++;
  }
  if (s[pos] !== "F") return false;
  while (pos < s.length && s[pos] === "F") {
    pos++;
  }
  if (s[pos] !== "C") return false;
  while (pos < s.length && s[pos] === "C") {
    pos++;
  }
  if (1 < s.length - pos) return false;

  return true;
};

const result = [];
arr.forEach((v) => {
  if (isInfected(v)) result.push("Infected!");
  else result.push("Good");
});

console.log(result.join("\n"));
