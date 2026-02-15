package com.job.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import com.job.dao.*;

public class DeleteApplicationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    int id = Integer.parseInt(req.getParameter("id"));

	    ApplicationDAO dao = new ApplicationDAOImpl();
	    dao.deleteApplication(id);

	    res.sendRedirect("ViewApplicationServlet");
	}
}