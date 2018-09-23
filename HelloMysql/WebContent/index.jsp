<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
function reloadcode(){
	var time = new Date().getTime();
	document.getElementById("imagecode").src="ImageCodeServlet?d="+time;
}

function toVaild(){
    var val = document.getElementById("ff").value;
    alert(val);
    if(val == "可以提交"){
        alert("校验成功，之后进行提交");
        return true;
    }
    else{
        alert("校验失败，不进行提交");
        return false;
    }
}
</script>
</head>
<body>
<form action="Login" method="get" onsubmit="return checkcode()">
 			<table border="0">
					<tr>
                        <td>账号：</td>
                        <td><input type="text" name="username" required="required"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="password" required="required">
                        </td>
                    </tr>
                    <tr>
                    <td>验证码：</td>
                    <td><input type="text" name="checkcode" required="required"></td>
                    <td><img alt="验证码" src="ImageCodeServlet" id="imagecode"></td>
                    <td><input type="button" value="看不清楚" onclick="reloadcode();"></td>
                    </tr>
             </table>            
            
            
            <br>
            <input type="submit" value="登录" style="color:#BC8F8F">

</form> 
</body>
</html>