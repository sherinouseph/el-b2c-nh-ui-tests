<%-- 
    Document   : validate
    Created on : 28 Feb, 2015, 8:50:26 AM
    Author     : Lahaul Seth
--%>
<script type="text/javascript">

 function updateContentbyId(id,content) {
	var container = document.getElementById(id);
 	container.innerHTML = content;
 }


	function HideContent(d) {
		document.getElementById(d).style.display = "none";
	}
	function ShowContent(d) {
		document.getElementById(d).style.display = "block";
	}
	function ReverseDisplay(d) {
		if(document.getElementById(d).style.display == "none") { document.getElementById(d).style.display = "block"; }
		else { document.getElementById(d).style.display = "none"; }
	}


 </script>

<%@ page import ="java.sql.*" %>
<%
    try{
		String dbUrl = "jdbc:mysql://10.43.40.103:3307/url_monitoring";
        String username = request.getParameter("username");   
        String password = request.getParameter("password");
        Class.forName("com.mysql.jdbc.Driver");  
          
		Connection conn  = DriverManager.getConnection( dbUrl, "javaRead", "pass"  );
        PreparedStatement pst = conn.prepareStatement("Select * from stats_users where u_email=? and u_pass=?");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();   
		
        if(rs.next())  {         
           out.println("Valid login credentials"); 
		   session.setAttribute("session","TRUE");		   
		   response.sendRedirect("urlmonitor-tc2.jsp");
		}   
        else{
			String errMsg = "Invalid login credentials";
            //out.println(errMsg);		
		   %>	   
			<jsp:include page="index.jsp"></jsp:include>
			<script>
             ShowContent("validationMsg");
			</script>
		   <%
		}
   }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again ...! > "+e);       
   }      
%>