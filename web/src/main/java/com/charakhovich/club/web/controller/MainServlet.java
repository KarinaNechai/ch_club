package com.charakhovich.club.web.controller;

import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.pool.ConnectionPool;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;
import com.charakhovich.club.web.command.factory.ActionFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
public class MainServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(MainServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String page = "";
        String action = req.getParameter("command");
        Command command = ActionFactory.defineCommand(action);
        Router router;
        try {
            router = command.execute(req);
            req.getSession().setAttribute(PageAttribute.CURRENT_PAGE, router.getPage());
            if (router.getPage() == null) {
                router.setPage(PagePath.LOGIN);
            }
            if (Router.Type.FORWARD.equals(router.getType())) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(router.getPage());
                dispatcher.forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + router.getPage());
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return;
    }


    @Override
    public void init() throws ServletException {
        super.init();
        logger.log(Level.ERROR, "Init pool");
        ConnectionPool connectionPool = ConnectionPool.getInstance();

    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }
}
