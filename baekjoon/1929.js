const [m, n] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split(" ")
  .map((v) => +v);

const arr = Array.from(Array(n + 1), (_, i) => i);
const isPrime = (n) => {
  if (n < 2) return false;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) return false;
  }

  return true;
};

for (let i = 2; i <= Math.sqrt(n); i++) {
  if (!arr[i]) continue;

  if (!isPrime(i)) arr[i] = false;
  for (let j = 2; j * i <= n; j++) {
    arr[i * j] = false;
  }
}

console.log(
  arr
    .slice(m, n + 1)
    .filter((v) => v)
    .join("\n")
);
