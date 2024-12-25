const input = require("fs").readFileSync(0).toString().trim().split("\n");
const rail = +input[0];
const flight = input[1].split(" ").map(Number).reduce((sum,cur)=> sum+cur,0);
console.log(rail <= flight || rail <= 240 ? "high speed rail" : "flight");