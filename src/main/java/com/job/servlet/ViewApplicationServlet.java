package com.job.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.job.dao.ApplicationDAO;
import com.job.dao.ApplicationDAOImpl;
import com.job.model.Application;
import jakarta.servlet.annotation.WebServlet;

public class ViewApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        ApplicationDAO dao = new ApplicationDAOImpl();
        List<Application> list = dao.getAllApplications();

        // ✅ THIS LINE IS CRITICAL
        req.setAttribute("apps", list);

        RequestDispatcher rd =
                req.getRequestDispatcher("view/view_applications.jsp");
        rd.forward(req, res);
    }
}