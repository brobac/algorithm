let N = +require('fs').readFileSync(0).toString();
let i = 1;
let result = 0;
while(0 < N){
    if(N < i) i = 1;
    N -= i++;
    result++;
}
console.log(result);