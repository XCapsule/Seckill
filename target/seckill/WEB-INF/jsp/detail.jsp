<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 2017/7/23
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <%@include file="common/header.jsp"%>
    <link href="https://cdn.bootcss.com/jquery.tipsy/1.0.3/jquery.tipsy.css" rel="stylesheet">
    <link href="/resources/css/mystyle.css" rel="stylesheet">
    <title>${secKill.name}</title>
</head>
<body>
<div class="myjumbotron header${secKill.seckillId}" >
    <h1>${secKill.name}</h1>

    <p class="transparentBg"><strong>温馨提示:</strong>所有在 Apple Store 官方旗舰店的订单的发货时间、付款期限及购买上限均以商品页面规定为准。
        所有在本店销售的商品，请在拍下后 15 分钟内完成支付。逾期，您的订单将被关闭。</p>
    <p></p>
    <div id="skillTime" class="text-center">

    </div>
</div>


<%--输入信息模态框--%>
<div class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">用户登录</h4>
            </div>
            <div class="modal-body">
                <input type="text" class="form-control" name="killPhone" id="killPhone" placeholder="请输入手机号" />
            </div>
            <div class="modal-footer">
                <div id="errorPhone" class="glyphicon"></div>
                <button type="button" class="btn btn-primary" id="killPhoneButton" >提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
    <script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.js"></script>
    <script src="/resources/js/seckill.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            seckill.detail.init({
                seckillId: ${secKill.seckillId},
                startTime:${secKill.startTime.time},
                endTime:${secKill.endTime.time}
            })
        })
    </script>
</html>
