const [a,b,c,d] = require('fs').readFileSync(0).toString().trim().split(/\s+/).map(Number);
console.log(Math.min(a+d,b+c));