package com.epam.lab;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MainServlet extends HttpServlet {
    private List<String> states = new ArrayList<>();
    private AtomicInteger amount = new AtomicInteger(0);
//    private int amount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("GET");
        req.setAttribute("states", states);
        addCookie(req,resp);
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
//        states.add("DELETE");
        states.clear();
//        req.setAttribute("states", states);
//        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    private void addCookie(HttpServletRequest req, HttpServletResponse resp){
        Cookie cookie = new Cookie("amount", Integer.toString(amount.incrementAndGet()));
//        Cookie cookie = new Cookie("amount", Integer.toString(++amount));
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("amount")) {
                    req.setAttribute("amount", cookies[i].getValue());
                    break;
                }
            }
        }
    }
}
