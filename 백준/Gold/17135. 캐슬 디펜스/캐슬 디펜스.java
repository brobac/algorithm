import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, remain, result = 0, enemyCount = 0;
	static int[][] arr;
	static int[] selected = new int[3];
	static ArrayList<int[]> selectedList = new ArrayList<>();
	static Pos[] archerPosList;

	static void combination(int cnt, int start) {
		if (cnt == 3) {
			selectedList.add(Arrays.copyOf(selected, 3));
			return;
		}

		for (int i = start; i < M; i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	static int[][] copyArr() {
		int[][] result = new int[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				result[row][col] = arr[row][col];
			}
		}
		return result;
	}

	static Pos getTargetPos(int[][] map, int archerIdx) {
		Pos archerPos = archerPosList[archerIdx];

		Pos targetPos = new Pos(0, 0);
		int minDistance = 100;

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (map[row][col] == 0) {
					continue;
				}
				int distance = Math.abs(row - archerPos.row) + Math.abs(col - archerPos.col);

				if (distance <= D && distance <= minDistance) {
					if (distance < minDistance) {
						targetPos = new Pos(row, col);
						minDistance = distance;
					} else if (col < targetPos.col) {
						targetPos = new Pos(row, col);
					}
				}
			}
		}

		return minDistance == 100 ? null : targetPos;
	}

	static void moveEnemy(int[][] map) {
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (map[N - 1][i] == 1) {
				count++;
			}
		}
		remain -= count;
		for (int row = N - 1; 0 < row; row--) {
			for (int col = 0; col < M; col++) {

				map[row][col] = map[row - 1][col];
			}
		}
		for (int i = 0; i < M; i++) {
			map[0][i] = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// 격자판 채우기
		arr = new int[N][M];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < M; col++) {
				int num = Integer.parseInt(st.nextToken());
				arr[row][col] = num;
				if (num == 1) {
					enemyCount++;
				}
			}
		}

		archerPosList = new Pos[M];
		for (int i = 0; i < M; i++) {
			archerPosList[i] = new Pos(N, i);
		}

		// 궁수가 배치될 수 있는 조합 만들기
		combination(0, 0);
		for (int[] archers : selectedList) {
			remain = enemyCount;
			int[][] map = copyArr();
			int count = 0;
			while (0 < remain) {
				int temp = 0;
				ArrayList<Pos> targetPosList = new ArrayList<>();
				// 공격할 적 위치 찾기
				for (int archer : archers) {
					Pos pos = getTargetPos(map, archer);
					if (pos != null) {
						targetPosList.add(pos);
					}
				}

//				System.out.println("----- 공격 전 -----");
//				for (int[] row : map) {
//					System.out.println(Arrays.toString(row));
//				}

				// 공격
				for (Pos pos : targetPosList) {
					if (map[pos.row][pos.col] == 1) {
						map[pos.row][pos.col] = 0;
						temp++;
					}
				}
//				System.out.println("----- 공격 후 -----");
//				for (int[] row : map) {
//					System.out.println(Arrays.toString(row));
//				}

				remain -= temp;
				count += temp;
				// 공격 종료. 적 이동
				moveEnemy(map);

//				System.out.println("----- 적 이동 후 -----");
//				for (int[] row : map) {
//					System.out.println(Arrays.toString(row));
//				}
//				System.out.println();
//				System.out.println();
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}

	static class Pos {
		int row, col;

		public Pos() {

		}

		public Pos(int r, int c) {
			row = r;
			col = c;
		}
	}
}