<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:getAsString name="title" ignore="true"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<!-- Header -->
	<tiles:insert attribute="header" />
	<!-- Menu and content -->
	<div class="menu_content">
		<table class="menu_content_table">
			<!-- Menu -->
			<tr>
				<tiles:insert attribute="menu" />
				<!-- Content -->
				<tiles:insert attribute="content" />
			</tr>
		</table>
	</div>
	<!-- Footer -->
	<tiles:insert attribute="footer" />
</body>
</html>