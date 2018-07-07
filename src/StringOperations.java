import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StringOperations {
    public static void main(String[] args) {

        System.out.println(Arrays.asList("Hi","Hello").stream().collect(joining(",")));

        String splitString = "Split the numbers 1,2,3,4,5";
        System.out.println(Stream.of(splitString.split(","))
                .map(ele -> ele)
                .collect(Collectors.joining("|","[","]")));

        String hello = "Hello";
        List<Character> list = hello.chars().mapToObj(e -> (char)e)
                .collect(toList());
        System.out.println(list);
    }
}
