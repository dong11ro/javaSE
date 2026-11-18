package mylab.library.entity;

public class Book extends Object{
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvaliable;

    public Book(){

    }
    public Book(String title, String author, String isbn, int publishYear){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvaliable = true;
    }

    //getter setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    //대출 반환
    public boolean checkOut() {
        if (!isAvaliable){ // 이미 대출 되어 있음
            return false;
        }
        this.isAvaliable = false;
        return true;
    }
    public void returnBook(){
        this.isAvaliable = true;
    }

    @Override
    public String toString(){
        System.out.print("책 제목: " + this.title + "\t저자: " + this.author + "\tISBN: " + this.isbn +
                "\t출판년도: " + this.publishYear + "\t대출 가능 여부: ");
        if (this.isAvaliable){
            System.out.println("가능");
        }
        else {
            System.out.println("불가능");
        }
    }
}
