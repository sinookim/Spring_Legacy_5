<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header_sub.jsp"></c:import>


	<div class="container">
		<div class="row">
			<h1>${board}List</h1>
			<form class="col-xs-6" action="./${board}List">
				<div class="input-group" style="display: inline-block;">
					<select class="form-control" id="sel1" name="kind"
						style="width: 110px">
						<option value="id">id</option>
						<option value="name">name</option>
						<option value="email">email</option>
						<option value="phone">phone</option>
					</select> <input type="text" class="form-control" placeholder="Search"
						name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>

		<br>

		<table class="table table-hover">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>EMAIL</td>
				<td>PHONE</td>
			</tr>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.id}</td>
					<td>${vo.name}</td>
					<td>${vo.email}</td>
					<td>${vo.phone}</td>
				</tr>
			</c:forEach>
		</table>

		<div style="margin: 0 auto; width: 100%; text-align: center;">
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><a
						href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><a
						href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a
						href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
				</c:if>
			</ul>
		</div>

	</div>

</body>
</html>