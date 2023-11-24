/*
 - https://www.acmicpc.net/problem/10431
 - 실버5
 - 구현
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

input
  .slice(1)
  .map((line) => line.split(" ").map(Number))
  .forEach((arr) => {
    const testNum = arr[0];
    const students = arr.slice(1);
    const result = [students[0]];
    let counts = 0;
    let max = students[0];
    for (let i = 1; i < 20; i++) {
      const cur = students[i];
      if (max < cur) {
        result.push(cur);
        max = cur;
      } else {
        for (let j = 0; j < result.length; j++) {
          if (cur < result[j]) {
            counts += result.length - j;
            result.splice(j, 0, cur);
            break;
          }
        }
      }
    }
    console.log(testNum, counts);
  });
