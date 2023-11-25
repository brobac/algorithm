/*
 - https://www.acmicpc.net/problem/10816
 - 실버4
 - 자료구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵
 처음 푼 방법
 target 순서대로 출력해야되서 pos에다가 숫자를 키로하고 값을 배열로 해서
 target에 중복된 숫자가 있더라도 체크할 수 있게 했다
 card 숫자를 키로 pos의 값(배열을) 가져와서 순회하면서
 해당 index에 카운트를 1씩 증가시켰다.
 시간초과가 났다.
 최악의 경우를 생각해보면 카드(N) 50만개, 목표(M) 50만개에서
 n이 모두 같은 수, m 이 모두 같은 수 이면
 카드 1번 체크할 때 마다 50만번 카운트를 증가시켜야한다.
 그래서 카드 1번 체크할 때 배열에 첫번째 인덱스 카운트만 증가시키고
 카드 순회가 끝난 다음에 pos에 있는 배열들을 순회해서 첫번째 카운트(최종결과값)
 을 할당해서 쓰는 방법으로 했더니 통과됐다.
 */

const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const cards = input[1].split(" ").map(Number);
const targets = input[3].split(" ").map(Number);

const pos = {};
targets.forEach((v, i) => {
  if (Array.isArray(pos[v])) {
    pos[v].push(i);
  } else {
    pos[v] = [i];
  }
});
const result = Array(targets.length).fill(0);
cards.forEach((v) => {
  if (!!pos[v]) {
    result[pos[v][0]]++;
  }
});
Object.values(pos).forEach((arr) =>
  arr.forEach((v, i) => {
    if (i !== 0) {
      result[v] = result[arr[0]];
    }
  })
);
console.log(result.join(" "));
