import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamGroupingBy {
    public static void main(String[] args) {
        List<BlogPost> posts = Arrays.asList(new BlogPost("Title1", "Author1", BlogPostType.NEWS, 5),
                new BlogPost("Title2", "Author2", BlogPostType.REVIEW, 4),
                new BlogPost("Title3", "Author3", BlogPostType.GUIDE, 2),
                new BlogPost("Title4", "Author1", BlogPostType.NEWS, 3));


        System.out.println();

        //Simple Grouping by a Single Column
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(groupingBy(BlogPost::getType));
        System.out.println(postsPerType);

        //Grouping by with a Complex Map Key Type
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
        System.out.println(postsPerTypeAndAuthor);

        //Modifying the Returned Map Value Type
        Map<BlogPostType, Set<BlogPost>> postsPerTypeSet = posts.stream()
                .collect(groupingBy(BlogPost::getType, toSet()));
        System.out.println(postsPerTypeSet);

        //Providing a Secondary Group By Collector
        Map<String, Map<BlogPostType, List<BlogPost>>> maptomap = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
        System.out.println(maptomap);

        //Getting the Average from Grouped Results
        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));
        System.out.println(averageLikesPerType);

        Map<BlogPostType, Integer> likesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));
        System.out.println(likesPerType);

        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        maxBy(comparingInt(BlogPost::getLikes))));
        System.out.println(maxLikesPerPostType);

        Map<BlogPostType, BlogPost> noOptionals = posts.stream()
                .collect(groupingBy(BlogPost::getType,collectingAndThen(maxBy(comparingInt(BlogPost::getLikes)),Optional::get)));
        System.out.println("::::::  "+noOptionals);

        Map<BlogPostType, String> postsPerTypeMapping = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        mapping(BlogPost::getTitle, joining(", ", "Post titles: [", "]"))));
        System.out.println(postsPerTypeMapping);

        EnumMap<BlogPostType, List<BlogPost>> enumMap = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        () -> new EnumMap<>(BlogPostType.class), toList()));
        System.out.println(enumMap);
    }
}
