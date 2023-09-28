<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <title>Dashboard</title>
</head>
<body>
  <div class="container">
    <h1 class="display-1 my-5">Dashboard</h1>
    <h2 class="display-3">Welcome <c:out value="${user.getFirstName()}" />!</h2>
  </div>
</body>
</html>