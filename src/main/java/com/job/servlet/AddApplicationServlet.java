package com.job.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.job.dao.ApplicationDAO;
import com.job.dao.ApplicationDAOImpl;
import com.job.model.Application;
import jakarta.servlet.annotation.WebServlet;

public class AddApplicationServlet extends HttpServlet {

    // Handles GET request (when user clicks "Add Application")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Show Add Application form
        RequestDispatcher rd =
                req.getRequestDispatcher("view/add_application.jsp");
        rd.forward(req, res);
    }

    // Handles POST request (when form is submitted)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Application app = new Application();
        app.setApplicantName(req.getParameter("name"));
        app.setPosition(req.getParameter("position"));
        app.setEmail(req.getParameter("email"));
        app.setStatus(req.getParameter("status"));

        ApplicationDAO dao = new ApplicationDAOImpl();
        dao.addApplication(app);

        // Redirect to view applications after insert
        res.sendRedirect(req.getContextPath() + "/ViewApplicationServlet");
    }
}