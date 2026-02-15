<%@ page import="java.util.*, com.job.model.Application" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Applications</title>
    <style>
        table {
            border-collapse: collapse;
            width: 90%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            margin: 0 5px;
        }
    </style>
</head>
<body>

<h2>Job Applications</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Position</th>
        <th>Email</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

<%
    List<Application> list = (List<Application>) request.getAttribute("apps");

    if (list != null && !list.isEmpty()) {
        for (Application a : list) {
%>
    <tr>
        <td><%= a.getApplicationId() %></td>
        <td><%= a.getApplicantName() %></td>
        <td><%= a.getPosition() %></td>
        <td><%= a.getEmail() %></td>
        <td><%= a.getStatus() %></td>
        <td>
            <!-- ✅ EDIT -->
            <a href="<%= request.getContextPath() %>/UpdateApplicationServlet?id=<%= a.getApplicationId() %>">
                Edit
            </a>
            |
            <!-- ✅ DELETE -->
            <a href="<%= request.getContextPath() %>/DeleteApplicationServlet?id=<%= a.getApplicationId() %>"
               onclick="return confirm('Are you sure you want to delete?')">
                Delete
            </a>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6">No applications found</td>
    </tr>
<%
    }
%>

</table>

<br>
<a href="<%= request.getContextPath() %>/view/index.jsp">Back to Home</a>

</body>
</html>