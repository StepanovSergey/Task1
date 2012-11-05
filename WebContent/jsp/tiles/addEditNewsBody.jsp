<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<span class="contentNewsTitle"><bean:message key="news.news" /></span>
&gt;&gt;
<bean:message key="news.add.title" />
<br>
<br>

<bean:define name="newsForm" property="news" id="news" />
<html:form action="/SaveNews">
<table>
	<tr>
		<td class="newsTableTitles"><bean:message key='news.title' /></td>
		<td><html:text size="100" name="news" property="title" /></td>
	</tr>
	<tr>
		<td><bean:message key="news.date" /></td>
		<td><html:text size="10" name="news" property="date" /></td>
	</tr>
	<tr>
		<td><bean:message key="news.brief" /></td>
		<td><html:textarea rows="5" cols="100" name="news"
				property="brief" /></td>
	</tr>
	<tr>
		<td><bean:message key="news.content" /></td>
		<td><html:textarea rows="10" cols="100" name="news"
				property="content" /></td>
	</tr>
</table>
<table class="newsListTable">
	<tr>
		<td class="afterTableButtons">
				<html:submit>
					<bean:message key="news.save" />
				</html:submit>
				<html:hidden name="news" property="id" />
			</td>
		<td><html:form action="/Cancel">
				<html:submit>
					<bean:message key="news.cancel" />
				</html:submit>
			</html:form></td>
	</tr>
</table>
<br></html:form>