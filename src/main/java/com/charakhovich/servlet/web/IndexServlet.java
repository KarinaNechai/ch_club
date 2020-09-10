package com.charakhovich.servlet.web;

import com.charakhovich.servlet.command.PagePath;
import com.charakhovich.servlet.pool.ConnectionPool;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(IndexServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + PagePath.LOGIN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
   /*     String aSec = req.getParameter("time");
        float delta = (float) (System.currentTimeMillis());
        Long delta2=(long) Long.parseLong(aSec);
        req.setAttribute("result", delta);
        req.getRequestDispatcher("/pages/result.jsp").forward(req, resp);*/
    }

    @Override
    public void init() throws ServletException {
        super.init();
        logger.log(Level.ERROR, "Init pool");
        ConnectionPool connectionPool = ConnectionPool.getInstance();
    }
}
