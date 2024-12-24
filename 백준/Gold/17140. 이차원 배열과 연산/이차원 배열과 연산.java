import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()) - 1;
        int C = Integer.parseInt(st.nextToken()) - 1;
        int K = Integer.parseInt(st.nextToken());


        ArrayList<Integer>[] rowList = new ArrayList[3];
        ArrayList<Integer>[] colList = new ArrayList[3];

        for (int r = 0; r < 3; r++) {
            rowList[r] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                rowList[r].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int r = 0; r < 3; r++) {
            colList[r] = new ArrayList<>();
            for (int c = 0; c < 3; c++) {
                colList[r].add(rowList[c].get(r));
            }
        }


        int rMax = 3;
        int cMax = 3;
        int time = 0;
        while (time <= 100) {

            if (R < rMax && C < cMax && rowList[R].get(C) == K) {
                System.out.println(time);
                return;
            }

            if (cMax <= rMax) {
                cMax = 0;

                // 각 행에대하여 정렬
                for (int r = 0; r < rMax; r++) {
                    int[] count = new int[101];
                    for (int v : rowList[r]) {
                        count[v]++;
                    }
                    ArrayList<int[]> temp = new ArrayList<>();
                    for (int i = 1; i <= 100; i++) {
                        if (count[i] == 0) continue;
                        temp.add(new int[]{i, count[i]});
                    }
                    temp.sort((a, b) -> {
                        if (a[1] == b[1]) {
                            return a[1] - b[1];
                        }
                        return a[1] - b[1];
                    });
                    rowList[r].clear();
                    for (int[] t : temp) {
                        rowList[r].add(t[0]);
                        rowList[r].add(t[1]);
                    }
                    cMax = Math.max(cMax, rowList[r].size());

                }

                // 0 채우기
                for (int r = 0; r < rMax; r++) {
                    for (int i = rowList[r].size(); i < cMax; i++) {
                        rowList[r].add(0);
                    }
                }
                colList = new ArrayList[cMax];
                for (int i = 0; i < cMax; i++) {
                    colList[i] = new ArrayList<>();
                }

                for (int r = 0; r < rMax; r++) {
                    for (int c = 0; c < cMax; c++) {
                        colList[c].add(rowList[r].get(c));
                    }

                }

            } else {
                rMax = 0;
                for (int r = 0; r < cMax; r++) {
                    int[] count = new int[101];
                    for (int v : colList[r]) {
                        count[v]++;
                    }
                    ArrayList<int[]> temp = new ArrayList<>();
                    for (int i = 1; i <= 100; i++) {
                        if (count[i] == 0) continue;
                        temp.add(new int[]{i, count[i]});
                    }
                    temp.sort((a, b) -> {
                        if (a[1] == b[1]) {
                            return a[1] - b[1];
                        }
                        return a[1] - b[1];
                    });
                    colList[r].clear();
                    for (int[] t : temp) {
                        colList[r].add(t[0]);
                        colList[r].add(t[1]);
                    }
                    rMax = Math.max(rMax, colList[r].size());

                }
                for (int c = 0; c < cMax; c++) {
                    for (int r = colList[c].size(); r < rMax; r++) {
                        colList[c].add(0);
                    }
                }

                rowList = new ArrayList[rMax];
                for (int i = 0; i < rMax; i++) {
                    rowList[i] = new ArrayList<>();
                }
                for (int r = 0; r < cMax; r++) {
                    for (int c = 0; c < rMax; c++) {
                        rowList[c].add(colList[r].get(c));
                    }

                }


            }

            time++;
        }

        System.out.println(-1);

    }
}