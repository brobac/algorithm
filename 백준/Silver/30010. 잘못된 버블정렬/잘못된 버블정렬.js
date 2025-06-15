const n=+require('fs').readFileSync(0).toString();
let result = n + " ";
for(let i = 1; i<n; i++){
    result += i + " ";
}
console.log(result);