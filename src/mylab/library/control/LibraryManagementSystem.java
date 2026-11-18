package mylab.library.control;
import mylab.library.entity.*;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagementSystem MS = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("은평구 구립 도서관");
        MS.addSampleBooks(library);
        // 중앙 도서관, 전체 도서 수, 대출 가능 도서 수, 대출 중인 도서 수 출력
        System.out.println("===== 중앙 도서관 =====");
        MS.displayAllBooks(library);
        // 도서 검색 테스트
        System.out.println("");
        MS.testFindBook(library);
        // 도서 대출 테스트
        MS.testCheckOut(library);
        MS.displayAllBooks(library);
        // 도서 반납 테스트
        MS.testReturn(library);
        MS.displayAllBooks(library);
        // 대출 가능한 도서 목록
        MS.displayAvaliableBooks(library);
    }
    private void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }
    public void displayAllBooks(Library library){
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }
    public void testFindBook(Library library){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== 도서 검색 테스트 =====");
        System.out.println("제목으로 검색 결과: ");
        String input = scanner.nextLine();
        Book find = library.findBookByTitle(input);
        System.out.println(find + "\n");
        System.out.println("저자로 검색 결과:");
        input = scanner.nextLine();
        List<Book> result = library.findBooksByAuthor(input);
        for (Book book : result) {
            System.out.println(book);
        }
    }
    public void testCheckOut(Library library){
        boolean isChecked = library.checkOutBook("978-89-01-14077-4");
        if (isChecked){
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            Book checkedBook = library.findBookByISBN("978-89-01-14077-4");
            System.out.println(checkedBook);
        }
    }
    public void testReturn(Library library){
        System.out.println("===== 도서 반납 테스트 =====");

        library.findBookByISBN("978-89-01-14077-4").returnBook();
        System.out.println("도서 반납 성공!");
        System.out.println("반납된 도서 정보:");
    }
    public void displayAvaliableBooks(Library library){
        System.out.println("===== 대출 가능한 도서 목록 =====");
        List<Book> AVBooks = library.getAvaliableBooks();
        for (Book avBook : AVBooks) {
            System.out.println(avBook);
            System.out.println("------------------------");
        }
    }
}
