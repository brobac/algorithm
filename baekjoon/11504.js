/*
newArr 만들지 말고 Arr에 index 라운드로빈으로 접근하는 방법 생각해보기
*/

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

// 1. 처음 작성한 코드
const solution1 = () => {
  const T = parseInt(input[0]);
  for (let i = 1; i < input.length; i += 4) {
    const [N, M] = input[i].split(" ").map(Number);
    const X = parseInt(input[i + 1].replaceAll(" ", ""));
    const Y = parseInt(input[i + 2].replaceAll(" ", ""));
    const arr = input[i + 3].split(" ").map(Number);
    const newArr = [...arr, ...arr.slice(0, N - 1)];
    let count = 0;

    for (let i = 0; i < N; i++) {
      const Z = parseInt(newArr.slice(i, i + M).join(""));
      if (X <= Z && Z <= Y) count++;
    }
    console.log(count);
  }
};

// 2. Z를 라운드로빈으로 구한 방법
const solution2 = () => {
  const T = parseInt(input[0]);
  for (let i = 1; i < input.length; i += 4) {
    const [N, M] = input[i].split(" ").map(Number);
    const X = parseInt(input[i + 1].replaceAll(" ", ""));
    const Y = parseInt(input[i + 2].replaceAll(" ", ""));
    const arr = input[i + 3].split(" ").map(Number);
    let count = 0;

    for (let i = 0; i < N; i++) {
      const temp = [];
      for (let j = 0; j < M; j++) {
        temp.push(arr[(i + j) % N]);
      }
      console.log(temp);
      const Z = parseInt(temp.join(""));
      if (X <= Z && Z <= Y) count++;
    }
    console.log(count);
  }
};
