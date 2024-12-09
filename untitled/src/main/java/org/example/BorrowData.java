package org.example;

import java.text.DateFormat;
import java.time.LocalDate;

public class BorrowData {

    private Book book;
    private String personName;
    private LocalDate returnDate;

    public BorrowData(Book book, String personName, LocalDate date){
        try {
            if (book.isBorrowed()) {
                throw new Exception("Book is already borrowed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.book = book;
        this.personName = personName;
        this.returnDate = date;
    }

    public Book getBook() {
        return book;
    }

    public String getPersonName() {
        return personName;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Id : " + this.getBook().getId() +
                " Title : " + this.getBook().getTitle() +
                " ,borrowed by " + this.getPersonName() +
                " until " + this.getReturnDate().toString() + "\n";
    }

}
