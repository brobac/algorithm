const [a,b] = require("fs").readFileSync(0).toString().trim().split("\n").map(BigInt);
console.log((a+b).toString())