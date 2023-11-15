const isPrime = (n) => {
  if (n < 2) return false;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) return false;
  }

  return true;
};

const count = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")[1]
  .split(" ")
  .map((v) => +v)
  .filter((v) => isPrime(v)).length;

console.log(count);
