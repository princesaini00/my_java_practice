import java.util.*;

public class ListBenchmark {
    public static void main(String[] args) {
        int n = 10_000;

        // Benchmark ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.add(i);
        long end = System.nanoTime();
        System.out.println("ArrayList add time: " + (end - start) / 100000 + " million ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.get(i);
        end = System.nanoTime();
        System.out.println("ArrayList get time: " + (end - start)/ 100000 + " million ns");

        // Benchmark LinkedList
        List<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.add(i);
        end = System.nanoTime();
        System.out.println("LinkedList add time: " + (end - start)/ 100000 + " million ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.get(i);
        end = System.nanoTime();
        System.out.println("LinkedList get time: " + (end - start)/ 100000 + " million ns");
    }
}
