input = require('fs').readFileSync(0).toString().trim().split('\n').map(l=>l.split(' ').map(Number));
result=[];
n=input[0][0];
for(i = 1; i<=n; i++){
    arr=input[2*i];
    result.push((Math.max(...arr)-Math.min(...arr))*2);
}
console.log(result.join('\n'));