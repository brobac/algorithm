const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
const n = +input[0];
const s = input[1];
const used = {};
let count = 0;
let max = 0;
let l = 0;
for (let r = 0; r < s.length; r++) {
  if (used[s[r]]) {
    used[s[r]]++;
    max = Math.max(max, r - l + 1);
  } else {
    if (count < n) {
      used[s[r]] ? used[s[r]]++ : (used[s[r]] = 1);

      count++;
      max = Math.max(max, r - l + 1);
    } else {
      used[s[r]] ? used[s[r]]++ : (used[s[r]] = 1);
      count++;
      while (n < count) {
        used[s[l]]--;
        if (used[s[l]] === 0) count--;
        l++;
      }
    }
  }
}
console.log(max);
