package com.epam.lab;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    private List<String> states = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("GET");
        req.setAttribute("states", states);
        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("POST");
        resp.setHeader("Content-type", "text/html");
        resp.getWriter().write("POST");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("PUT");
//        req.setAttribute("states", states);
//        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("DELETE");
//        req.setAttribute("states", states);
//        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
    }
}
