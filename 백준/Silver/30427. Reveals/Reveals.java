import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        TreeSet<String> room = new TreeSet<>();
        Set<String> see = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.equals("dongho")) {
                System.out.println("dongho");
                return;
            }
            room.add(s);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            room.remove(br.readLine());
        }

        if (room.size() == 1) {
            System.out.println(room.first());
            return;
        }

        if (room.contains("bumin")) {
            System.out.println("bumin");
            return;
        }

        if (room.contains("cake")) {
            System.out.println("cake");
            return;
        }

        if (room.contains("lawyer")) {
            System.out.println("lawyer");
            return;
        }

        if (!room.isEmpty()) {
            System.out.println(room.first());
            return;
        }
        if (room.isEmpty()) {
            System.out.println("swi");
        }
    }
}