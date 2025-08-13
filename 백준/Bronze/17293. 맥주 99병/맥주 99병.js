n = +require('fs').readFileSync(0).toString();
for(let i = n; 1 < i; i--){
    console.log(`${i} bottles of beer on the wall, ${i} bottles of beer.`);
    console.log(`Take one down and pass it around, ${i-1} bottle${i-1>1 ? "s":""} of beer on the wall.`);
    console.log();
}
console.log("1 bottle of beer on the wall, 1 bottle of beer.");
console.log("Take one down and pass it around, no more bottles of beer on the wall.");
console.log();
console.log("No more bottles of beer on the wall, no more bottles of beer.");
console.log(`Go to the store and buy some more, ${n} bottle${1<n ? "s":""} of beer on the wall.`);