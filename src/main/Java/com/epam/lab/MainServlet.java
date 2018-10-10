package com.epam.lab;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    private List<String> states = new ArrayList<>();
    private int amount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addCookie(req, resp);
        req.setAttribute("state", "GET");
        req.setAttribute("amount", getFromCookie(req, resp));
        req.setAttribute("states", states);
        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("new state");
        resp.getWriter().write(getFromCookie(req, resp));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (states.size() != 0) {
            states.set(states.size() - 1, "updated state");
        }
        getFromCookie(req, resp);
        resp.getWriter().write(getFromCookie(req, resp));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.clear();
        getFromCookie(req, resp);
        resp.getWriter().write(getFromCookie(req, resp));
    }

    private void addCookie(HttpServletRequest req, HttpServletResponse resp) {
        resp.addCookie(new Cookie("amount", Integer.toString(++this.amount)));
    }

    private String getFromCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("amount")) {
                    return cookies[i].getValue();
                }
            }
        }
        return "";
    }
}
