package org.example.ex_03;


import org.example.ex_03.entity.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookHelper bookHelper = new BookHelper();

        Book book = bookHelper.getBookId(4);
        System.out.println("\nbook:'" + book.getName() + "' author: " + book.getAuthor().getFullNameAuthor());

        Book deleteBook = bookHelper.deletingBookId(9);
        System.out.println("\nDeleted book: id " + deleteBook.getId() + " '" + deleteBook.getName() + "'");

        bookHelper.deletingBookByAuthor();


        printAllBooks();

    }
    private static void printAllBooks(){

        BookHelper bookHelper = new BookHelper();
        List<Book> books = bookHelper.getAllBook();
        System.out.println("--------------------------------------");
        for(Book getAllBooks : books){
            System.out.println("id " + getAllBooks.getId() + ". " + "book:'" + getAllBooks.getName() +
                                "' author: " + getAllBooks.getAuthor().getFullNameAuthor());
        }
    }
}
