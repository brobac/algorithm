console.log(require("fs").readFileSync(0).toString().trim().split("\n").slice(0,-1).map(l=>{
    const [name, age, weight] = l.split(" ");
    return `${name} ${17< age || 80<= weight ? "Senior" : "Junior"}`
}).join("\n"))

