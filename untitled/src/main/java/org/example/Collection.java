package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

public class Collection {

    private LinkedList<Book> collection;
    private LinkedList<BorrowData> borrowData;

    public Collection(){}

    public Collection(LinkedList<Book> externalCollection){
        this.collection = externalCollection;
    }

    public LinkedList<Book> getCollection() {
        return collection;
    }

    public boolean AddBook(Book book){
        if(collection.contains(book)){
            System.out.println("Book already in collection");
            return false;
        }
        collection.add(book);
        return true;
    }

    public boolean BorrowBook(Book book, String personName, int days){
        if(!collection.contains(book)){
            System.out.println("Book not in collection");
            return false;
        }
        if(book.isBorrowed()){
            System.out.println("Book already borrowed");
            return false;
        }
        book.setBorrowed(true);
        LocalDate returnDate = LocalDate.now().plus(Period.ofDays(days));
        borrowData.add(new BorrowData(book, personName, returnDate));
        return true;
    }

    public boolean ReturnBook(Book book){
        if(!collection.contains(book)){
            System.out.println("Book not in collection");
            return false;
        }
        if(!book.isBorrowed()){
            System.out.println("Book not borrowed");
            return false;
        }
        book.setBorrowed(false);
        borrowData.removeIf(borrowData -> borrowData.getBook().equals(book));
        return true;
    }

    // Finders ------------------------------------------------------------------

    public Book findBook(String title){
        for(Book book : collection){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public Book findBook(int id){
        for(Book book : collection){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    // toString ------------------------------------------------------------------

    @Override
    public String toString() {
        String result = "Collection : \n";
        for(Book book : collection){
            result += book.toString() + "\n";
        }
        result += "--------------------------------\n";
        result += "Borrowed books : \n";
        for(BorrowData borrow : borrowData){
            result += borrow.toString();
        }
        return result;
    }

    public void listBooks() {
        System.out.println("Collection : ");
        for(Book book : collection){
            System.out.println(book.toString());
        }
    }

    public void listBorrowed() {
        System.out.println("Borrowed books : ");
        for(BorrowData borrow : borrowData){
            System.out.println(borrow.toString());
        }
    }
}
