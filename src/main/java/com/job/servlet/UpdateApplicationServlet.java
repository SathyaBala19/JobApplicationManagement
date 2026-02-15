package com.job.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.job.dao.ApplicationDAO;
import com.job.dao.ApplicationDAOImpl;
import com.job.model.Application;

public class UpdateApplicationServlet extends HttpServlet {

    // 1️⃣ Load existing data into update form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        ApplicationDAO dao = new ApplicationDAOImpl();
        Application app = dao.getApplicationById(id);

        req.setAttribute("app", app);

        RequestDispatcher rd =
                req.getRequestDispatcher("view/update_application.jsp");
        rd.forward(req, res);
    }

    // 2️⃣ Update data in database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Application app = new Application();
        app.setApplicationId(Integer.parseInt(req.getParameter("id")));
        app.setApplicantName(req.getParameter("name"));
        app.setPosition(req.getParameter("position"));
        app.setEmail(req.getParameter("email"));
        app.setStatus(req.getParameter("status"));

        ApplicationDAO dao = new ApplicationDAOImpl();
        dao.updateApplication(app);

        res.sendRedirect("ViewApplicationServlet");
    }
}