package org.example;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private final Map<String,Runnable> action = new HashMap<>();
    private final Collection collection = new Collection();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main mainInterface = new Main();

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current directory: " + currentDirectory);

        System.out.println("Welcome to the Library");
        mainInterface.listMainOptions();

        while (true) {

            String command = mainInterface.getScanner().nextLine();
            if (mainInterface.action.containsKey(command)) {
                mainInterface.action.get(command).run();
            }
        }
    }

    public Main(){
        action.put("loadbooks", this::loadBooksFromFile);
        action.put("addbook", this::addBook);
        action.put("borrowbook", this::borrowBook);
        action.put("returnbook", this::returnBook);
        action.put("listgenres", this::listGenres);
        action.put("listbooks", this::listBooks);
        action.put("listborrowed", this::listBorrowed);
        action.put("--help", this::listMainOptions);
        action.put("exit", this::exit);
    }

    public void listGenres(){
        System.out.println("Here are the genres you can choose from:");
        int i = 1;
        for(Book.Genre genre : Book.Genre.values()){
            System.out.println(i + ". : " +genre);
            i++;
        }
    }

    private void listMainOptions(){
        System.out.println("Here are the commans you can use:");
        System.out.println("loadbooks : Load books from file");
        System.out.println("addbook : Add a book to the collection");
        System.out.println("borrowbook : Borrow a book from the collection");
        System.out.println("returnbook : Return a book to the collection");
        System.out.println("listgenres : List all genres");
        System.out.println("listbooks : List all books in the collection");
        System.out.println("listborrowed : List all borrowed books");
        System.out.println("--help : List all commands");
        System.out.println("exit : Exit the program");
    }

    private void loadBooksFromFile(){
        System.out.println("Loading books from file");
        File bookFile = new File("org/example/booksToLoad.txt");
        try(Scanner fileScanner = new Scanner(bookFile)){
            while(fileScanner.hasNextLine()){
                String[] bookData = fileScanner.nextLine().split(",");
                Book book = new Book(bookData[0], bookData[1], Integer.parseInt(bookData[2]), Book.Genre.valueOf(bookData[3]));
                collection.AddBook(book);
            }
        } catch (Exception e){
            System.out.println("Error loading books from file");
        }
    }

    private void addBook(){
        System.out.println("What is the title of the book?");
        String title = scanner.nextLine();
        System.out.println("Who is the author of the book?");
        String author = scanner.nextLine();
        System.out.println("How many pages does the book have?");
        int pages = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What genre is the book?");
        String genreInput = scanner.nextLine();
        Book.Genre genre = Book.Genre.valueOf(genreInput);
        collection.AddBook(new Book(title, author, pages, genre));
    }

    private void borrowBook(){
        System.out.println("What is the title or id of the book you want to borrow?");
        String input = scanner.nextLine();
        Book book;
        if(Utils.inputIsInterger(input)){
            book = collection.findBook(Integer.parseInt(input));
        } else {
            book = collection.findBook(input);
        }
        if(book == null){
            System.out.println("Book not found");
            return;
        }
        System.out.println("Who is borrowing the book?");
        String personName = scanner.nextLine();
        System.out.println("How many days do you want to borrow the book?");
        int days = scanner.nextInt();
        collection.BorrowBook(book, personName, days);
        System.out.println("Book borrowed");
    }

    private void returnBook(){
        System.out.println("What is the title or id of the book you want to return?");
        String input = scanner.nextLine();
        Book book;
        if(Utils.inputIsInterger(input)){
            book = collection.findBook(Integer.parseInt(input));
        } else {
            book = collection.findBook(input);
        }
        if(book == null){
            System.out.println("Book not found");
            return;
        }
        collection.ReturnBook(book);
        System.out.println("Book returned");
    }

    private void listBooks(){
        collection.listBooks();
    }

    private void listBorrowed(){
        collection.listBorrowed();
    }

    private void exit(){
        System.exit(0);
    }

    // Getters and Setters ------------------------------------------------------------------

    public Scanner getScanner() {
        return scanner;
    }

}