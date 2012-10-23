<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
      <table width="100%">
            <tr>
	<td width="100%" align="center">
	     <tiles:insert attribute="header"/>
	</td>
           </tr>
           <tr>
	<td width="100%" align="center">
	     <tiles:insert attribute="body"/>
	</td>
           </tr>
       </table>
</body>
</html>
