import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");

        //Using the Reduce API
        Stream<String> stream = valueList.stream();
        stream.reduce((first, second) -> second)
                .orElse(null);

        //Using the Skip Function
        Stream<String> stream1 = valueList.stream();
        System.out.println(stream1.skip(valueList.size() - 1).findFirst().get());

        int[] arr = {1,2,3,4,5,6,7};
        Arrays.stream(arr)
                .sorted()
                .forEach(a -> System.out.println(a));

    }
}
