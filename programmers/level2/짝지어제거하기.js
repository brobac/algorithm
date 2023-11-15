/**
 * 2023.11.15(수)
 */

// 1트 코드 (효율성 테스트 실패)
const solution = (s) => {
  if (s.length % 2 === 1) return 0;

  const l = s.split("");
  let i = 0;
  while (true) {
    if (l.length === 0 || i === l.length - 1) break;
    if (l[i] === l[i + 1]) {
      l.splice(i, 2);
      i = 0;
    } else {
      i++;
    }
  }
  return l.length ? 0 : 1;
};

// 2트 검색 후 코드 (통과)
const solution2 = (s) => {
  if (s.length % 2 === 1) return 0;

  const result = [];
  for (let i = 0; i < s.length; i++) {
    if (result.length === 0) result.push(s[i]);
    else if (result[result.length - 1] === s[i]) result.pop();
    else result.push(s[i]);
  }
  return result.length ? 0 : 1;
};

solution2("cdcd");
