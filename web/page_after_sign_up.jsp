

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
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <% String accessToken = request.getParameter("accessToken");
     UserProfile user_profile = UserDetails.GetUserProfile(accessToken);
    %>
    Bienvenue <%=user_profile.getName()%> à notre site de covoiturage ! <a href="<c:url value='offres.jsp'/>">consulter les offres sur le site: </a>

    <p>
    <p>
        Posts from Wessalni_Dev :
    </p>


    <%  int i =0;
        List<String> myList = UserDetails.GetGroupPosts(accessToken);
        for(i=0;i<myList.size();i++) {%>

    <div>

        <%
            out.println(myList.get(i));

        %>
    </div>

    <%
        }
        %>
    </p>


</body>
</html>
