const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");

const tcCount = +input[0];
let sizeInputIndex = 1;
let positionInputIndex = 2;
for (let i = 0; i < tcCount; i++) {
  const [w, h, c] = input[sizeInputIndex].split(" ").map((v) => +v);
  const 밭 = Array.from(Array(w), () => Array(h).fill(false));
  const visited = Array.from(Array(w), () => Array(h).fill(false));
  const 배추 = input
    .slice(positionInputIndex, positionInputIndex + c)
    .map((p) => p.split(" ").map((v) => +v));
  배추.forEach((v) => {
    const [x, y] = v;
    밭[x][y] = true;
  });

  const dfs = (p) => {
    const [x, y] = p;
    visited[x][y] = true;
    [
      [x - 1, y],
      [x + 1, y],
      [x, y - 1],
      [x, y + 1],
    ]
      .filter((v) => {
        const [a, b] = v;
        if (a < 0 || w <= a) return false;
        if (b < 0 || h <= b) return false;
        return 밭[a][b] === true;
      })
      .forEach((v) => {
        const [a, b] = v;
        if (!visited[a][b]) {
          dfs(v);
        }
      });
  };
  let count = 0;
  배추.forEach((v) => {
    const [x, y] = v;
    if (!visited[x][y]) {
      count++;
      dfs(v);
    }
  });

  console.log(count);

  sizeInputIndex += c + 1;
  positionInputIndex += c + 1;
  // const dfs = (i) => {
  //   visited(i).set(true);
  // };
}

/*
1. 인접리스트 만들기
2. 인접리스트 처음부터 시작해서 dfs 하면서 dfs 횟수 카운트하기
3. 카운트 출력 

 */
