/*
 - https://www.acmicpc.net/problem/2800
 - 골드5
 - 자료구조, 문자열, 브루트포스, 스택

 괄호 했을 때 나오는 결과가 중복이 있을 수 있었다.
 경우의 수를 배열에 저장하지 않고 set에 넣어서 중복을 제거했다.
*/
const s = require("fs").readFileSync("test.txt").toString().trim();

const counts = s
  .split("")
  .reduce((sum, cur) => (cur === "(" ? sum + 1 : sum), 0);

const arr = [];

for (let i = 2 ** counts - 2; 0 <= i; i--) {
  arr.push(
    ("0".repeat(counts - i.toString(2).length) + i.toString(2))
      .split("")
      .map(Number)
  );
}
const result = new Set();
const pos = Array.from(Array(counts), () => []);
const stack = [];
let c = 0;
for (let i = 0; i < s.length; i++) {
  if (s[i] === "(") {
    pos[c][0] = i;
    stack.push(["(", c++]);
  } else if (s[i] === ")") {
    const top = stack.pop();
    pos[top[1]][1] = i;
  }
}
for (let i = 0; i < arr.length; i++) {
  const temp = s.split("");
  for (let j = 0; j < counts; j++) {
    if (arr[i][j] === 0) {
      temp[pos[j][0]] = "";
      temp[pos[j][1]] = "";
    }
  }
  result.add(temp.join(""));
}
console.log([...result].sort((a, b) => (a < b ? -1 : 1)).join("\n"));
