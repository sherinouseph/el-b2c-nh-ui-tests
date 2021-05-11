<html>
<!--
 1. Select period and click update result btn shows data on the table   - AVG
 2. Select a radio button will show the data for that URL only ... not AVG
-->
<head>
  <title>Monitoring Stats</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
    google.load('visualization', '1', {packages: ['corechart', 'line']});
    google.setOnLoadCallback(drawBackgroundColor);
    var chartData;
    window.everythingIsReady = [];
    window.isDebug = false;

    function drawBackgroundColor() {
        chartData = new google.visualization.DataTable();
        chartData.addColumn('number', 'RunId ');
        chartData.addColumn('number', 'LoadTime ');

        options = {
            hAxis: {
                title: 'Test Run'
            },
            vAxis: {
                title: 'Load Time'
            },
            backgroundColor: '#FFE4C4'
        };
        // drawChart();

        if (typeof window.everythingIsReady == 'object') {
            for(var i = 0; i < everythingIsReady.length; i++) {
                everythingIsReady[i]();
            }
        }

    }
        function addRow(x, y) {
            chartData.addRow([x, y]);
        }

        function insertRow(id, x, y) {
            chartData.insertRows(id, [x, y]);
        }

        function drawChart() {
            var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
            chart.draw(chartData, options);
        }

        function showGraph() {
            //document.getElementById("graph").innerHTML = "Graph ...!";
            drawChart();
        }

        function updateTestUrlLabel(url) {
            console.log(" updateTestUrlLabel url : "+url);
            document.getElementById("testUrl").innerHTML = url ;
        }

        function goBack(){
            window.history.back();
        }

		function disable_enable_graphBtn(){
            if (document.test1.test2.disabled==true)
                document.test1.test2.disabled=false
            else
                document.test1.test2.disabled=true
        }

   </script>
  <style>
	  #roundcorner1 {
		border-radius: 9px;
		border: 3px solid #73AD21;
		padding: 7px;
		<!--width: 200px;-->
		<!--height: 150px;--> 
	   }
  </style>
