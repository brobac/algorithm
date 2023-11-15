const t = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((v) => +v);

const maxNum = Math.max(...t);

const arr = Array.from(Array(maxNum + 1), (_, i) => i);
arr[1] = false;
const isPrime = (n) => {
  if (n < 2) return false;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) return false;
  }

  return true;
};

for (let i = 2; i <= Math.sqrt(maxNum); i++) {
  if (arr[i] === false) continue;

  if (!isPrime(i)) arr[i] = false;
  for (let j = 2; j * i <= maxNum; j++) {
    arr[i * j] = false;
  }
}

t.forEach((target) => {
  const primes = arr.slice(0, target + 1).filter((v) => v);
  const ans = [];

  let a = 0;
  let b = 0;

  while (!(a === primes.length - 1 && b === primes.length - 1)) {
    const sum = primes[a] + primes[b];

    if (sum === target) {
      ans.push([a, b]);
      if (b === primes.length - 1) {
        a++;
        b = a;
      } else {
        b++;
      }
    } else if (sum < target) {
      if (b === primes.length - 1) {
        a++;
        b = a;
      } else {
        b++;
      }
    } else {
      a++;
      b = a;
    }
  }
  console.log(ans[ans.length - 1].map((v) => primes[v]).join(" "));
});
