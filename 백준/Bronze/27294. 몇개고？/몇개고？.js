const [T,S] = require("fs").readFileSync(0).toString().trim().split(" ").map(Number);
console.log(12<=T && T<=16 && S === 0 ? 320 : 280);