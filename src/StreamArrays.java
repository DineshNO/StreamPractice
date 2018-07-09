import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArrays {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4);
        Integer[] array = stream.toArray(Integer[]::new);

        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
        IntStream intStream = IntStream.of(1,2,3,4);
        int[] arrayInt = intStream.toArray();

        for (int i=0; i<arrayInt.length; i++) {
            System.out.println(arrayInt[i]);
        }
    }
}