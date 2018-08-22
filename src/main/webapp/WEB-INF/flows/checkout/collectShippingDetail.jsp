<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
	<link rel="stylesheet"
		  href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<title>Customer</title>
</head>
<body>
<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Shipping</h1>
			<p>Shipping details</p>
		</div>
	</div>
</section>
<section class="container">
	<form:form modelAttribute="order.person" class="form-horizontal">


			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo">back</button>

					<input type="submit" id="btnAdd" class="btn btn-primary"
						   value="Add"  name="_eventId_shippingDetailCollected"/>
					<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
				</div>
			</div>

		</fieldset>
	</form:form>
</section>
</body>
</html>
