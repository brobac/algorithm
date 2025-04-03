const board = [
    "A B C D E F G H J L M",
    "A C E F G H I L M",
    "A C E F G H I L M",
    "A B C E F G H L M",
    "A C E F G H L M",
    "A C E F G H L M",
    "A C E F G H L M",
    "A C E F G H L M",
    "A C E F G H L M",
    "A B C F G H L M",
];

const N = require("fs").readFileSync(0).toString()-1;

console.log(Math.ceil(board[N].length/2));
console.log(board[N]);