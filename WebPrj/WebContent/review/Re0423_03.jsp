<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	int x = 0;
	int y = 0;
	
	String x_ = request.getParameter("x");
	String y_ = request.getParameter("y");
	String plus = request.getParameter("plus");
	String minus = request.getParameter("minus");
	String multiple = request.getParameter("multiple");
	String division = request.getParameter("division");
	
	if(x_ != null && !x_.equals(""))
		x = Integer.parseInt(x_);
	
	if(y_ != null && !y_.equals(""))
		y = Integer.parseInt(y_);

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Calculator</title>
	</head>
	<body>
		<form action="Re0423_03.jsp">
			<fieldset>
				<legend>계산</legend>
				<label> > x</label>
				<input type="text" name="x"> <br/>
				<label> > y</label>
				<input type="text" name="y"> <br/>
				<input type="submit" value="덧셈" name="plus">
				<input type="submit" value="뺄셈" name="minus">
				<input type="submit" value="곱셈" name="multiple">
				<input type="submit" value="나눗셈" name="division"> <br/>
				
				<% 
				out.print(" > 결과 : ");
				if(plus!=null)
					out.print(x+y);
				else if(minus!=null)
					out.println(x-y);
				else if(multiple!=null)
					out.println(x*y);
				else if(division!=null)
					out.println(x/y);
				%>
				
			</fieldset>
		</form>
	</body>
</html>