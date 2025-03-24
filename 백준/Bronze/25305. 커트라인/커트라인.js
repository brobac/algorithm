const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N,k] = input[0].split(" ").map(Number);
console.log(input[1].split(" ").map(Number).sort((a,b)=> b-a)[k-1]);