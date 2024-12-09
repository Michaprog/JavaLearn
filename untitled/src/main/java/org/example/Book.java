package org.example;

public class Book {

    private static int nextId = 1;
    private int id;
    private String title;
    private String author;
    private int pages;
    private boolean borrowed;
    private Genre genre;

    public enum Genre {
        FICTION,
        NON_FICTION,
        MYSTERY,
        FANTASY,
        BIOGRAPHY,
        SCIENCE_FICTION
    }

    // Constructors ------------------------------------------------------------------

    public Book(){
        this.id = nextId++;
        this.title = "Untitled";
        this.borrowed = false;
    }


    public Book(String title, String author, int pages, Genre genre) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.borrowed = false;
        this.genre = genre;
    }

    // Setter ------------------------------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    // Getters ------------------------------------------------------------------

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Genre getGenre() {
        return genre;
    }

    // toString ------------------------------------------------------------------

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", borrowed=" + borrowed +
                ", genre=" + genre +
                '}';
    }

}
