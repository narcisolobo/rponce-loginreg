<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
  <title>Login or Register for Our Site</title>
</head>
<body>
  <div class="container">
    <h1 class="display-1 my-5">Login or Register for Our Site</h1>
    <div class="row">
      <div class="col">
        <h2 class="display-3">Register</h2>
        <div class="card shadow">
          <div class="card-body">
            <form:form action="/users/register" method="POST" modelAttribute="user">
              <div class="mb-3">
                <form:label path="firstName" class="form-label">First Name:</form:label>
                <form:input path="firstName" class="form-control" />
                <form:errors path="firstName" class="form-text text-warning" />
              </div>
              <div class="mb-3">
                <form:label path="lastName" class="form-label">Last Name:</form:label>
                <form:input path="lastName" class="form-control" />
                <form:errors path="lastName" class="form-text text-warning" />
              </div>
              <div class="mb-3">
                <form:label path="email" class="form-label">Email:</form:label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="form-text text-warning" />
              </div>
              <div class="mb-3">
                <form:label path="password" class="form-label">Password:</form:label>
                <form:input path="password" class="form-control" type="password" />
                <form:errors path="password" class="form-text text-warning" />
              </div>
              <div class="mb-3">
                <form:label path="confirm" class="form-label">Confirm Password:</form:label>
                <form:input path="confirm" class="form-control" type="password" />
                <form:errors path="confirm" class="form-text text-warning" />
              </div>
              <div class="text-end">
                <button type="submit" class="btn btn-primary">Register</button>
              </div>
            </form:form>
          </div>
        </div>
      </div>
      <div class="col">
        <h2 class="display-3">Login</h2>
        <div class="card shadow">
          <div class="card-body">
            <form:form action="/users/login" method="POST" modelAttribute="loginUser">
              <div class="mb-3">
                <form:label path="email" class="form-label">Email:</form:label>
                <form:input path="email" class="form-control" />
                <form:errors path="email" class="form-text text-warning" />
              </div>
              <div class="mb-3">
                <form:label path="password" class="form-label">Password:</form:label>
                <form:input path="password" class="form-control" type="password" />
                <form:errors path="password" class="form-text text-warning" />
              </div>
              <div class="text-end">
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>