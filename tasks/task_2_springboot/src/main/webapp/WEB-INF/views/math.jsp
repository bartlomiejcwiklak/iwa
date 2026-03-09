<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Math stuff</title>
</head>
<body>
<h1>${message}</h1>
<h2>Calculate x1, x2</h2>
<form:form method="post" action="calculatex1x2.html" modelAttribute="math">
    <form:label path="coeffa">a</form:label>
    <form:input path="coeffa" />
    <br>
    <form:label path="coeffb">b</form:label>
    <form:input path="coeffb" />
    <br>
    <form:label path="coeffc">c</form:label>
    <form:input path="coeffc" />
    <br>
    <input type="submit" value="Calculate"/>
</form:form>

<h2>Calculate fibonacci</h2>
<form:form method="post" action="calculatefibonacci.html" modelAttribute="math">
    <form:label path="fibonacciN">n</form:label>
    <form:input path="fibonacciN" />
    <br>
    <input type="submit" value="Calculate"/>
</form:form>
</body>

</html>