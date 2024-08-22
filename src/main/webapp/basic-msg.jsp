<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 22.07.2024
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body {font-family: Arial, Helvetica, sans-serif;}
    form {border: 3px solid #f1f1f1;}

    input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    button {
      background-color: #04AA6D;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
    }

    button:hover {
      opacity: 0.8;
    }

    .cancelbtn {
      width: auto;
      padding: 10px 18px;
      background-color: #f44336;
    }

    .imgcontainer {
      text-align: center;
      margin: 24px 0 12px 0;
    }

    img.avatar {
      width: 40%;
      border-radius: 50%;
    }

    .container {
      padding: 16px;
    }

    span.psw {
      float: right;
      padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
      span.psw {
        display: block;
        float: none;
      }
      .cancelbtn {
        width: 100%;
      }
    }
  </style>
</head>
<body>

<h2>Common Form</h2>
<h2 style="color: #c82333">${msg}</h2>

<c:if test="${cause != null}">
  <details>
    <summary>Details</summary>
  <c:out value="${cause}"/>
  </details>
  <details>
    <summary>Stack trace</summary>
    <c:out value="${stack-trace}"/>
  </details>
</c:if>

<%--<form action="reg" method="post">
  &lt;%&ndash;<div class="imgcontainer">
    <img src="img_avatar2.png" alt="Avatar" class="avatar">
  </div>&ndash;%&gt;

  <div class="container">
    <label for="name"><b>Name</b></label>
    <input id="name"type="name" placeholder="Enter our name" name="name" required>

    <label for="email"><b>Email</b></label>
    <input id="email"type="email" placeholder="Enter email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input id="psw" type="password" placeholder="Enter Password" name="psw" required>

    <label for="rpsw"><b>Repeat password</b></label>
    <input id="rpsw" type="password" placeholder="Repeat password" name="rpsw" required>

    <button type="submit">Registration</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>--%>

</body>
</html>
