v=require('fs').readFileSync(0).toString().trim().split('\n');
n=+v[0];
[a,b]=v[1].split(' ').map(Number);
console.log(Math.min(n,Math.trunc(a/2)+b));