package za.co.bbd.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTester {

    public static void main(String[] args) {
        while (true) {
            Random random = new Random();
            // Generate a list of random task
            List<Task> values = new ArrayList<>();
            IntStream.range(1, 20).forEach(i -> values.add(new Task("Task" + random.nextInt(10), random.nextInt(10))));

            // get a list of the distinct task summary field
            List<String> resultList = values.stream().filter(t -> t.getDuration() > 5).map(t -> t.getSummary())
                    .distinct().collect(Collectors.toList());
            System.out.println(resultList);

            // get a concatenated string of Task with a duration longer than 5 hours
            String collect = values.stream().filter(t -> t.getDuration() > 5).map(t -> t.getSummary()).distinct()
                    .collect(Collectors.joining("-"));
            System.out.println(collect);
        }
    }

}