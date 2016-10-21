<%--
  Created by IntelliJ IDEA.
  User: muhamamddanish
  Date: 9/30/16
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manipulate User</title>
</head>
<body>

    <div>
        <c:choose>
            <c:when test="${ not empty success}">
                <h4 style="color: greenyellow">${success}</h4>
            </c:when>
            <c:when test="${not empty update}">
                <h4 style="color:blueviolet">${update}</h4>
            </c:when>
            <c:when test="${not empty deleted}">
                <h4 style="color:red">${deleted}</h4>
            </c:when>
        </c:choose>
    </div>

    <div>
        <form:form action="${pageContext.request.contextPath}/manipulateUser" method="post" commandName="user">
            <table cellpadding="1" cellspacing="1">
                <tr>
                    <td><form:hidden path="userId"></form:hidden></td>
                </tr>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" placeholder="First Name"/></td>
                    <td><form:errors path="firstName" /></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name</form:label></td>
                    <td><form:input path="lastName" placeholder="Last Name"/></td>
                    <td><form:errors path="lastName" /></td>
                </tr>
                <tr>
                    <td><form:label path="address">Address</form:label></td>
                    <td><form:input path="address" placeholder="Address"/></td>
                    <td><form:errors path="address" /></td>
                </tr>
                <tr>
                    <td><form:label path="phoneNumber">Phone Number</form:label></td>
                    <td><form:input path="phoneNumber" placeholder="Phone Number"/></td>
                    <td><form:errors path="phoneNumber" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form:form>
    </div>

    <div>
        <table cellpadding="1" cellspacing="1" border="1px">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.address}</td>
                    <td>${user.phoneNumber}</td>
                    <td><a href="/editUser/${user.firstName}">Edit</a></td>
                    <td><a href="/deleteUser/${user.userId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

        <c:out value="${pageContext.request.contextPath}"></c:out>
    </div>
</body>
</html>
