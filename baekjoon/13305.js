/*
 - https://www.acmicpc.net/problem/13305
 - 실버3
 - 그리디

 거리, 가격이 매우 커서 Number의 범위를 벗어날 수 있다.
 처음에 number로 해서 실패했고 Bigint를 사용해서 통과했다.
 서브테스크 2번에 제약조건이 원래 제약조건보다 거리와 비용이 적다는 점을 보고 캐치했어야됐는데
 다른사람이 질문한 내용을 보고 알아차렸다.
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = Number(input[0]);
const distanceList = input[1].split(" ").map(Number);
const priceList = input[2].split(" ").map(Number);
const mins = [];
let min = priceList[0];
for (let i = 1; i < n - 1; i++) {
  const cur = priceList[i];
  if (cur < min) {
    mins.push([i, cur]);
    min = cur;
  }
}
if (mins.length === 0) {
  const result =
    priceList[0] * distanceList.reduce((sum, cur) => (sum += cur), 0);
  console.log(result);
  return;
}

let result = 0n;
let i = 0;
let price = BigInt(priceList[0]);

mins.forEach((v) => {
  result +=
    price *
    distanceList.slice(i, v[0]).reduce((sum, cur) => (sum += BigInt(cur)), 0n);
  i = v[0];
  price = BigInt(v[1]);
});

// 마지막 제일 싼 비용으로 끝가지 가기
result +=
  price *
  distanceList.slice(i, n).reduce((sum, cur) => (sum += BigInt(cur)), 0n);

console.log(result.toString());
