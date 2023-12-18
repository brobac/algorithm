/*
 - https://www.acmicpc.net/problem/9375
 - 실버3
 - 수학, 자료 구조, 조합론, 해시를 사용한 집합과 맵
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

let i = 1;
const result = [];
while (i < input.length) {
  const n = +input[i];
  const items = input.slice(i + 1, i + n + 1).map((v) => v.split(" "));
  i += n + 1;
  const closet = {};
  items.forEach(([name, type]) =>
    closet[type] ? closet[type]++ : (closet[type] = 1)
  );
  result.push(Object.values(closet).reduce((s, c) => s * (c + 1), 1) - 1);
}

console.log(result.join("\n"));
