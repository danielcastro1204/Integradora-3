package model;

public class Standard extends User{
    
    private Book[] books;
    private Magazine[] magazines;

    public Standard(String name, String id) {
        
        super(name, id);
        this.books = new Book[5];
        this.magazines = new Magazine[2];
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Magazine[] getMagazines() {
        return magazines;
    }

    public void setMagazines(Magazine[] magazines) {
        this.magazines = magazines;
    } 
}