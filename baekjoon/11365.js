/*
 - https://www.acmicpc.net/problem/11365
 - 브론즈4
 - 구현, 문자열
 */
console.log(
  require("fs")
    .readFileSync("test.txt")
    .toString()
    .trim()
    .split("\n")
    .slice(0, -1)
    .map((line) => line.split("").reverse().join(""))
    .join("\n")
);
