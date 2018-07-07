import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOptionals {
    public static void main(String[] args) {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

        //using map
        List<String> filterUsingMap = listOfOptionals.stream()
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        System.out.println(filterUsingMap);

        List<String> filterUsingFlatMap = listOfOptionals.stream()
                .flatMap(o -> o.isPresent()?Stream.of(o.get()):Stream.empty())
                .collect(Collectors.toList());
        System.out.println(filterUsingFlatMap);

        List<String> filteredList = listOfOptionals.stream()
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
