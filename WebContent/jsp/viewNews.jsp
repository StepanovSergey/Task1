<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>

<html>
<head>
<title><nested:message key="news.view.title" /></title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<!-- Header -->
	<table class="header">
		<tr>
			<td rowspan="2" class="header_title"><span>News
					management</span></td>
		</tr>
		<tr>
			<td class="header_languages"><a href="#">English</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="#">Russian</a></td>
		</tr>
	</table>
	<!-- Menu and content -->
	<div class="menu_content">
		<table class="menu_content_table">
			<!-- Menu -->
			<tr>
				<td class="menu">
					<div class="menu_div">
						<br>
						<p class="menu_title">News</p>
						<div class="menu_ul">
							<ul>
								<li><a href="#">News List</a></li>
								<li><a href="#">Add News</a></li>
							</ul>
						</div>
						<br>
					</div>
				</td>
				<!-- Content -->
				<td class="content">News &gt;&gt; <nested:message
						key="view.news.title" /> <br> 
						<table>
							<tr>
								<td><bean:message key='news.title' /></td>
								<td>111</td>
							</tr>
							<tr>
								<td><nested:message key="news.date" /></td>
								<td>222</td>
							</tr>
							<tr>
								<td><nested:message key="news.brief" /></td>
								<td>333</td>
							</tr>
							<tr>
								<td><nested:message key="news.content" /></td>
								<td>444</td>
							</tr>
							<tr>
						
							</tr>
						</table>

				</td>
			</tr>

		</table>
	</div>
	<!-- Footer -->
	<table class="footer">
		<tr>
			<td>Copyright &copy; EPAM 2012. All rights reserved.</td>
		</tr>
	</table>
</body>
</html>