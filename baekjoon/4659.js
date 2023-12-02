/*
 - https://www.acmicpc.net/problem/4659
 - 실버5
 - 구현, 문자열
 함수호출 isVowel()로 해야되는데 isVowel[]로 오타쳐나서 찾는데 10분걸렸다
 */
const passwords = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(0, -1);

const VOWELS = ["a", "e", "i", "o", "u"];
const isVowel = (c) => VOWELS.includes(c);
const isAcceptablePW = (pw) => {
  //1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
  const includeVowel = 0 < pw.split("").filter(isVowel).length;
  if (!includeVowel) return false;

  //2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
  for (let i = 0; i < pw.length - 2; i++) {
    if (isVowel(pw[i]) && isVowel(pw[i + 1]) && isVowel(pw[i + 2])) {
      return false;
    }
    if (!isVowel(pw[i]) && !isVowel(pw[i + 1]) && !isVowel(pw[i + 2])) {
      return false;
    }
  }

  //3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
  for (let i = 0; i < pw.length - 1; i++) {
    if (pw[i] !== "e" && pw[i] !== "o" && pw[i] === pw[i + 1]) return false;
  }

  return true;
};
for (let i = 0; i < passwords.length; i++) {
  const pw = passwords[i];

  if (isAcceptablePW(pw)) console.log(`<${pw}> is acceptable.`);
  else console.log(`<${pw}> is not acceptable.`);
}
