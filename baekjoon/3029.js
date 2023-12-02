/*
 - https://www.acmicpc.net/problem/3029
 - 브론즈3
 - 수학, 구현, 문자열, 사칙연산
 */
const [[ch, cm, cs], [th, tm, ts]] = require("fs")
  .readFileSync("test.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(":").map(Number));

const daySeconds = 24 * 3600;
const targetTotalSeconds = th * 3600 + tm * 60 + ts;
const currentTotalSeconds = ch * 3600 + cm * 60 + cs;

const secondsToHHMMSS = (seconds) => {
  const h =
    Math.trunc(seconds / 3600) < 10
      ? "0" + Math.trunc(seconds / 3600)
      : Math.trunc(seconds / 3600);
  seconds -= Math.trunc(seconds / 3600) * 3600;
  const m =
    Math.trunc(seconds / 60) < 10
      ? "0" + Math.trunc(seconds / 60)
      : Math.trunc(seconds / 60);
  seconds -= Math.trunc(seconds / 60) * 60;
  const s = seconds < 10 ? "0" + seconds : seconds;
  return `${h}:${m}:${s}`;
};

if (currentTotalSeconds < targetTotalSeconds)
  console.log(secondsToHHMMSS(targetTotalSeconds - currentTotalSeconds));
else
  console.log(
    secondsToHHMMSS(daySeconds - currentTotalSeconds + targetTotalSeconds)
  );
