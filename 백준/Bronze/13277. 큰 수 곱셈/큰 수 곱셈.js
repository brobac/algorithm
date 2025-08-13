const [a,b] = require('fs').readFileSync(0).toString().trim().split(" ").map(BigInt);
console.log((a*b).toString());