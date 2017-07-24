<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 2017/7/23
  Time: 上午12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <%@include file="common/header.jsp"%>
    <title>商品详情页</title>
</head>
<body>

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">双十一秒杀</div>
        <div class="panel-body">
            <p>火热抢购，心动不如行动</p>
        </div>

        <!-- Table -->

        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>商品名</th>
                <th>数量</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>创建时间</th>
                <th>秒杀</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sk" items="${secKills}" varStatus="status">
            <tr>
                <th scope="row">${status.count}</th>
                <td>${sk.name}</td>
                <td>${sk.number}</td>
                <td><fmt:formatDate value="${sk.startTime}" type="both" dateStyle="medium" timeStyle="medium" /></td>
                <td><fmt:formatDate value="${sk.endTime}" type="both" dateStyle="medium" timeStyle="medium"/> </td>
                <td><fmt:formatDate value="${sk.createTime}" type="both" dateStyle="medium" timeStyle="medium" /></td>
                <th> <a href="/seckill/${sk.seckillId}/detail" class="button button-primary button-pill button-small">Go</a></th>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
