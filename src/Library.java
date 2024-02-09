import java.util.*;

public class Library {
    String answer = "y";

    List<Book> listOfBooks = new ArrayList<>();

    Map<Author, List<Book>> fullLibrary = new HashMap<>();

    public void start() {
        while (!(answer.equals("Q") || answer.equals("q"))) {
            System.out.println(" What would you like to do?");
            System.out.println(" 1 - add an author");
            System.out.println(" 2 - add book to an author");
            System.out.println(" 3 - get all books");
            System.out.println(" 4 - get all authors");
            System.out.println(" 5 - get all books and authors");
            System.out.println(" 6 - get all books of an author");
            System.out.print(" Your choice:");
            answer = getAnswerFromUser();

            if (answer.equals("1")) {
                addAuthor();
            } else if (answer.equals("2")) {
                addBookToAuthor();
            } else if (answer.equals("3")) {
                getAllBooks();
            } else if (answer.equals("4")) {
                getAllAuthors();
            } else if (answer.equals("5")) {
                getAllBooksAndAuthors();
            } else if (answer.equals("6")) {
                getBooksOfAuthor();
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

    public void getBooksOfAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is authors name:");
        String authorNameInput = scanner.nextLine();

        for (Author a : fullLibrary.keySet()) {
            if (a.getName().equals(authorNameInput)) {
                System.out.println(fullLibrary.get(a));
            } else {
                System.out.println("There are no books associated to this author.");
            }
        }
    }

    public void addBookToAuthor() {

        if (fullLibrary.isEmpty()) {
            System.out.println("There are no authors in the database!");
            start();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is authors name?:");
        String authorNameInput = scanner.nextLine();

        for (Author a : fullLibrary.keySet()) {
            if (a.getName().equals(authorNameInput)) {
                System.out.println("What is the books title?:");
                String booksTitleInput = scanner.nextLine();
                System.out.println("What is the books genre?:");
                String booksGenreInput = scanner.nextLine();
                System.out.println("What is the books number of pages?:");
                String booksNumberOfPages = scanner.nextLine();
                int booksNumberOfPagesInt = Integer.parseInt(booksNumberOfPages);
                List<Book> listOfBooksOfThisAuthor = fullLibrary.get(a);
                Book book = new Book(booksTitleInput, booksGenreInput, booksNumberOfPagesInt);
                listOfBooks.add(book);
                listOfBooksOfThisAuthor.add(book);
                fullLibrary.put(a, listOfBooksOfThisAuthor);
                start();
            }
        }
        System.out.println("Author is not in the database, please enter authors data:");
        addAuthorRedirect(authorNameInput);
        start();
    }


    public void getAllAuthors() {
        for (Author a : fullLibrary.keySet()) {
            System.out.println(a);
        }
    }

    public void getAllBooks() {
        Collections.sort(listOfBooks);
        System.out.println(listOfBooks);
    }

    public void getAllBooksAndAuthors() {
        System.out.println(fullLibrary);
    }

    public void addAuthor() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is authors name:");
        String authorNameInput = scanner.nextLine();
        System.out.println("What is authors age:");
        String authorAgeInput = scanner.nextLine();
        int authorAgeInputInt = Integer.parseInt(authorAgeInput);
        System.out.println("What is authors favourite genre:");
        String authorFavouriteGenreInput = scanner.nextLine();


        if (fullLibrary.containsKey(authorNameInput)) {
            start();
        } else {
            List<Book> emptyListOfBooks = new ArrayList<>();
            Author author = new Author(authorNameInput, authorAgeInputInt, authorFavouriteGenreInput);
            fullLibrary.put(author, emptyListOfBooks);
        }
    }

    public void addAuthorRedirect(String authorNameInput) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is authors age:");
        String authorAgeInput = scanner.nextLine();
        int authorAgeInputInt = Integer.parseInt(authorAgeInput);
        System.out.println("What is authors favourite genre:");
        String authorFavouriteGenreInput = scanner.nextLine();


        if (fullLibrary.containsKey(authorNameInput)) {
            start();
        } else {
            List<Book> emptyListOfBooks = new ArrayList<>();
            Author author = new Author(authorNameInput, authorAgeInputInt, authorFavouriteGenreInput);
            fullLibrary.put(author, emptyListOfBooks);
        }
    }

}

