<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/comm/comm.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>provide system index !</h2>
<h2>客户端ip:
	<%=
	request.getRemoteAddr()
	%>
</h2>


<h2>服务器ip:
	<%
			String ip = "http://"+  request.getServerName() + ":"+request.getServerPort() + request.getContextPath()+"/";
	%>
	<%=
	ip
	%>
</h2>

</body>
</html>
