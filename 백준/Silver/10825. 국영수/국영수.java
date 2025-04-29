import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student();
            students[i].name = st.nextToken();
            students[i].korean = Integer.parseInt(st.nextToken());
            students[i].english = Integer.parseInt(st.nextToken());
            students[i].math = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        for (Student s : students) {
            bw.write(s.name);
            bw.newLine();
        }
        bw.flush();

    }

    static class Student implements Comparable<Student> {
        String name;
        int korean, english, math;


        @Override
        public int compareTo(Student o) {
            if (korean == o.korean) {
                if (english == o.english) {
                    if (math == o.math) {
                        return name.compareTo(o.name);
                    }
                    return o.math - math;
                }
                return english - o.english;
            }
            return o.korean - korean;
        }
    }
}