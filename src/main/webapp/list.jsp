<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Task" %>
<%@ page import="dao.TaskDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> List </h1>

  <%
  
  	List<Task> list = new ArrayList<Task>();
  	TaskDao taskDao = new TaskDao();
  	list = taskDao.listDB();
  	
  	for(Task task : list) {
  
  %>
  
  <%= task.getName()   %>
  
  <%
  	}
  %>

</body>
</html>