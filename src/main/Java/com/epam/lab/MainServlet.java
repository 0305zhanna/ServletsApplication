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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("state", "GET");
        req.setAttribute("amount", getNewCookie(req, resp));
        req.setAttribute("states", states);
        if (req.getParameter("clicked") != null) {
            req.getRequestDispatcher("WEB-INF/jsp/part.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.add("new state");
        req.setAttribute("state", "POST");
        req.setAttribute("amount", getFromCookie(req));
        req.setAttribute("states", states);
        req.getRequestDispatcher("WEB-INF/jsp/part.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (states.size() != 0) {
            states.set(states.size() - 1, "updated state");
        }
        req.setAttribute("state", "PUT");
        req.setAttribute("amount", getFromCookie(req));
        req.setAttribute("states", states);
        req.getRequestDispatcher("WEB-INF/jsp/part.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        states.clear();
        req.setAttribute("state", "DELETE");
        req.setAttribute("amount", getFromCookie(req));
        req.setAttribute("states", states);
        req.getRequestDispatcher("WEB-INF/jsp/part.jsp").forward(req, resp);
    }

    private String getFromCookie(HttpServletRequest req) {
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

    public String getNewCookie(HttpServletRequest req, HttpServletResponse resp) {
        String s = getFromCookie(req);
        int i = Integer.parseInt(s) + 1;
        resp.addCookie(new Cookie("amount", Integer.toString(i)));
        return Integer.toString(i);
    }
}
