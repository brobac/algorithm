/*
 - https://www.acmicpc.net/problem/9655
 - 실버5
 */
const n = Number(require("fs").readFileSync("test.txt").toString().trim());

if (n % 2 === 0) console.log("CY");
else console.log("SK");
