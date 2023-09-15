<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Task" %>
<%@ page import="service.Service" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>TaskList</title>
</head>
<body>

	<header>

    <div>
        <h1> TaskList </h1>
    </div>

  </header>

  <main class="container">

    <div>
    
      <table>
        
      <tr class="th-header">

        <td> Id </td>
        <td> Nome </td>
        <td> Status </td>

      </tr>

      <%
  
  		List<Task> list = new ArrayList<Task>();
  		Service service = new Service();
  		list = service.listTask();
  	
  		for(Task task : list) {
  
 	  %>  

  		<tr > 
  			<td > <%= task.getId() %> </td>
  			<td > <%= task.getName() %>  </td>
  			<td > <%= task.getStatus() %>  </td>
  			<td class="border-none alt"> <a href="" class="alt">Alterar</a> <a href="" class="del">Deletar</a> </td> 
  		</tr>
 	  
 	  <%
  		}
  	%>
 	  
  </table>

    </div>

  </main>

</body>
</html>