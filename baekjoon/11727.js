const ans = [0, 1, 3, 5];
ans.length = 1001;
const a = +require("fs").readFileSync("test.txt").toString().trim();
const solution = (n) => {
  if (n <= 3) return;
  if (!ans[n - 1]) solution(n - 1);

  if (n % 2 === 0) ans[n] = (ans[n - 1] * 2 + 1) % 10007;
  else ans[n] = (ans[n - 1] * 2 - 1) % 10007;
};

solution(a);
console.log(ans[a]);
