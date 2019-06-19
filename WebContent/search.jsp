<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.*"%>
<%@ page import="Models.*"%>
<%@ page import="java.util.List"%>
<%
String str = (String) request.getParameter("Page");
int pagenow;
if(str.equals("")||str==null){
	pagenow=1;
}else{
	pagenow=Integer.parseInt(str);
}

List<Staff> list1=(List<Staff>)request.getAttribute("list");
int pagecount=list1.size()/10+1;

//List<Staff> list=staffDao.queryPageList(pagenow);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>index</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<style type="text/css">
body {
	font-family: 'Microsoft YaHei';
}
/*.panel-body{ padding: 0; }*/
</style>
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
  		<h3>人力资源管理系统</h3>
  		
	</div>
</div>
<div class="container">
	<div class="main">
		<div class="row">
			<!-- 左侧内容 -->
			<div class="col-md-3">
				<div class="list-group">
					<a href="#" class="list-group-item active">人事管理</a>
					<a href="person_new.jsp" class="list-group-item text-center ">新进登记</a>
					<a href="person_out.jsp" class="list-group-item text-center ">离职登记</a>
					<a href="change_list.jsp?Page=1" class="list-group-item text-center ">变更记录</a>
					<a href="attend_list.jsp?Page=1" class="list-group-item">考勤管理</a>
					<a href="salary_list.jsp?Page=1" class="list-group-item">薪酬管理</a>
					<a href="user_fix.jsp" class="list-group-item">用户管理</a>
				</div>
			</div>
			<!-- 右侧内容 -->
			<div class="col-md-9">
				<!-- 自定义内容 -->
				<div class="panel panel-default">
					<div class="panel-heading">员工列表
						<form action="Search" method="post" style="float:right">
							<select name="choose">
								<option value="1">按工号查询</option>
								<option value="2">按姓名查询</option>
								<option value="3">按岗位查询</option>
								<option value="4">按部门查询</option>
							</select>
							<input type="text" name="text" placeholder="请输入查询">
							<input type="submit" value="查询">
						</form>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-responsive table-hover">
							<thead>
								<tr>
									<th>工号</th>
									<th>姓名</th>
									<th>健康状况</th>
									<th>出生日期</th>
									<th>政治面貌</th>
									<th>岗位名</th>
									<th>部门名</th>
								</tr>
							</thead>
							<tbody>
							
							<%	if(list1.size()!=0){
								
								for(Staff s:list1){ %>
								<tr>
									<td><%=s.getNum() %></td>
									<td><%=s.getName() %></td>
									<td><%=s.getHealth() %></td>
									<td><%=s.getBirthday() %></td>
									<td><%=s.getPolitical() %></td>
									<td><%=s.getDep_id().getName() %></td>
									<td><%=s.getJob_id().getName() %></td>
								</tr>
							<%}
								}%>
							</tbody>
						</table>
					</div>
				</div>

				<!--分页 -->
				<nav>
					<ul class="pagination pull-right">
						<li  class="previous"><a href="#">&laquo;</a></li>
						<% for(int i=0;i<pagecount;i++){
							if(pagenow==i+1){
								%>
								<li class="active"><a href="#"><%=i+1%></a></li>
								<%
							}else{
							%>
								<li><a href="search.jsp?Page=<%=i+1 %>"><%=i+1%></a></li>
							<%} %>
						<% }%>
						<li><a href="#">&raquo;</a></li>
					</ul>

				</nav>
			</div>
		</div>
  	</div>
</div>
<!-- 尾部 -->
<div class="jumbotron" style="position: absolute; bottom: 0px; width: 100%;">
	<div class="container">
	<span>&copy; 2019 RunningHeart</span>
	</div>
</div>


	<script src="static/js/jquery-3.1.0.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>