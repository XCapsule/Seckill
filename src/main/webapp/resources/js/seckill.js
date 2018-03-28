//javascript模块化
var seckill ={
    //封装秒杀地址相关ajax的url
    URL:{
        now :function () {
            return "/seckill/time/now";
        },
        exposer:function (seckillId) {
            return "/seckill/"+seckillId+"/exposer";
        },
        seckilll:function (md5,seckillId) {
            return "/seckill/"+seckillId+"/"+md5+"/execution";
        }
    },
    //验证逻辑
    validatePhone:function (killPhone){
        if(killPhone&&killPhone.length==11&&!isNaN(killPhone)){
            return true;
        }else
            return false;
    },
    handleSeckillkill:function (seckillId,node) {
        node.hide().html("<a  id='seckillBtn' class='btn btn-primary btn-lg'  role='button'>秒杀</a>");
        $.post(seckill.URL.exposer(seckillId),{},
            function (result) {
                if(result&&result['success']){
                    var exposer=result['data'];
                    //开启
                    if(exposer['exposer']){
                        var md5=exposer['md5'];
                        var seckillURL=seckill.URL.seckilll(md5,seckillId);
                        var userPhone=$.cookie('killPhone');
                        $('#seckillBtn').one('click',function () {
                            //先禁用按钮
                            $(this).addClass('mydisabled');
                            //发送秒杀的请求
                            $.post(seckillURL,{'userPhone':userPhone},function (result) {
                                if(result&&result['success']){
                                    var execution=result['data'];
                                    var info=execution['statusInfo'];
                                    if(execution['status']!=1){
                                        node.html("<a  class='button button-glow button-rounded button-caution mydisabled'>"+info+"</a>");}
                                    else{
                                        node.html("<a  class='button button-glow button-rounded button-primary mydisabled'>"+info+"</a>");
                                    }
                                    }
                            });
                        })
                    }else{
                        var nowTime=exposer['now'];
                        var startTime=exposer['startTime'];
                        var endTime=exposer['endTime'];
                        seckill.countDown(seckillId,nowTime,startTime,endTime);
                    }
                }
            }
        )
        node.show();
    },
    countDown:function (seckillId,nowTime,startTime,endTime) {
        var skillBox=$('#skillTime');
        if(nowTime>endTime) {
            skillBox.html( "<a  class='button button-glow button-rounded button-caution mydisabled'>秒杀已结束</a>");
        }else if(nowTime<startTime){
            var seckillTime=new Date(startTime);
            skillBox.countdown(seckillTime,function (event) {
                var format=event.strftime('秒杀倒计时：%D天  %H时 %M分  %S秒 ' );
                skillBox.html(

                "<div class='alert alert-info' role='alert'>"+format+"</div>");
            //    ======================================================================================================
            }).on('finish.countdown',function (secillId) {
                seckill.handleSeckillkill(secillId,skillBox)
            })
        }else{
            seckill.handleSeckillkill(seckillId,skillBox);
        }

    },
    //详情页相关逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //    手机验证登录+计时
            var killPhone = $.cookie('killPhone');
            if (!seckill.validatePhone(killPhone)) {
                $('.modal').modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
                $('#killPhoneButton').click(function () {
                    var inputPhone = $('#killPhone').val();
                    if (!seckill.validatePhone(inputPhone)) {
                        $('#errorPhone').hide().html('<span class="label label-danger">手机号错误</span>').show(300);

                    } else {
                        $.cookie('killPhone', inputPhone, {expires: 7, path: '/seckill'});
                        window.location.reload();
                    }
                });
            }
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data']
                    seckill.countDown(seckillId, nowTime, startTime, endTime);
                }
            })
        }
    }}
