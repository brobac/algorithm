/*
 - https://www.acmicpc.net/problem/1676
 - 실버5
 - 수학
 */
const n = +require("fs").readFileSync("test.txt").toString().trim();

console.log(Math.trunc(n / 5) + Math.trunc(n / 25) + Math.trunc(n / 125));
