/*
 - https://www.acmicpc.net/problem/1316
 - 실버5
 - 구현, 문자열
 */

const words = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

let result = 0;

for (let i = 0; i < words.length; i++) {
  const word = words[i];
  if (word.length === 1) {
    result++;
    continue;
  }

  let breaked = false;
  const visited = { [word[0]]: true };
  for (let j = 1; j < word.length; j++) {
    if (!visited[word[j]]) {
      visited[word[j]] = true;
    } else if (visited[word[j]] && word[j] !== word[j - 1]) {
      breaked = true;
      break;
    }
  }
  if (!breaked) result++;
}
console.log(result);
