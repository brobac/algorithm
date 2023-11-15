const origin = +require("fs").readFileSync("test.txt").toString().trim();
let count = 0;
let copyNum = origin;
let newNum = 0;

while (true) {
  newNum =
    (copyNum % 10) * 10 + ((Math.trunc(copyNum / 10) + (copyNum % 10)) % 10);
  count++;
  if (origin === newNum) break;
  copyNum = newNum;
}
console.log(count);