</head>
<body  bgcolor="#F8F8F8 ">
  <table>
       <tr>
           <td><a href="http://gblcm-l0321:8080/nikol/urlmonitor-tc1.jsp"> <img src="logo.png?"> </a>                 </td>
           <td><h1> ..... URL Monitoring Stats</h1> <td>
       </tr>
  </table>
  <table>
     <tr>
       <td><a href="<%= request.getRequestURI() %>"> Home | </a></td>
  	   <td><a onclick="goBack()" href="javascript:void(0);"> Back </a><td>
     </tr>
  </table>
  <form method="get">      <!--TODO <input type="txt" name="sql" value="Enter sql query here ..." size="200">    <input type="submit" value="Query"><br><br> -->
    <h3>Select Period :</h3>
    <input type="radio" name="period" value="All" checked="checked">Up to now
    <input type="radio" name="period" value="LastWeek">Last Week
    <input type="radio" name="period" value="LastMonth">Last Month
    <input type="radio" name="period" value="Last3Months">Last 3 Months
      <!--<input type="submit" value="Update Results" font-size: 100px style=" height:50px; width:150px" > -->
    <input id="roundcorner1" type="submit" height:120px; width:350px; style="font-face: 'Comic Sans MS'; font-size: larger; color: teal; background-color:FFCC66; border: 2pt ridge lightgrey" value=" Update Result ! ">
  </form>

  <%@ page import = "java.sql.*" %>

  <%
    String[] periodValues = {"All","LastWeek","LastMonth","Last3Months"};
    String[] period = request.getParameterValues("period");
    String[] freeSqls = request.getParameterValues("sql");
    String[] selectedTest = null;
    String selectedTestUrl = null;
    String     sql = "NotSetUp ...! Click Update button to set it up.";
	Connection conn = null;
	Statement  stmt = null;
	String dbUrl = "jdbc:mysql://10.43.40.103:3307/url_monitoring";

	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		conn  = DriverManager.getConnection( dbUrl, "java", "password"  );
		stmt  = conn.createStatement();
	}catch(Exception ex){
            out.println("Unable to connect to database : "+dbUrl+" \n "+ex);
    } 

    if (period != null ) {
        String sqlStrAll     ="SELECT t.t_id, c.countryCode, c.countryName , t.url, ROUND(AVG(tr.loadtime), 3 ) AS loadtime from countries c, test t, run r, testrun tr Where r.r_id=tr.r_id  AND t.t_id= tr.t_id AND t.c_id=c.c_id group by t.t_id order by t.t_id";
        String sqlLastWeek   ="SELECT t.t_id, c.countryCode, c.countryName , t.url, ROUND(AVG(tr.loadtime), 3 ) AS loadtime from countries c, test t, run r, testrun tr where r.date > (SELECT CURDATE()-INTERVAL (WEEKDAY(NOW())+8) DAY) AND r.date < (SELECT CURDATE()-INTERVAL WEEKDAY(NOW()) DAY) AND r.r_id=tr.r_id  AND t.t_id= tr.t_id AND t.c_id=c.c_id group by t.t_id order by t.t_id";
        String sqlLastMonth  ="SELECT t.t_id, c.countryCode, c.countryName , t.url, ROUND(AVG(tr.loadtime), 3 ) AS loadtime from countries c, test t, run r, testrun tr where r.date > (SELECT CURDATE()-INTERVAL 1 Month) AND r.r_id=tr.r_id  AND t.t_id= tr.t_id AND t.c_id=c.c_id group by t.t_id order by t.t_id";
        String sqlLast3Month ="SELECT t.t_id, c.countryCode, c.countryName , t.url, ROUND(AVG(tr.loadtime), 3 ) AS loadtime from countries c, test t, run r, testrun tr where r.date > (SELECT CURDATE()-INTERVAL 3 Month) AND r.r_id=tr.r_id  AND t.t_id= tr.t_id AND t.c_id=c.c_id group by t.t_id order by t.t_id";
        sql = sqlStrAll;

        if(period[0].equals(periodValues[0])){
                 sql = sqlStrAll;
        } else if(period[0].equals(periodValues[1])){
                 sql = sqlLastWeek;
        } else if(period[0].equals(periodValues[2])){
                 sql = sqlLastMonth;
        } else if(period[0].equals(periodValues[3])) {
                 sql = sqlLast3Month;
        } else {
                 sql=sqlStrAll;
        }
        %>
        <h3>Period Selected  : <%= period[0] %> </h3>
        <%
        int countNoOfTests=0;
        ResultSet rset = stmt.executeQuery(sql);
        %>
          <hr>
            <table border=3 cellpadding=7 bgcolor="FFCC66">
              <tr>
                <th>Test ID</th>
                <th>Code</th>
                <th>Country</th>
                <th>URL</th>
                <th>LoadTime</th>
              </tr>
              <form>
               <%   while (rset.next()) {  %>
                  <tr>
                        <td title="Click Radio Button and Select me to see the Statistics data for this URL only, ">
                            <% if(countNoOfTests==0){%>
                                <input name="selectTestId" type="radio" value="<%=rset.getString("t.t_id")%>" checked="checked" />  <%= rset.getString("t.t_id") %>
                            <% }else {%>
                                <input name="selectTestId" type="radio" value="<%=rset.getString("t.t_id")%>"/>  <%= rset.getString("t.t_id") %>
                            <% }
                                countNoOfTests++;
                            %>
                            <input type="submit" id="showGraph" height:120px; width:350px; style="font-face: 'Comic Sans MS'; font-size: larger; color: teal; background-color:FFCC99; border: 2pt ridge lightgrey" value=" Stats "  >
                        </td>
                        <td><%= rset.getString("c.countryCode") %></td>
                        <td><%= rset.getString("c.countryName") %></td>
                        <td><%= rset.getString("t.url") %></td>
                        <td><%= rset.getString("loadTime") %></td>
                        </tr>
                <% }
                    rset.close();
                %>
                </form>
            </table>  <br>
   <% } else {%>
          <!--<p>Selected Sql is    : <%=  sql %>  </p>  -->
   <% } %>
  <!-- On text radio btn select show data -->
        <%
          selectedTest = request.getParameterValues("selectTestId");
          if (selectedTest != null ) {
              String selectedId = selectedTest[0];
              %>
              <h3 id="testId">Selected ID :[ <%= selectedId %> ] ; </h3>
              <p id="testUrl">Test URL :[ <%= selectedTestUrl %> ] ; </p>

              <% if (period != null ) {     %>
                    <div>Select a radio icon and click Stats button ....!</div>
              <%}%>

              <%if (selectedTest != null ) { %>
                   <div id="chart_div"></div>
                   <%--<p id="graph" onclick="showGraph1()">Click here to Show the Graph for selected URL</p>--%>
                   <input type="submit" id=showGraph name=showGraph onclick="showGraph()" height:120px; width:350px; style="font-face: 'Comic Sans MS'; font-size: larger; color: teal; background-color:FFCC99; border: 2pt ridge lightgrey" value=" Show Graph ! "> </button><br>
              <%}%>

              <%
              String sqlOneTestStats ="SELECT t.t_id, r.r_id, r.date, t.url, tr.loadtime from countries c, test t, run r, testrun tr Where t.t_id="+selectedId+" AND r.r_id=tr.r_id  AND t.t_id= tr.t_id AND t.c_id=c.c_id order by r.r_id";

              stmt  = conn.createStatement();
              ResultSet trset = stmt.executeQuery(sqlOneTestStats);
              if( trset !=null) {
                   trset.next();
                   selectedTestUrl = trset.getString("t.url")  ;
              }
              int count = 0;
              %>


              <br>
              <table border=3 cellpadding=7 bgcolor="FFCC66">
              <tr>
              <th>Test ID</th>
              <th>Run ID</th>
              <th>Run Date</th>
              <th>LoadTime</th>
              </tr>

              <% while (trset.next()) {
                 if(count == 0){
                     selectedTestUrl = trset.getString("t.url"); %>
                     <script>
                         var url ="Test URL :<%=selectedTestUrl%>" ;
                         updateTestUrlLabel(url);
                     </script>
                 <% }
                  count++;
                  %>
              <tr>
                  <td><%= trset.getString("t.t_id") %></td>
                  <td><%= trset.getString("r.r_id") %></td>
                  <td><%= trset.getString("r.date") %></td>
                  <%--<td><%= trset.getString("t.url") %></td>--%>
                  <td><%= trset.getString("loadTime") %></td>
              </tr>
                  <script>
                      window.everythingIsReady.push(function(){
                          runId    = <%= trset.getString("r.r_id") %>;
                          loadTime = <%= trset.getString("loadTime") %>;
                          if(isDebug){console.log("Run id : "+runId+" load time :"+loadTime)}
                          addRow(runId, loadTime );
                      });
                  </script>
              <% }
                  trset.close();
              %>
              </table>  <br>
        <%} else { %>

          <%}%>

          <%
              stmt.close();
              conn.close();
          %>
<!-- Create Json obj from java rs http://biercoff.blogspot.co.uk/2013/11/nice-and-simple-converter-of-java.html -->
  <table>
     <tr>
       <td><a href="<%= request.getRequestURI() %>"> Home | </a></td>
  	   <td><a onclick="goBack()" href="#"> Back </a><td>
     </tr>
  </table>
</body>
</html>