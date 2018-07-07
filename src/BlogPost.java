import java.util.Objects;

public class BlogPost {
    String title;
    String author;
    private BlogPostType type;
    int likes;

    @Override
    public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", likes=" + likes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BlogPostType getType() {
        return type;
    }

    public int getLikes() {
        return likes;
    }

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;

        this.likes = likes;
    }

}

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}

