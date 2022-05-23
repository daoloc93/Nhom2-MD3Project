package com.example.nhom2projectmd3.controller;

import com.example.nhom2projectmd3.dao.book.BookDAO;
import com.example.nhom2projectmd3.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Detail", urlPatterns = "/detail")
public class DetailControl extends HttpServlet {
    private BookDAO bookDAO;
    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("bookid"));
        Book book = bookDAO.selectBook(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }
}
