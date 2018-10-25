<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Products</title>
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Custom Theme files -->
	<link href="../css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="../css/style.css" type="text/css" rel="stylesheet" media="all">
	<link href="../css/form.css" rel="stylesheet" type="text/css" media="all" />
	<link href="../css/cmxform.css" type="text/css" rel="stylesheet" media="all">
	<!-- js -->
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap-3.1.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.js"></script>
	<script type="text/javascript" src="../js/form-validation.js"></script>
	<!-- //js -->
	<!-- cart -->
	<script src="../js/simpleCart.min.js"> </script>
	<!-- cart -->
	<script type="text/javascript" src="../js/jquery.mousewheel.js"></script>
	<!-- the mousewheel plugin -->
</head>
<body>
<%@ include file="/pages/header.jsp" %>
<!--products-->
<div class="products">
	<div class="container">
		<h2>Our Products</h2>
		<div class="col-md-9 product-model-sec">
			<c:forEach items="${allbooks}" var="book">
				<form method="post" action="/GetDetailServlet" name="detailForm" id="detailForm">
					<div class="product-grid">
							<div class="more-product"></div>
							<div class="product-img b-link-stripe b-animate-go  thickbox">
								<input hidden="hidden" name="bid" value="${book.bookid}">
								<img src="${book.imgUrl}" class="img-responsive" alt="">
								<div class="b-wrapper">
									<h4 class="b-animate b-from-left  b-delay03">
										<button type="submit">View</button>
									</h4>
								</div>
							</div>
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4>${book.title}</h4>
								<span class="item_price">$${book.price}</span>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
		<div class="col-md-3 span_1_of_left">
			<section  class="sky-form">
				<div class="product_right">
					<h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Categories</h4>
					<c:forEach items="${categories}" var="category">
						<div class="tab1">
							<form action="/GetByCategoryServlet" method="post" name="categoryForm" id="categoryForm">
								<input hidden="hidden" name="cid" value="${category.id}">
								<ul class="place">
									<li class="sort">${category.category}</li>
									<li class="by"><button type="submit"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span></button></li>
								</ul>
							</form>
							<div class="clearfix"> </div>
						</div>
					</c:forEach>
				</div>
			</section>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//products-->

<!--footer-->
<%@ include file="/pages/footer.jsp" %>
<!--//footer-->
</body>
</html>