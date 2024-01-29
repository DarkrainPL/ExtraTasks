public class Book {
    private String title;
    private String genre;
    private int numberOfPages;

    public Book(String title, String genre, int numberOfPages) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
