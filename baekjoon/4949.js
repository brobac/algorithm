const input = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n");
input.pop();
input.forEach((v) => {
  const l = v.split("");
  const s = [];
  let res = "";
  for (let i = 0; i < l.length; i++) {
    if (l[i] === "(" || l[i] === "[") {
      s.push(l[i]);
    } else if (l[i] === ")") {
      if (s[s.length - 1] === "(") s.pop();
      else {
        res = "no";
        break;
      }
    } else if (l[i] === "]") {
      if (s[s.length - 1] === "[") s.pop();
      else {
        res = "no";
        break;
      }
    }
  }
  if (res === "no") console.log("no");
  else if (s.length === 0) console.log("yes");
  else console.log("no");
});
