<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<span class="contentNewsTitle"><bean:message key="news.news" /></span> &gt;&gt; <bean:message key="menu.news.list" />
<br><br>
<html:form action="/DeleteNews">
	<c:forEach items="${newsList}" var="news">
		<table class="newsListTable">
			<tr>
				<td class='newsListTableTitle'><bean:message key="news.title" /> ${news.title }
				</td>
				<td>${news.date }</td>
			</tr>
			<tr>
				<td>${news.brief }</td>
			</tr>
			<tr>
				<td class='newsListTableButtons' colspan="2"><html:link
						action="ViewNews">
						<bean:message key="news.list.view"></bean:message>
					</html:link> &nbsp;&nbsp;&nbsp;&nbsp; <html:link action="EditNews">
						<bean:message key="news.list.edit"></bean:message>
					</html:link> &nbsp;&nbsp;&nbsp;&nbsp; <html:multibox property="selectedItems"
						value="${news.id }"></html:multibox></td>
			</tr>
		</table>
	</c:forEach>
	<table class="newsListTable">
		<tr>
			<td class="newsListTableDeleteButton"><html:submit>
					<bean:message key="news.delete" />
				</html:submit></td>
		</tr>
	</table>
</html:form>
<br>