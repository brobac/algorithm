/*
 - https://www.acmicpc.net/problem/20291
 - 실버3

 여러줄 출력할 땐 꼭 join("\n")을 통해 한 번에 출력할 것
*/

const result = {};

require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .forEach((name) => {
    const extension = name.split(".").pop();
    result[extension] = result[extension] ? result[extension] + 1 : 1;
  });

const arr = Object.entries(result);
arr.sort((a, b) => {
  if (a[0] < b[0]) return -1;
  else if (b[0] < a[0]) return 1;
  else return 0;
});
console.log(arr.map((v) => v.join(" ")).join("\n"));
