<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html>
<head>
<title>Sample Struts Application</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
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
				<td class="content">
					<html:form action="/addEditNews">
						<table>
							<tr>
								<td><bean:message key="news.title" /></td>
								<td><html:text size="100" property="title" /></td>
							</tr>
							<tr>
								<td><bean:message key="news.date" /></td>
								<td><html:text size="10" property="date" /></td>
							</tr>
							<tr>
								<td><bean:message key="news.brief" /></td>
								<td><html:textarea rows="5" property="brief" /></td>
							</tr>
							<tr>
								<td><bean:message key="news.content" /></td>
								<td><html:textarea rows="10" property="content" /></td>
							</tr>
							<html:hidden property="id" />
							<tr>
								<td><html:button property="save" value="save" />&nbsp;&nbsp;&nbsp;
									<html:button property="cancel" value="cancel" /></td>
							</tr>

						</table>
					</html:form>
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