
<%--
  Created by IntelliJ IDEA.
  test.UserProfile: hp
  Date: 29/01/2020
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.covoiturage.fb.login.UserProfile" %>
<%@ page import="com.covoiturage.fb.login.UserDetails" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <% String accessToken = request.getParameter("accessToken");
     UserProfile user_profile = UserDetails.GetUserProfile(accessToken);
    %>
    Bienvenue <%=user_profile.getName()%> à notre site de covoiturage !


</body>
</html>
