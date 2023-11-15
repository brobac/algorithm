const nums = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((v) => +v)
  .sort((a, b) => a - b);

const total = nums.reduce((s, c) => s + c, 0);
const diff = total - 100;
const ans = [];
outer: for (let i = 0; i < nums.length - 1; i++) {
  for (let j = i + 1; j < nums.length; j++) {
    if (nums[i] + nums[j] === diff) {
      ans.push(i);
      ans.push(j);
      break outer;
    }
  }
}

for (let i = 0; i < nums.length; i++) {
  if (!ans.includes(i)) console.log(nums[i]);
}
