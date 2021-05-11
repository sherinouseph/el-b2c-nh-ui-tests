<%-- 
    Document   : Login/Index
    Created on : 28 Dec 2015
    Author     : Nikol
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to selenium URL stats</title>
		 <script type="text/javascript">

			 function updateContentbyId(id,content) {
				 var container = document.getElementById(id);
				 container.innerHTML = content;
			 }

		  </script>
		  
    </head>
    <body>
		<%	session.setAttribute("session","FALSE"); %>
        <form method="post" action="validate.jsp">
            <center>
            <table border="3" cellpadding="5" cellspacing="3">
                <thead>
                    <tr>
                        <th colspan="2">Login To see URL Statistics</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" required/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Login" />
                            &nbsp;&nbsp;
                            <input type="reset" value="Reset" />
                        </td>                        
                    </tr>     
					<tr>
                        <td colspan="3" align="center">
                            <div bgcolor="#FF0000" id="validationMsg" visibility: hidden ><blink> Invalid login credentials, <br> Enter correct details and try to login again ...!</blink></div>                          
                        </td>
						
                    </tr>    
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>