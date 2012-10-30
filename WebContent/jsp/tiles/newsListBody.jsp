<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<td class="content">News &gt;&gt; News List <br> <%-- <html:form action="/DeleteNews">
		<c:forEach items="${newsList}" var="news">
			<table class="newsListTable" border=1>
				<tr>
					<td class='newsListTableTitle'>News Title <c:out
							value="${news.title }" />
					</td>
					<td><c:out value="${news.date }" /></td>
				</tr>
				<tr>
					<td><c:out value="${news.brief }" /></td>
				</tr>
				<tr>
					<td class='newsListTableButtons' colspan="2"><html:link
							forward="ViewNews.do">
							<bean:message key="news.list.view"></bean:message>
						</html:link> &nbsp;&nbsp;&nbsp;&nbsp; <html:link forward="EditNews.do">
							<bean:message key="news.list.edit"></bean:message>
						</html:link> &nbsp;&nbsp;&nbsp;&nbsp; box</td>
				</tr>
			</table>
		</c:forEach>
		<table class="newsListTable">
			<tr>
				<td class="newsListTableDeleteButton"></td>
			</tr>
		</table>
	</html:form> --%></td>