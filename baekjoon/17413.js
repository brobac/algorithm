/*
 - https://www.acmicpc.net/problem/17413
 - 실버3
 - 구현, 자료구조, 문자열, 스택
 */
const s = require("fs").readFileSync("test.txt").toString().trim();
const result = [];
let i = 0;
while (i < s.length) {
  if (s[i] === "<") {
    while (s[i] !== ">") {
      result.push(s[i]);
      i++;
    }
    result[i] = s[i];
    i++;
  } else {
    const temp = [];
    while (i < s.length && s[i] !== " " && s[i] !== "<") {
      temp.push(s[i]);
      i++;
    }
    for (let i = temp.length - 1; 0 <= i; i--) {
      result.push(temp[i]);
    }
    if (s[i] === " ") {
      result.push(" ");
      i++;
    }
  }
}
console.log(result.join(""));
