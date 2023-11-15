const s = "CAMBRIDGE".split("");
console.log(
  require("fs")
    .readFileSync("test.txt")
    .toString()
    .trim()
    .split("")
    .filter((v) => !s.some((c) => c === v))
    .join("")
);
