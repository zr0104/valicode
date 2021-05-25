<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>2.1随机验证码</title>
	<style type="text/css">
		.code_a{
		  color: #000fff;
		  font-size: 12px;
		  text-decoration: none;
		  cursor: pointer;
		}
		#imgCode{
		  cursor: pointer;
		}
	</style>
</head>

<body>
	<form action="" method="post">
	<label>验证码：</label>
	<input type="text" id="inCode" name="inCode" />
	<img alt="" src="code21" align="center" id="imgCode" />
	<a class="code_a">换一张</a><br />
	<input type="submit" value="登录" />
	</form>
	<div style="color:red">${err}</div>
</body>
</html>