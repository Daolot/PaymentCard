<%@ page language="java" pageEncoding="Cp1251" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="6417ec49-aa65-48f9-a7e5-1da3bbff98c2">


    <link href="/static/css/boot.css" rel="stylesheet">
    <link href="/static/css/dashboard.css" rel="stylesheet">
    <link href="/static/images/favicon%20(3).ico" rel="shortcut icon" type="image/x-icon" />

    <script src="/static/js/jquery-3.2.1.js"></script>
    <%--<script src="/static/js/tether.min.js"></script>--%>
    <script src="/static/js/admin.js"></script>

    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>--%>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


    <script>
//        getCities();
//        getRollers();
//        getTypeCard();
//        getCompanies();
//        $(document).ready(function () {
//            getUsers();
//        });
        getDrivers();
        getUsers();
        getOwners();
    </script>


</head>

<body style="background-color: #EDEEF0">
<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

            <a class="navbar-brand" style="color: white">Payment Card</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a><strong>${loggedinuser}</strong></a></li>
                <li><a href="/logout">�����</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div><!-- /.navbar -->
<div id="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 hidden-xs-down sidebar">

                    <div  class="dropdown ofset">
                        <button type="button" class="btn btn-primary btn-block" data-toggle="dropdown">��������
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu ">
                            <li><a onclick="showUsers();">������ �������������</a></li>
                            <li><a onclick="getOwners();">������ ����������</a></li>
                            <li><a onclick="getDrivers();">������ ���������</a></li>
                            <li><a onclick="getCards();">������ ����</a></li>
                        </ul>
                    </div>
                <div class="dropdown ofset">
                    <button type="button" class="btn btn-primary btn-block" data-toggle="dropdown">
                        ��������
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu contmenu">
                        <li><a onclick="window.location='/registration'">������������</a></li>
                        <li><a onclick="window.location='/admin/addOwner'">���������</a></li>
                        <li><a onclick="window.location='/admin/addDriver'">��������</a></li>
                        <li><a onclick="window.location='/admin/addCompany'">��������</a></li>
                        <li><a onclick="window.location='/admin/addCard'">�����</a></li>
                        <li><a onclick="window.location='/admin/addBus'">�������</a></li>
                        <li><a onclick="window.location='/admin/addRoute'">�������</a></li>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/registration'">������������</button>--%>
                        <%--<br>--%>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/admin/addOwner'">���������</button>--%>
                        <%--<br>--%>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/admin/addDriver'">��������</button>--%>
                        <%--<br>--%>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/admin/addCompany'">��������</button>--%>
                        <%--<br>--%>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/admin/addCard'">�����</button>--%>
                        <%--<br>--%>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/admin/addBus'">�������</button>--%>
                        <%--<br>--%>
                        <%--<button type="button" class="btn btn-link" onclick="window.location='/admin/addRoute'">�������</button>--%>
                    </ul>
                </div>
                <div class="dropdown">
                    <button type="button" class="btn btn-primary ofset btn-block" onclick="deleteUser()">�������
                    </button>
                </div>
                <div class="dropdown">
                    <button type="button" class="btn btn-primary ofset btn-block" onclick="edit()">�������������
                    </button>
                </div>
            </div>

            <div id="head" class="col-sm-9 col-sm-offset-3  col-md-10 col-md-offset-2 pt-3">
            </div>
        </div>
    </div>
</div>


</body>
</html>