/*
 - https://www.acmicpc.net/problem/1935
 - 실버3
 - 스택
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const notation = input[1].split("");
const operand = {};
input.slice(2).forEach((num, i) => {
  operand[String.fromCharCode("A".charCodeAt() + i)] = +num;
});

const isOperand = (v) => {
  return Number.isInteger(Number(operand[v]));
};

const stack = [];
notation.forEach((c) => {
  if (isOperand(c)) {
    stack.push(operand[c]);
  } else {
    let result;
    const operand2 = stack.pop();
    const operand1 = stack.pop();

    if (c === "*") {
      result = operand1 * operand2;
    } else if (c === "/") {
      result = operand1 / operand2;
    } else if (c === "+") {
      result = operand1 + operand2;
    } else if (c === "-") {
      result = operand1 - operand2;
    }

    stack.push(result);
  }
});

console.log(stack.pop().toFixed(2));
