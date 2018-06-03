<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="../snippets/head.jsp">
    <jsp:param name="title" value="Profile"/>
</jsp:include>


<script type="text/javascript" src="../js/profile.js"></script>
<body>
<div id="profile" class="content">
    <h1>Profile</h1>
    <p>Email: <c:out value="${user.email}"/></p>
    <br>
    <button id="customerList">Customers</button>
    <button id="employeeList">Employees</button>
    <button id="purchaseHistory">My purchase History</button>
    <br>
</div>

<div id="customersDiv" class="hidden content">
    <table id="customersTable">
    </table>
</div>

<div id="employeesDiv" class="hidden content">
    <table id="employeesTable">
    </table>
</div>

<div id="purchaseHistoryDiv" class="hidden content">
    <table id="purchaseHistoryTable">
    </table>
</div>


</body>
</html>
