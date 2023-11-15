const [A, B, C, N] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

if (N % A === 0 || N % B === 0 || N % C === 0) {
  console.log(1);
  return;
}

for (let i = 0; i <= N / A; i++) {
  for (let j = 0; j <= N / B; j++) {
    for (let k = 0; k <= N / C; k++) {
      if (A * i + B * j + C * k === N) {
        console.log(1);
        return;
      }
    }
  }
}

console.log(0);
