package hello;

public class RomanConverterController {
    private final long id;
    private final int content;
    private final String og;

    public RomanConverterController(long id, int content, String og) {
        this.id = id;
        this.content = content;
        this.og = og;
    }

    public long getId() {
        return id;
    }

    public int getContent() {
        return content;
    }

    public String getOg() {
        return og;
    }
}
