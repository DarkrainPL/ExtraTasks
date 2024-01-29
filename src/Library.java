import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Library {
    String answer = "y";
    HashMap<String, Book> fullLibrary = new HashMap<>();
    List<Author> listOfAuthors = new ArrayList<>();
    List<Book> listOfBooks = new ArrayList<>();

    public void start() {

        while (!(answer.equals("Q") || answer.equals("q"))) {

            System.out.println(" What would you like to do?");
            System.out.println(" 1 - add an author to list of authors");
            System.out.println(" 2 - add book to an author");
            System.out.println(" 3 - get all books");
            System.out.println(" 4 - get all authors");
            System.out.println(" 5 - get all books and authors");
            System.out.println(" 6 - get all books of an author");
            System.out.print(" Your choice:");
            answer = getAnswerFromUser();

            if (answer.equals("1")) {

                Scanner scanner = new Scanner(System.in);
                System.out.println("What is authors name:");
                String authorNameInput = scanner.nextLine();
                System.out.println("What is authors age:");
                String authorAgeInput = scanner.nextLine();
                int authorAgeInputInt = Integer.parseInt(authorAgeInput);
                System.out.println("What is authors favourite genre:");
                String authorFavouriteGenreInput = scanner.nextLine();

                addAuthor(authorNameInput, authorAgeInputInt, authorFavouriteGenreInput);


            } else if (answer.equals("2")) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is authors name?:");
                String authorNameInput = scanner.nextLine();
                System.out.println("What is the books title?:");
                String booksTitleInput = scanner.nextLine();
                System.out.println("What is the books genre?:");
                String booksGenreInput = scanner.nextLine();
                System.out.println("What is the books number of pages?:");
                String booksNumberOfPages = scanner.nextLine();
                int booksNumberOfPagesInt = Integer.parseInt(booksNumberOfPages);
                listOfBooks.add(new Book(booksTitleInput, booksGenreInput, booksNumberOfPagesInt));
                addBookToAuthor(authorNameInput, new Book(booksTitleInput, booksGenreInput, booksNumberOfPagesInt));

            } else if (answer.equals("3")) {
                getAllBooks();

            } else if (answer.equals("4")) {
                getAllAuthors();
            } else if (answer.equals("5")) {
                getAllBooksAndAuthors();

            } else if (answer.equals("6")) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is authors name:");
                String authorNameInput = scanner.nextLine();
                getBooksOfAuthor(authorNameInput);
            } else if (answer.equals("Q") || (answer.equals("q"))) {
                System.out.println("Program exit.");
            } else {
                System.out.println("THIS OPTION IS NOT AVAILABLE!");
                start();
            }
        }
    }

    private String getAnswerFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void getBooksOfAuthor(String authorName) {
        System.out.println(fullLibrary.get(authorName));
        System.out.println(fullLibrary);
    }

    public void addBookToAuthor(String authorNameInput, Book book) {
        fullLibrary.put(authorNameInput, book);
    }

    public void getAllAuthors() {
        System.out.println(listOfAuthors);
    }

    public void getAllBooks() {
        System.out.println(listOfBooks);
    }

    public void getAllBooksAndAuthors() {
        System.out.println(fullLibrary);
    }

    public void addAuthor(String authorNameInput, Integer authorAgeInputInt, String authorFavouriteGenreInput) {
        listOfAuthors.add(new Author(authorNameInput, authorAgeInputInt, authorFavouriteGenreInput));

    }

}
