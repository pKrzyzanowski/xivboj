<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>

<html>
<head>
</head>
<body>

<form:form modelAttribute="newCourse" class="form-horizontal" enctype="multipart/form-data">

    <fieldset>
        <legend>
            Dane Kursu
        </legend>


        <div class="form-group">
            <label class="control-label col-lg-2" for="name">name</label>
            <div class="col-lg-10">
                <form:input id="name" path="name" type="text"/>

            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2" for="maxNumberOfStudents">maxNumberOfStudents</label>
            max. number of students
            <div class="col-lg-10">
                <form:input id="maxNumberOfStudents" path="maxNumberOfStudents" type="text"/>

            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="numberOfHours">
                number of hours
            </label>
            <div class="col-lg-10">
                <form:input id="numberOfHours" path="numberOfHours" type="text"/>
            </div>
        </div>


        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" value="Add">
            </div>
        </div>

    </fieldset>

</form:form>


</body>
</html>
