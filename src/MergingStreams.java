import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MergingStreams {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(4,5,6);
        Stream<Integer> stream2 = Stream.of(1,5,2);
        Stream<Integer> stream3 = Stream.of(3,5,0);
        Stream<Integer> stream4 = Stream.of(6,5,4);

        //using flatmap
        Stream<Integer> mergedStream = Stream.of(stream1,stream2,stream3,stream4)
                                            .flatMap(i -> i);
        System.out.println(mergedStream.collect(toList()));

        Stream<Integer> stream5 = Stream.of(4,5,6);
        Stream<Integer> stream6 = Stream.of(1,5,2);
        Stream<Integer> stream7 = Stream.of(3,5,0);
        System.out.println(Stream.concat(stream5,Stream.concat(stream6,stream7)).collect(toList()));
    }
}
