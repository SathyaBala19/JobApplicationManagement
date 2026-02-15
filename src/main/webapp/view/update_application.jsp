<%@ page import="com.job.model.Application" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Application</title>
</head>
<body>

<%
Application app = (Application) request.getAttribute("app");
%>

<h2>Update Application</h2>

<!-- ✅ THIS IS WHERE THE CHANGE IS -->
<form action="<%= request.getContextPath() %>/UpdateApplicationServlet"
      method="post">

    <!-- ✅ REQUIRED HIDDEN ID -->
    <input type="hidden" name="id"
           value="<%= app.getApplicationId() %>">

    Name:
    <input type="text" name="name"
           value="<%= app.getApplicantName() %>" required><br><br>

    Position:
    <input type="text" name="position"
           value="<%= app.getPosition() %>" required><br><br>

    Email:
    <input type="email" name="email"
           value="<%= app.getEmail() %>" required><br><br>

    Status:
    <input type="text" name="status"
           value="<%= app.getStatus() %>" required><br><br>

    <input type="submit" value="Update">
</form>

<br>
<a href="<%= request.getContextPath() %>/ViewApplicationServlet">
    Cancel
</a>

</body>
</html>
