<html>
<head>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/common.css' />" />
</head>
<body>
	
	<div>
		<div class="header">
			<div>MANSOO HOME</div>
			<div><jsp:include page="/loginpage" /></div>
		</div>
		
		<div id="topNav">
			<div class="topNavi">
				<ul>
					<li><a href="/mansoo">home</a></li>
					<li><a href="/mansoo/?body=/contact">contact</a></li>
					<li><a href="/mansoo">menu1</a></li>
					<li><a href="/mansoo">menu2</a></li>
					<li><a href="/mansoo">menu3</a></li>
				</ul>
			</div>
		</div>
		
		<div id="bodyContents">
			<jsp:include page="${body}" />
		</div>
		
		<div id="footer">
		</div>
	</div>

</body>
</html>