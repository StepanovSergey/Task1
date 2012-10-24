<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

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
			<td class="content"><html:form action="/index">
					<table>
						<tr>
							<td>Name:</td>
							<td><html:text property="name" /></td>
						</tr>
						<tr>
							<td><html:submit /></td>
						</tr>
					</table>
				</html:form> Some text<br> Some text<br> Some text<br> Some text<br>
				Some text<br> Some text<br> Some text<br> Some text<br>
				Some text<br> Some text<br></td>
		</tr>

	</table>
	</div>
	<!-- Footer -->
	<table class="footer">
		<tr>
			<td colspan="2">Copyright &copy; EPAM 2012. All rights reserved.</td>
		</tr>
	</table>
</body>
</html>