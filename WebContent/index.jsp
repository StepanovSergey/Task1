<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html>
<head>
<title>Sample Struts Application</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<table border="1" class="main_table">
		<tr class="header_name">
			<td rowspan="2">news</td>
		</tr>
		<tr class="header_languages">
			<td>rus/eng</td>
		</tr>
		<tr>
			<td>menu</td>
			<td><html:form action="/index">
					<table>
						<tr>
							<td>Name:</td>
							<td><html:text property="name" /></td>
						</tr>
						<tr>
							<td><html:submit /></td>
						</tr>
					</table>
				</html:form></td>
		</tr>
	</table>
</body>
</html>