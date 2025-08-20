input=require('fs').readFileSync(0).toString().trim().split("\n");
console.log([...input[1]].filter(v=>v===input[2]).length);