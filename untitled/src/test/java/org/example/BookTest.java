package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Book;

class BookTest {

    @Test
    public void testBook(){
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 310, Book.Genre.FANTASY);
        assertEquals("The Hobbit", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());
        assertEquals(310, book.getPages());
        assertEquals(Book.Genre.FANTASY, book.getGenre());
    }
}