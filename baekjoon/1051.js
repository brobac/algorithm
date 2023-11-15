/*
처음에는 min === 1 이면 console.log(1) 하고 return 끝하고 2*2 사이즈 부터 반복하려했는데
이런건 최적화가 아니라고 했던 강사님의 말이 생각나서 그냥 하나에 로직으로 처리할 수 있도록 했다.
그래도 같은 사이즈에서는 꼭짓점 값이 같은게 여러개여도 출력 값은 동일하기 때문에 하나 찾으면 바로 break했다. 
 */
const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const [N, M] = input[0].split(" ").map(Number);
const arr = input.slice(1).map((line) => line.split("").map(Number));
let result = 1;

const min = Math.min(N, M);
// 정사각형 크기 조절
for (let i = 0; i < min; i++) {
  // 행
  loop2: for (let j = 0; j < N - i; j++) {
    //열
    for (let k = 0; k < M - i; k++) {
      if (
        arr[j][k] === arr[j][k + i] &&
        arr[j][k] === arr[j + i][k] &&
        arr[j][k] === arr[j + i][k + i]
      ) {
        result = Math.pow(i + 1, 2);
        break loop2;
      }
    }
  }
}
console.log(result);
