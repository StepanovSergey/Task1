<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:form action="/registration" onsubmit="return validateUserForm(this)">
    <table>
        <tr><td colspan="2"><div class="errors"><html:errors/></div></td></tr>
        <tr><td>* <bean:message key="form.name"/></td><td><html:text property="username"/></td></tr>
        <tr><td>* <bean:message key="form.email"/></td><td><html:text property="email"/></td></tr>
        <tr><td>* <bean:message key="form.birth"/><br/>
	   <bean:message key="form.birth.pattern"/>
              </td><td><html:text property="birth"/></td></tr>
         <tr><td><bean:message key="form.phone"/><br/>
	 <bean:message key="form.phone.pattern"/>
               </td><td><html:text property="phone"/></td></tr>
         <tr><td>* <bean:message key="form.gender"/></td>
               <td><html:select property="gender">
	     <html:option value="male"><bean:message key="form.gender.male"/></html:option>
	    <html:option value="female"><bean:message key="form.gender.female"/></html:option>
                	</html:select>
               </td>
        </tr>
        <tr><td><bean:message key="form.password"/></td><td><html:password property="password"/></td></tr>
        <tr><td><bean:message key="form.confirmpass"/></td><td><html:password property="confirmation"/></td></tr>
        <tr><td colspan="2" align="center"><html:submit/></td></tr>
    </table>   
</html:form>
<html:javascript formName="userForm" staticJavascript="true"/>
