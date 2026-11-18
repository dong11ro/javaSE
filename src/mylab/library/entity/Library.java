package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> library;
    private String name;

    public Library(String name){
        this.name = name;
        this.library = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }

    public void addBook(Book book){
        this.library.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }
    public Book findBookByTitle(String title){
        for (Book book : library) {
            if (Objects.equals(book.getTitle(), title)){
                return book;
            }
        }
        return null;
    }
    public List<Book> findBooksByAuthor(String author){
        List<Book> result = new ArrayList<>();
        for (Book book : library) {
            if (Objects.equals(book.getAuthor(), author)){
                result.add(book);
            }
        }
        return result;
    }
    public Book findBookByISBN(String isbn){
        for (Book book : library) {
            if (Objects.equals(book.getIsbn(), isbn)){
                return book;
            }
        }
        return null;
    }
    public boolean checkOutBook(String isbn){
        for (Book book : library) {
            if (Objects.equals(book.getIsbn(), isbn)){
                if (book.isAvaliable()){ // 대출 가능한 상태면, true를 아니면 false를.
                    return book.checkOut();
                }
            }
        }
        return false;
    }
    public boolean returnBook(String isbn) {
        for (Book book : library) {
            if (Objects.equals(book.getIsbn(), isbn)) { // 찾음.
                book.returnBook();
                return true;
            }
        }
        return false; // 순회 했는데 못 찾음 -> false
    }
    public List<Book> getAvaliableBooks(){
        List<Book> result = new ArrayList<>();
        for (Book book : library) {
            if (book.isAvaliable()){
                result.add(book);
            }
        }
        return result;
    }
    public List<Book> getAllBooks(){
        return library;
    }
    public int getTotalBooks(){
        return library.size();
    }
    public int getAvailableBooksCount(){
        int result = 0;
        for (Book book : library) {
            if (book.isAvaliable()){
                result += 1;
            }
        }
        return result;
    }
    public int getBorrowedBooksCount(){
        int result = 0;
        for (Book book : library) {
            if (!book.isAvaliable()){
                result += 1;
            }
        }
        return result;
    }

}
