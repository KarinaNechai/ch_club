package com.charakhovich.club.web.controller;

import com.charakhovich.club.model.exeption.ServiceException;
import com.charakhovich.club.model.pool.ConnectionPool;
import com.charakhovich.club.web.command.Command;
import com.charakhovich.club.web.command.PageAttribute;
import com.charakhovich.club.web.command.PagePath;
import com.charakhovich.club.web.command.Router;
import com.charakhovich.club.web.command.factory.ActionFactory;
import com.charakhovich.club.web.command.impl.EmptyCommand;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Command command = ActionFactory.defineCommand(req);
        if (command instanceof EmptyCommand) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Router router;
        try {
            // RequestContext requestContext=new RequestContext(req);
            router = command.execute(req);

            if (router.getPage() == null) {
                router.setPage(PagePath.MAIN);
            }
            req.getSession().setAttribute(PageAttribute.CURRENT_PAGE, router.getPage());
            if (Router.Type.FORWARD.equals(router.getType())) {
                RequestDispatcher dispatcher = req.getRequestDispatcher(router.getPage());
                dispatcher.forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + router.getPage());
            }
            return;
        } catch (ServiceException e) {
            resp.sendRedirect(req.getContextPath() + PagePath.ERROR_500);
        }
    }

    private String subStringPathWithRegex(String url) {
        final String PATH_REGEX_START = "/do.+";
        Pattern pattern = Pattern.compile(PATH_REGEX_START);
        String path = null;
        if (url != null) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                path = matcher.group(0);
            } else {
                path = PagePath.MAIN;
            }
        }
        int indexStart=url.indexOf("/do/");
        int indexEnd=url.indexOf("?");
        return indexEnd==-1?(indexStart==-1?url:url.substring(0,indexEnd)):url.substring(indexStart,indexEnd);
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
