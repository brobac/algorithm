const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const poketmonList = input.slice(1, 1 + n);
const questionList = input.slice(1 + n);
console.log(poketmonList);
console.log(questionList);

const poketmon = {};
poketmonList.forEach((v, i) => (poketmon[v] = i + 1));

questionList.forEach((v) => {
  if (Number.isInteger(Number(v))) {
    console.log(poketmonList[Number(v) - 1]);
  } else {
    console.log(poketmon[v]);
  }
});
