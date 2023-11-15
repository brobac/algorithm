const input = require("fs").readFileSync("test.txt").toString().trim();

const list = [];

for (let i = 1; i < input.length - 1; i++) {
  for (let j = i + 1; j < input.length; j++) {
    list.push(
      [input.slice(0, i), input.slice(i, j), input.slice(j)]
        .map((v) => v.split("").reverse().join(""))
        .join("")
    );
  }
}

list.sort();
console.log(list[0]);
