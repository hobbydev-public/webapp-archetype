
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en" ng-app="timeOffApp">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<base href="${app}/">
		<title>TimeOff</title>
		<link rel="styleSheet" href="res/app/js/node_modules/angular-ui-grid/ui-grid.css"/>
		<link rel="stylesheet" href="res/app/js/node_modules/bootstrap/dist/css/bootstrap.css">
		<link rel="stylesheet" href="res/app/js/node_modules/font-awesome/css/font-awesome.css">
		<link rel="stylesheet" href="res/app/js/node_modules/admin-lte/dist/css/AdminLTE.css">
		<link rel="stylesheet" href="res/app/js/node_modules/admin-lte/dist/css/skins/_all-skins.min.css">
	</head>
	
	<body class="skin-blue fixed">
		<div class="wrapper">
			<header class="main-header"><top-nav-bar></top-nav-bar></header>
			<aside class="main-sidebar">
				<div class="sidebar">
					<ul class="sidebar-menu">
						<li class="header">MAIN NAVIGATION</li>
						<li><a href="#!/dashboard"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
						<sec:authorize access="hasAnyRole('HR', 'ADMIN')">
							<li class="treeview">
								<a href="">
									<i class="fa fa-shield"></i>
									<span>Administration</span>
									<span class="pull-right-container">
										<i class="fa fa-angle-left pull-right"></i>
									</span>
								</a>

								<ul class="treeview-menu">
									<li><a href="#!/admin/users"><i class="fa fa-user"></i> Users</a></li>
									<li><a href="#!/admin/policies"><i class="fa fa-circle-o"></i> Policies</a></li>
								</ul>
							</li>
						</sec:authorize>
					</ul>
				</div>
			</aside>
			<div class="content-wrapper">
				<div ng-view></div>
			</div>
			<footer class="main-footer">
				<div class="pull-right hidden-xs">
					<a href="docs">API Reference</a>
				</div>

				<!-- Default to the left -->
				TimeOff | 2017
			</footer>
			<aside class="control-sidebar control-sidebar-dark">

				<!-- TABS -->
				<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
					<li class="active"><a href="#control-sidebar-look-and-feel-tab" data-toggle="tab"><i class="fa fa-adjust"></i></a></li>
				</ul>

				<!-- TAB PANES -->
				<div class="tab-content">
					<div class="tab-pane active" id="control-sidebar-look-and-feel-tab">
						<h4 class="control-sidebar-heading">Skins</h4>

						<ul class="list-unstyled clearfix">
							<li class="skin-preview"
								style="float:left; width: 33.33333%; padding: 5px;">

								<a href="" data-skin="skin-blue" class="clearfix full-opacity-hover"
								   style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)">

									<div>
										<span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9;"></span>
										<span class="bg-light-blue"
											  style="display:block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span>
										<span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span>
									</div>
								</a>
								<p class="text-center no-margin">Blue</p>
							</li>
						</ul>
					</div>
				</div>
			</aside>
			<div class="control-sidebar-bg"></div>

		</div>



		<script src="res/vendor/datejs/date.js"></script>
		<script src="res/vendor/bignumber/bignumber.js"></script>

		<script src="res/app/js/dist/vendor.bundle.js"></script>
		<script src="res/app/js/node_modules/admin-lte/dist/js/app.js"></script>
		<script src="res/app/js/node_modules/admin-lte/plugins/slimScroll/jquery.slimscroll.js"></script>

		<script src="res/app/js/dist/app.bundle.js"></script>
	</body>
</html>