console.log(require("fs").readFileSync(0).toString().trim().split("\n").slice(0,-1).map(l=>{
    const [a,b] = l.split(" ").map(Number);
    return a > b ? "Yes" : "No";
}).join("\n")) 