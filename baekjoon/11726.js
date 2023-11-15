const n = +require("fs").readFileSync("test.txt").toString().trim();
if (n < 3) {
  console.log(n);
  return;
}
const ans = [0, 1, 2];
