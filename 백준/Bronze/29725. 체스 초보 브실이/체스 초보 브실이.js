const v = {
  K: 0,
  k: 0,
  P: 1,
  p: -1,
  N: 3,
  n: -3,
  B: 3,
  b: -3,
  R: 5,
  r: -5,
  Q: 9,
  q: -9,
  "\n": 0,
  ".": 0,
};

let score = 0;
require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split("")
  .forEach((c) => (score += v[c]));
console.log(score);