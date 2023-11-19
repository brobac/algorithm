const arr = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .slice(1)
  .map((v) => v.split(" "));

for (let i = 0; i < arr.length; i++) {
  const [a, b] = arr[i];
  if (a.length !== b.length) {
    console.log("Impossible");
    return;
  }

  const counts = {};
  let possible = true;

  for (let j = 0; j < a.length; j++) {
    if (counts[a[j]]) counts[a[j]]++;
    else counts[a[j]] = 1;
  }

  for (let j = 0; j < b.length; j++) {
    if (!counts[b[j]]) {
      possible = false;
      break;
    } else {
      counts[b[j]]--;
    }
  }
  if (Object.values(counts).some((v) => v !== 0)) {
    possible = false;
  }

  if (possible) console.log("Possible");
  else console.log("Impossible");
}
