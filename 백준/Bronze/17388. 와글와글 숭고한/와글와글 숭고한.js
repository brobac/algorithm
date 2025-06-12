const u = ["Soongsil","Korea","Hanyang"];
const n = require('fs').readFileSync(0).toString().trim().split(" ").map(Number);
const sum = n.reduce((s,c)=> s+c,0);

if(100 <= sum){
    console.log("OK");
    return;
}
let minIdx = 0;
n.forEach((v,i)=> {
    if(n[i] < n[minIdx]){
        minIdx = i;
}
});

console.log(u[minIdx]);