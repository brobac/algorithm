function solution(n) {
  let count = 0;
  let d = 1;
  while (0 < n) {
    if (n % d === 0) count++;
    n -= d;
    d += 1;
  }
  return count;
}

console.log(solution(15));
