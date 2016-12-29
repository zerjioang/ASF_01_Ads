<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Advertisements login</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body>
    <div class="container">
      <s:form action="doLogin" cssClass="form-signin" method="POST">
        <h2 class="form-signin-heading">Advertisements login</h2>
        <s:textfield id="inputUser" name="username" cssClass="form-control" label="%{getText('label.login.name')}"/>
        <s:password name="password" id="inputPassword" cssClass="form-control" label="%{getText('label.login.password')}"/>
        <s:actionerror />
		<!--<s:fielderror />-->
        </div>
        <s:submit value="%{getText('label.login.button')}" cssClass="btn btn-lg btn-primary btn-block"/>
      </s:form>
    </div> <!-- /container -->
  </body>
</html>
