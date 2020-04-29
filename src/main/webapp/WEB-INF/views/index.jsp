<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="./template/boot.jsp"></c:import>

</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<button id="btn">Button</button>
	<button id="btn2">Button2</button>
	
	<script type="text/javascript">
		$("#btn").click(function() {
			//jquery Ajax
			//Get
			$.get("./json/json1", function(data) {
				
				//0.data가 String인지 Json Object인지 판별
				// console.loag(data);	"name":"iu" -> String
				// console.loag(data);	object -> json Obj

				//1-1.String 일 경우, Json Object 반환
				//data = data.trim();
				console.log(data);
				console.log(data.num);
				console.log(data.title);
			});
		});
		
		$("#btn2").click(function() {
			//$.ajax
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY", function(data) {
				console.log(data[1].rate);
			});
		})
	</script>
</body>
</html>



