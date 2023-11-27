/*
 - https://www.acmicpc.net/problem/20300
 - 실버3
 - 그리디, 정렬

 Bigint 정렬 시 sort((a,b)=> a-b) 로 하면 에러가 난다
 a-b 의 리턴이 Bigint 타입이기 때문에 아래와같이 작성해야된다
 */

const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")[1]
  .split(" ")
  .map(BigInt)
  .sort((a, b) => {
    if (a > b) return 1;
    if (a < b) return -1;
    return 0;
  });

let max = 0n;
if (arr.length % 2 === 1) max = arr.pop();

for (let i = 0, j = arr.length - 1; i < j; i++, j--) {
  let sum = arr[i] + arr[j];
  if (max < sum) max = sum;
}

console.log(max.toString());
