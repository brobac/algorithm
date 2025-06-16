const odd = require('fs').readFileSync(0).toString().trim().split('\n').map(Number).filter(v=>v%2===1);
if(odd.length === 0){
    console.log(-1);
    return;
}
console.log(odd.reduce((s,c)=>s+c,0));
console.log(Math.min(...odd));