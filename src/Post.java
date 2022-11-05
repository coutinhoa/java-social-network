import java.util.ArrayList;
import java.util.Iterator;

public class Post {

    private String text;
    private String author;


    public Post(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
