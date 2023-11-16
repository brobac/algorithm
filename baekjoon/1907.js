const [a, b, c] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .replace(/[+ | =]/g, " ")
  .split(" ");

const getCounts = (s) => {
  const result = { C: 0, H: 0, O: 0 };
  for (let i = 0; i < s.length; i++) {
    if (Number.isInteger(parseInt(s[i]))) continue;

    if (Number.isInteger(parseInt(s[i + 1]))) {
      result[s[i]] += parseInt(s[i + 1]);
      i++;
    } else {
      result[s[i]]++;
    }
  }
  return result;
};

const aCounts = getCounts(a);
const bCounts = getCounts(b);
const cCounts = getCounts(c);

for (let i = 1; i <= 10; i++) {
  for (let j = 1; j <= 10; j++) {
    for (let k = 1; k <= 10; k++) {
      if (
        aCounts.C * i + bCounts.C * j === cCounts.C * k &&
        aCounts.H * i + bCounts.H * j === cCounts.H * k &&
        aCounts.O * i + bCounts.O * j === cCounts.O * k
      ) {
        console.log(i, j, k);
        return;
      }
    }
  }
}
