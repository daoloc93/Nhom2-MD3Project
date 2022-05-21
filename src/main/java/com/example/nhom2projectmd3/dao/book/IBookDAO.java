package com.example.nhom2projectmd3.dao.book;

import com.example.nhom2projectmd3.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    void insertBook(Book book) throws SQLException;

    Book selectBook(int id);

    List<Book> selectAllBooks();

    boolean deleteBook(int id) throws SQLException;

    boolean updateBook(Book book) throws SQLException;

}
