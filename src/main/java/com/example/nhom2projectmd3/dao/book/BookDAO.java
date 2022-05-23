package com.example.nhom2projectmd3.dao.book;

import com.example.nhom2projectmd3.model.Book;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO{
        private String jdbcURL = "jdbc:mysql://localhost:3306/md3case?useSSL=false";
        private String jdbcUsername = "root";
        private String jdbcPassword = "123456";

        private static final String INSERT_BOOKS_SQL = "INSERT INTO book (id, name, category, author, price, image, releaseDate, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        private static final String SELECT_BOOK_BY_ID = "select id, name, category, author, price, image, releaseDate, note from book where id =?";
        private static final String SELECT_ALL_BOOKS = "select * from book";
        private static final String DELETE_BOOKS_SQL = "delete from book where id = ?;";
        private static final String UPDATE_BOOKS_SQL = "update book set id, name, category, author, price, image, releaseDate, note where id = ?;";

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");

        public BookDAO() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Thành công");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    public void insertBook(Book book) throws SQLException {
        System.out.println(INSERT_BOOKS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setString(1, Integer.toString(book.getId()) );
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getCategory());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setString(5, Integer.toString(book.getPrice()));
            preparedStatement.setString(6, book.getImage());
            preparedStatement.setString(7, formatter.format(book.getReleaseDate()));
            preparedStatement.setString(8, book.getNote());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Book selectBook(int id) {
        Book book = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String category = rs.getString("category");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                Date releaseDate = rs.getDate("releaseDate");
                String note = rs.getString("note");

                book = new Book(id, name, category, author, price, image, releaseDate, note);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    public List<Book> selectAllBooks() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Book> books = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                Date releaseDate = rs.getDate("releaseDate");
                String note = rs.getString("note");
                books.add(new Book(id, name, category, author, price, image, releaseDate, note));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
//        update book set id, name, category, author, price, image, releaseDate, note
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL);) {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getName());
            statement.setString(3, book.getCategory());
            statement.setString(4, book.getAuthor());
            statement.setInt(5, book.getPrice());
            statement.setString(6, book.getImage());
            statement.setString(7, formatter.format(book.getReleaseDate()));
            statement.setString(8, book.getNote());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
