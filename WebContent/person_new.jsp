<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% %>
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
					<a href="person_list.jsp?Page=1" class="list-group-item">人事管理</a>
					<a href="#" class="list-group-item text-center active">新进登记</a>
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
					<div class="panel-heading">新进登记</div>
					<div class="panel-body">
						<form action="StaffServlet" method="post" class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">工号：</label>
                                <div class="col-sm-5">
                                    <input type="text" name="num" class="form-control" placeholder="11位工号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">姓名：</label>
                                <div class="col-sm-5">
                                    <input type="text" name="name" class="form-control" placeholder="姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">健康状况：</label>
                                <div class="col-sm-5">
                                    <input type="text" name="health" class="form-control" placeholder="健康状况">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">出生日期：</label>
                                <div class="col-sm-5">
                                    <input name="birthday" type="date"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">政治面貌：</label>
                                <div class="col-sm-5">
                                    <select name="political">
                                    	<option value="群众">群众</option>
                                    	<option value="团员">团员</option>
                                    	<option value="党员">党员</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">岗位名：</label>
                                <div class="col-sm-5">
                                    <input type="text" name="job" class="form-control" placeholder="岗位名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">部门名：</label>
                                <div class="col-sm-5">
                                    <input type="text" name="dep" class="form-control" placeholder="部门名">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </form>
					</div>
				</div>

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