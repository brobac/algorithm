const n = +require("fs").readFileSync("test.txt").toString().trim();

const isPrime = (n) => {
  if (n < 2) return false;

  for (let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) return false;
  }

  return true;
};

const arr = Array.from(Array(n + 1), (_, i) => i);
arr[1] = false;

for (let i = 0; i <= Math.sqrt(n); i++) {
  if (!arr[i]) continue;

  if (!isPrime(i)) arr[i] = false;

  for (let j = 2; j * i <= n; j++) {
    arr[i * j] = false;
  }
}
const primes = arr.filter((v) => v);

let left = 0;
let sum = 0;
let count = 0;

for (let right = 0; right < primes.length; right++) {
  sum += primes[right];
  while (sum > n) {
    sum -= primes[left];
    left++;
  }
  if (sum === n) count++;
}

// while (true) {
//   if (sum === n) {
//     count++;
//     sum -= primes[i];
//     i++;
//     if (j < primes.length - 1) {
//       j++;
//       sum += primes[j];
//     }
//   } else if (sum < n) {
//     if (j === primes.length - 1) break;
//     if (j < primes.length - 1) {
//       j++;
//       sum += primes[j];
//     }
//   } else {
//     sum -= primes[i];
//     i++;
//   }
// }
console.log(primes);
console.log(count);
