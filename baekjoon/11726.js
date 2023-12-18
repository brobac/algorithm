const ans = [0, 1, 2, 3];
ans.length = 1001;
const a = +require("fs").readFileSync("test.txt").toString().trim();
const solution = (n) => {
  if (!ans[n - 2]) solution(n - 2);
  if (!ans[n - 1]) solution(n - 1);
  ans[n] = (ans[n - 2] + ans[n - 1]) % 10007;
};

solution(a);
console.log(ans[a]);
