package com.example.nhom2projectmd3.controller;

import com.example.nhom2projectmd3.dao.category.CategoryDAO;
import com.example.nhom2projectmd3.model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartegoryServlet", value = "/CartegoryServlet")
public class CartegoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Category> categoryList = new ArrayList<>();
    private CategoryDAO categoryDAO;

    public void init() {
        categoryDAO = new CategoryDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                default:
                    listCategory(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Category> categoryList = categoryDAO.selectAllCategory();
        request.setAttribute("listCategory", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
