v=require('fs').readFileSync(0).toString().trim().split('\n');
n=+v[0];
console.log(v[1].split(" ").map(Number).reduce((s,v)=>s+Math.min(v,n),0))
