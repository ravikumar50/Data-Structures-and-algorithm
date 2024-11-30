import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int L = Integer.parseInt(input[2]);

            List<Event> events = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                events.add(new Event(a, b, 1));
            }

            for (int i = 0; i < m; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                events.add(new Event(a, b, 0));
            }

            events.sort(Comparator.comparingInt(e -> e.a));

            int k = 1;
            PriorityQueue<Integer> powerQueue = new PriorityQueue<>(Collections.reverseOrder());

            boolean possible = true;
            for (Event e : events) {
                if (e.type == 0) {
                    powerQueue.add(e.b);
                } else {
                    while (!powerQueue.isEmpty() && k < e.b - e.a + 2) {
                        k += powerQueue.poll();
                    }
                    if (k < e.b - e.a + 2) {
                        result.append("-1\n");
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                result.append(m - powerQueue.size()).append("\n");
            }
        }

        System.out.print(result);
    }

    static class Event {
        int a, b, type;

        Event(int a, int b, int type) {
            this.a = a;
            this.b = b;
            this.type = type;
        }
    }
}
