package com.charakhovich.servlet.web;

import com.charakhovich.servlet.command.Command;
import com.charakhovich.servlet.command.factory.ActionFactory;
import com.charakhovich.servlet.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "";
        String action = req.getParameter("command");
        Command command = ActionFactory.defineCommand(action);
        try {
            page = command.execute(req);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (page != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(page);
            requestDispatcher.forward(req,resp);        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String page = "";
        String action = req.getParameter("command");
        Command command = ActionFactory.defineCommand(action);
        try {
            page = command.execute(req);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (page != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(page);
            requestDispatcher.forward(req,resp);        }
    }
}
