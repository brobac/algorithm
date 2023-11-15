const [b, d, j] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(" ").map((n) => +n));

const dtime = Math.abs(d[0] - j[0]) + Math.abs(d[1] - j[1]);
const btime = Math.max(Math.abs(b[0] - j[0]), Math.abs(b[1] - j[1]));

if (btime < dtime) {
  console.log("bessie");
} else if (dtime < btime) {
  console.log("daisy");
} else {
  console.log("tie");
}
