<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" bgcolor="red" width="500px">
		<tr align="center">
			<td><font size="6"><b>注册页面</b></font></td>
		</tr>
	</table>
	<br />
	<form action="servlet/registServlet" method="get">
		<table cellpadding="3px" cellspacing="3px" border="1px"
			bordercolor="red" align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked">男 <input type="radio" name="gender"
					value="female">女</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><input type="checkbox" name="hobby" value="fb">足球 <input
					type="checkbox" name="hobby" value="bb">篮球 <input
					type="checkbox" name="hobby" value="vb">排球</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>