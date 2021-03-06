<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>xxx | 主页</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body>
<div id="wrapper">
    <jsp:include page="navigation.jsp"/>

    <div id="page-wrapper" class="gray-bg dashbard-1">

        <jsp:include page="EnterpriseAgencytopSidebar.jsp"/>

        <div class="row  border-bottom white-bg dashboard-header">

            <div class="col-md-3">
                <h2>欢迎您xxx</h2>
                <small>您有42条消息和6条通知。</small>
                <ul class="list-group clear-list m-t">
                    <li class="list-group-item fist-item">
                            <span class="float-right">
                                09:00
                            </span>
                        <span class="label label-success">1</span> 研发新项目1
                    </li>
                    <li class="list-group-item">
                            <span class="float-right">
                                10:16
                            </span>
                        <span class="label label-info">2</span> 研发新项目2
                    </li>
                    <li class="list-group-item">
                            <span class="float-right">
                                08:22
                            </span>
                        <span class="label label-primary">3</span> 研发新项目3
                    </li>
                    <li class="list-group-item">
                            <span class="float-right">
                                11:06
                            </span>
                        <span class="label label-default">4</span> 研发新项目4
                    </li>
                    <li class="list-group-item">
                            <span class="float-right">
                                12:00
                            </span>
                        <span class="label label-primary">5</span> 研发新项目5
                    </li>
                </ul>
            </div>
            <div class="col-md-6">
                <div class="flot-chart dashboard-chart">
                    <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                </div>
                <div class="row text-left">
                    <div class="col">
                        <div class=" m-l-md">
                            <span class="h5 font-bold m-t block">$ 406,100</span>
                            <small class="text-muted m-b block">总销售收入</small>
                        </div>
                    </div>
                    <div class="col">
                        <span class="h5 font-bold m-t block">$ 150,401</span>
                        <small class="text-muted m-b block">年销售收入</small>
                    </div>
                    <div class="col">
                        <span class="h5 font-bold m-t block">$ 16,822</span>
                        <small class="text-muted m-b block">月销售收入</small>
                    </div>

                </div>
            </div>
            <div class="col-md-3">
                <div class="statistic-box">
                    <h4>
                        游戏项目测试进度
                    </h4>
                    <p>
                        你有两个项目没有完成任务。
                    </p>
                    <div class="row text-center">
                        <div class="col-lg-6">
                            <canvas id="doughnutChart2" width="80" height="80" style="margin: 18px auto 0"></canvas>
                            <h5>传奇世界</h5>
                        </div>
                        <div class="col-lg-6">
                            <canvas id="doughnutChart" width="80" height="80" style="margin: 18px auto 0"></canvas>
                            <h5>王者霸业</h5>
                        </div>
                    </div>
                    <div class="m-t">
                        <small>项目未完成描述信息。</small>
                    </div>

                </div>
            </div>

        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>数据报告 </h5> <span class="label label-primary">IN+</span>
                                    <div class="ibox-tools">
                                        <a class="collapse-link" href="">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                            <i class="fa fa-wrench"></i>
                                        </a>
                                        <ul class="dropdown-menu dropdown-user">
                                            <li>
                                                <a href="#" class="dropdown-item">选项 1</a>
                                            </li>
                                            <li>
                                                <a href="#" class="dropdown-item">选项 2</a>
                                            </li>
                                        </ul>
                                        <a class="close-link" href="">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <div>

                                        <div class="float-right text-right">

                                            <span class="bar_dashboard">5,3,9,6,5,9,7,3,5,2,4,7,3,2,7,9,6,4,5,7,3,2,1,0,9,5,6,8,3,2,1</span>
                                            <br/>
                                            <small class="font-bold">$ 20 054.43</small>
                                        </div>
                                        <h4>
                                            游戏数据报告!
                                            <br/>
                                            <small class="m-r"><a href="graph_flot.html"> 查看所有数据! </a> </small>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>最新评论</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link" href="">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                            <i class="fa fa-wrench"></i>
                                        </a>
                                        <ul class="dropdown-menu dropdown-user">
                                            <li>
                                                <a href="#" class="dropdown-item">选项 1</a>
                                            </li>
                                            <li>
                                                <a href="#" class="dropdown-item">选项 2</a>
                                            </li>
                                        </ul>
                                        <a class="close-link" href="">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content no-padding">
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <p><a class="text-info" href="#">@皇帝</a> 人生就像考古一样，总是要不断地探索和寻觅，才会有意外的惊喜出现！
                                            </p>
                                            <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 分钟</small>
                                        </li>
                                        <li class="list-group-item">
                                            <p><a class="text-info" href="#">@太后</a> 人生就像考古一样，总是要不断地探索和寻觅，才会有意外的惊喜出现！
                                            </p>
                                            <div class="text-center m">
                                                <span id="sparkline8"></span>
                                            </div>
                                            <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 小时</small>
                                        </li>
                                        <li class="list-group-item">
                                            <p><a class="text-info" href="#">@皇后</a> 人生就像考古一样，总是要不断地探索和寻觅，才会有意外的惊喜出现！
                                            </p>
                                            <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 分钟</small>
                                        </li>
                                        <li class="list-group-item ">
                                            <p><a class="text-info" href="#">@太师</a> 人生就像考古一样，总是要不断地探索和寻觅，才会有意外的惊喜出现！
                                            </p>
                                            <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 小时</small>
                                        </li>
                                        <li class="list-group-item">
                                            <p><a class="text-info" href="#">@宫女</a> 人生就像考古一样，总是要不断地探索和寻觅，才会有意外的惊喜出现！
                                            </p>
                                            <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 分钟</small>
                                        </li>
                                        <li class="list-group-item">
                                            <p><a class="text-info" href="#">@太监</a> 人生就像考古一样，总是要不断地探索和寻觅，才会有意外的惊喜出现！
                                            </p>
                                            <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 分钟</small>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>最新消息</h5>
                                    <div class="ibox-tools">
                                        <span class="label label-warning-light float-right">10条消息未读</span>
                                    </div>
                                </div>
                                <div class="ibox-content">

                                    <div>
                                        <div class="feed-activity-list">

                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/profile.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right">5分钟</small>
                                                    <strong>小王</strong> 晚上要一起去吃饭吗 <br>
                                                    <small class="text-muted">2017.12.12 12:00</small>

                                                </div>
                                            </div>

                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/a2.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right">2个月</small>
                                                    <strong>小王</strong> 查看了 <strong>晚上睡觉有必要把路由器关掉么？</strong><br>
                                                    <small class="text-muted">2017.12.12 12:00</small>
                                                </div>
                                            </div>
                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/a3.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right">2小时</small>
                                                    <strong>小王</strong> 查看了 <strong>晚上睡觉有必要把路由器关掉么？</strong>.<br>
                                                    <small class="text-muted">2017.12.12 12:00</small>
                                                </div>
                                            </div>
                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/a4.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right text-navy">5小时</small>
                                                    <strong>小王</strong> 查看了 <strong>晚上睡觉有必要把路由器关掉么？</strong><br>
                                                    <small class="text-muted">2017.12.12 12:00</small>
                                                    <div class="actions">
                                                        <a class="btn btn-xs btn-white"><i class="fa fa-thumbs-up"></i>
                                                            赞 </a>
                                                        <a class="btn btn-xs btn-white"><i class="fa fa-heart"></i>
                                                            喜欢</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/a5.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right">2小时</small>
                                                    <strong>小王</strong> 评论了 <strong>晚上睡觉有必要把路由器关掉么？</strong><br>
                                                    <small class="text-muted">2017.12.12 12:00</small>
                                                    <div class="well">
                                                        人生就好像你搭乘一辆火车，沿途有不同的景色，不同的站台，和不同的人上车，也会过了这个景点到下一个景点，到下一个站台，不同的人上下车，那些都是过客，重要的是自己的旅程。
                                                    </div>
                                                    <div class="float-right">
                                                        <a class="btn btn-xs btn-white"><i class="fa fa-thumbs-up"></i>
                                                            赞 </a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/profile.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right">23h ago</small>
                                                    <strong>小王</strong> 评论了 <strong>晚上睡觉有必要把路由器关掉么？</strong><br>
                                                    <small class="text-muted">2017.12.12 12:00</small>
                                                </div>
                                            </div>
                                            <div class="feed-element">
                                                <a class="float-left" href="profile.html">
                                                    <img alt="image" class="rounded-circle" src="img/a7.jpg">
                                                </a>
                                                <div class="media-body ">
                                                    <small class="float-right">46h ago</small>
                                                    <strong>小王</strong> 评论了 <strong>晚上睡觉有必要把路由器关掉么？</strong><br>
                                                    <small class="text-muted">2017.12.12 12:00</small>
                                                </div>
                                            </div>
                                        </div>

                                        <button class="btn btn-primary btn-block m-t"><i class="fa fa-arrow-down"></i>
                                            加载更多
                                        </button>

                                    </div>

                                </div>
                            </div>

                        </div>
                        <div class="col-lg-4">
                            <div class="ibox ">
                                <div class="ibox-title">
                                    <h5>开发项目</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link" href="">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                            <i class="fa fa-wrench"></i>
                                        </a>
                                        <ul class="dropdown-menu dropdown-user">
                                            <li>
                                                <a href="#" class="dropdown-item">选项 1</a>
                                            </li>
                                            <li>
                                                <a href="#" class="dropdown-item">选项 2</a>
                                            </li>
                                        </ul>
                                        <a class="close-link" href="">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content ibox-heading">
                                    <h3>你今天有会议！</h3>
                                    <small><i class="fa fa-map-marker"></i> 上午6:00有会议。检查您的时间表以查看详细信息。</small>
                                </div>
                                <div class="ibox-content inspinia-timeline">

                                    <div class="timeline-item">
                                        <div class="row">
                                            <div class="col-4 date">
                                                <i class="fa fa-briefcase"></i>
                                                6:00 am
                                                <br/>
                                                <small class="text-navy">2小时前</small>
                                            </div>
                                            <div class="col content no-top-border">
                                                <p class="m-b-xs"><strong>与小王聊天</strong></p>

                                                <p>人生如一本书，应该多一些精彩的细节，少一些乏味的字眼。</p>

                                                <p><span data-diameter="40" class="updating-chart">5,3,9,6,5,9,7,3,5,2,5,3,9,6,5,9,4,7,3,2,9,8,7,4,5,1,2,9,5,4,7,2,7,7,3,5,2</span>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="timeline-item">
                                        <div class="row">
                                            <div class="col-4 date">
                                                <i class="fa fa-file"></i>
                                                7:00 am
                                                <br/>
                                                <small class="text-navy">3小时前</small>
                                            </div>
                                            <div class="col content">
                                                <p class="m-b-xs"><strong>与小王聊天</strong></p>
                                                <p>人生如一局棋，应该多一些主动的出击，少一些消极的退缩。</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="timeline-item">
                                        <div class="row">
                                            <div class="col-4 date">
                                                <i class="fa fa-coffee"></i>
                                                8:00 am
                                                <br/>
                                            </div>
                                            <div class="col content">
                                                <p class="m-b-xs"><strong>与小王聊天</strong></p>
                                                <p>
                                                    人生如一首诗，应该多一些悠扬的抒情，少一些愁苦的叹息。
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="timeline-item">
                                        <div class="row">
                                            <div class="col-4 date">
                                                <i class="fa fa-phone"></i>
                                                11:00 am
                                                <br/>
                                                <small class="text-navy">21小时前</small>
                                            </div>
                                            <div class="col content">
                                                <p class="m-b-xs"><strong>与小王打电话</strong></p>
                                                <p>
                                                    人生如一幅画，应该多一些亮丽的着色，少一些灰色的基调。
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="timeline-item">
                                        <div class="row">
                                            <div class="col-4 date">
                                                <i class="fa fa-user-md"></i>
                                                09:00 pm
                                                <br/>
                                                <small>21小时前</small>
                                            </div>
                                            <div class="col content">
                                                <p class="m-b-xs"><strong>与小王聊天</strong></p>
                                                <p>
                                                    人生如一支歌，应该多一些昂扬的吟唱，少一些哀婉的咏叹。
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="timeline-item">
                                        <div class="row">
                                            <div class="col-4 date">
                                                <i class="fa fa-comments"></i>
                                                12:50
                                                <br/>
                                                <small class="text-navy">48小时前</small>
                                            </div>
                                            <div class="col content">
                                                <p class="m-b-xs"><strong>与小王聊天</strong></p>
                                                <p>
                                                    人生犹如石材，在上面雕刻神或是魔鬼，那是各人的自由。
                                                </p>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
        <div class="footer">
            <div class="float-right">
                <strong>2.9.2 inspinia</strong>
            </div>
            <div>
                <strong>Copyright</strong> xxx &copy; 2020
            </div>
        </div>
    </div>
    <div class="small-chat-box fadeInRight animated">

        <div class="heading" draggable="true">
            <small class="chat-date float-right">
                2017.12.12
            </small>
            与 小王 聊天中
        </div>

        <div class="content">

            <div class="left">
                <div class="author-name">
                    小王 <small class="chat-date">
                    10:02 am
                </small>
                </div>
                <div class="chat-message active">
                    在吗？
                </div>

            </div>
            <div class="right">
                <div class="author-name">
                    游客
                    <small class="chat-date">
                        11:24
                    </small>
                </div>
                <div class="chat-message">
                    我不在！
                </div>
            </div>
            <div class="left">
                <div class="author-name">
                    小王
                    <small class="chat-date">
                        08:45
                    </small>
                </div>
                <div class="chat-message active">
                    不在还可以说话
                </div>
            </div>
            <div class="right">
                <div class="author-name">
                    游客
                    <small class="chat-date">
                        11:24
                    </small>
                </div>
                <div class="chat-message">
                    我是游客，所以我不在！
                </div>
            </div>
            <div class="left">
                <div class="author-name">
                    小王
                    <small class="chat-date">
                        08:45
                    </small>
                </div>
                <div class="chat-message active">
                    好吧
                </div>
            </div>


        </div>
        <div class="form-chat">
            <div class="input-group input-group-sm">
                <input type="text" class="form-control">
                <span class="input-group-btn">
                        <button class="btn btn-primary" type="button">
                            发送
                        </button>
                    </span>
            </div>
        </div>

    </div>
    <div id="small-chat">

        <span class="badge badge-warning float-right">5</span>
        <a class="open-small-chat" href="">
            <i class="fa fa-comments"></i>

        </a>
    </div>
    <div id="right-sidebar" class="animated">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">
                <li>
                    <a class="nav-link active" data-toggle="tab" href="#tab-1"> 记录 </a>
                </li>
                <li>
                    <a class="nav-link" data-toggle="tab" href="#tab-2"> 项目 </a>
                </li>
                <li>
                    <a class="nav-link" data-toggle="tab" href="#tab-3"> <i class="fa fa-gear"></i> </a>
                </li>
            </ul>

            <div class="tab-content">


                <div id="tab-1" class="tab-pane active">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 最新记录</h3>
                        <small><i class="fa fa-tim"></i> 你有10条新消息。</small>
                    </div>

                    <div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a1.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    人生就像钟表，可以回到起点，却已不是昨天！
                                    <br>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a2.jpg">
                                </div>
                                <div class="media-body">
                                    人生就像一本书，出生是封面，归去是封底，内容要靠自己填。
                                    <br>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    人生就像是一盘沙子，你永远也无法全盘抓起，但也不会一无所获。
                                    <br>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a4.jpg">
                                </div>

                                <div class="media-body">
                                    人生就像候车月台，有人上车，也有人下车，来来往往，你谁也抓不住！
                                    <br>
                                    <small class="text-muted">星期一 8:37</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a8.jpg">
                                </div>
                                <div class="media-body">
                                    人生就像卫生纸，没事的时候尽量少扯！
                                    <br>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a7.jpg">
                                </div>
                                <div class="media-body">
                                    人生就像一只钟摆，永远在渴望的痛苦和满足的厌倦之间摆动！
                                    <br>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    人生就像是一片海洋，里面的许多的奥秘要让我们去探究。
                                    <br>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a4.jpg">
                                </div>
                                <div class="media-body">
                                    人生就像一个空荡荡的巨大的坑，我们把时间丢进去，丢完了就完了！
                                    <br>
                                    <small class="text-muted">星期一 8:37</small>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>

                <div id="tab-2" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-cube"></i> 最新项目</h3>
                        <small><i class="fa fa-tim"></i> 你有14个项目。 10没有完成</small>
                    </div>

                    <ul class="sidebar-list">
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>新时尚</h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">时间: 2017.12.12 4:00</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>新游戏 </h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>新房产</h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary float-right">NEW</span>
                                <h4>新世界</h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 22%</div>
                                <div class="small text-muted m-t-xs">时间: 2017.12.12 4:00</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>新密码</h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">时间: 2017.12.12 4:00</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>新数据 </h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>新会议</h4>
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary float-right">NEW</span>
                                <h4>新业务</h4>
                                <!--<div class="small float-right m-t-xs">9小时前</div>-->
                                人生如一杯茶，不会苦一辈子，但要苦一阵子。
                                <div class="small">完成度: 22%</div>
                                <div class="small text-muted m-t-xs">时间: 2017.12.12 4:00</div>
                            </a>
                        </li>

                    </ul>

                </div>

                <div id="tab-3" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-gears"></i> 设置</h3>
                        <small><i class="fa fa-tim"></i> 你有13个项目，10个没有完成</small>
                    </div>

                    <div class="setings-item">
                            <span>
                                显示通知
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example">
                                <label class="onoffswitch-label" for="example">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                            <span>
                                即时聊天
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" checked class="onoffswitch-checkbox"
                                       id="example2">
                                <label class="onoffswitch-label" for="example2">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                            <span>
                                历史记录
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example3">
                                <label class="onoffswitch-label" for="example3">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                            <span>
                                显示图表
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example4">
                                <label class="onoffswitch-label" for="example4">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                            <span>
                                离线用户
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox"
                                       id="example5">
                                <label class="onoffswitch-label" for="example5">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                            <span>
                                网站搜索
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox"
                                       id="example6">
                                <label class="onoffswitch-label" for="example6">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                            <span>
                                每天更新
                            </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example7">
                                <label class="onoffswitch-label" for="example7">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="sidebar-content">
                        <h4>设置</h4>
                        <div class="small">
                            设置描述设置描述设置描述设置描述设置描述设置描述设置描述设置描述设置描述设置描述设置描述设置描述设置描述
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Flot -->
<script src="js/plugins/flot/jquery.flot.js"></script>
<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="js/plugins/flot/jquery.flot.spline.js"></script>
<script src="js/plugins/flot/jquery.flot.resize.js"></script>
<script src="js/plugins/flot/jquery.flot.pie.js"></script>

<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>
<script src="js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- GITTER -->
<script src="js/plugins/gritter/jquery.gritter.min.js"></script>

<!-- Sparkline -->
<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="js/demo/sparkline-demo.js"></script>

<!-- ChartJS-->
<script src="js/plugins/chartJs/Chart.min.js"></script>

<!-- Toastr -->
<script src="js/plugins/toastr/toastr.min.js"></script>


<script>
    $(document).ready(function () {
        setTimeout(function () {
            toastr.options = {
                closeButton: true,
                progressBar: true,
                showMethod: 'slideDown',
                timeOut: 4000
            };
            toastr.success('${sessionScope.name}${sessionScope.type}', '欢迎您');

        }, 1300);


        var data1 = [
            [0, 4], [1, 8], [2, 5], [3, 10], [4, 4], [5, 16], [6, 5], [7, 11], [8, 6], [9, 11], [10, 30], [11, 10], [12, 13], [13, 4], [14, 3], [15, 3], [16, 6]
        ];
        var data2 = [
            [0, 1], [1, 0], [2, 2], [3, 0], [4, 1], [5, 3], [6, 1], [7, 5], [8, 2], [9, 3], [10, 2], [11, 1], [12, 0], [13, 2], [14, 8], [15, 0], [16, 0]
        ];
        $("#flot-dashboard-chart").length && $.plot($("#flot-dashboard-chart"), [
                data1, data2
            ],
            {
                series: {
                    lines: {
                        show: false,
                        fill: true
                    },
                    splines: {
                        show: true,
                        tension: 0.4,
                        lineWidth: 1,
                        fill: 0.4
                    },
                    points: {
                        radius: 0,
                        show: true
                    },
                    shadowSize: 2
                },
                grid: {
                    hoverable: true,
                    clickable: true,
                    tickColor: "#d5d5d5",
                    borderWidth: 1,
                    color: '#d5d5d5'
                },
                colors: ["#1ab394", "#1C84C6"],
                xaxis: {},
                yaxis: {
                    ticks: 4
                },
                tooltip: false
            }
        );

        var doughnutData = {
            labels: ["App", "Software", "Laptop"],
            datasets: [{
                data: [300, 50, 100],
                backgroundColor: ["#a3e1d4", "#dedede", "#9CC3DA"]
            }]
        };


        var doughnutOptions = {
            responsive: false,
            legend: {
                display: false
            }
        };


        var ctx4 = document.getElementById("doughnutChart").getContext("2d");
        new Chart(ctx4, {type: 'doughnut', data: doughnutData, options: doughnutOptions});

        var doughnutData = {
            labels: ["App", "Software", "Laptop"],
            datasets: [{
                data: [70, 27, 85],
                backgroundColor: ["#a3e1d4", "#dedede", "#9CC3DA"]
            }]
        };


        var doughnutOptions = {
            responsive: false,
            legend: {
                display: false
            }
        };


        var ctx4 = document.getElementById("doughnutChart2").getContext("2d");
        new Chart(ctx4, {type: 'doughnut', data: doughnutData, options: doughnutOptions});

    });
</script>
<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-4625583-2', 'webapplayers.com');
    ga('send', 'pageview');

</script>
<!--同步官网模板开始-->
<div class="theme-config">
    <div class="theme-config-box">
        <div class="spin-icon">
            <i class="fa fa-cogs fa-spin"></i>
        </div>
        <div class="skin-settings">
            <div class="title">
                配置 <br>
                <small style="text-transform: none;font-weight: 400">
                    配置框设计用户演示目的，所有选项课通过代码获得。
                </small>
            </div>
            <div class="setings-item">
                    <span>
                        折叠菜单
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                        <label class="onoffswitch-label" for="collapsemenu">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        固定侧边栏
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixedsidebar" class="onoffswitch-checkbox" id="fixedsidebar">
                        <label class="onoffswitch-label" for="fixedsidebar">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        顶级导航栏
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                        <label class="onoffswitch-label" for="fixednavbar">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        顶部导航栏V.2
                        <br>
                        <small>*主要布局</small>
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixednavbar2" class="onoffswitch-checkbox" id="fixednavbar2">
                        <label class="onoffswitch-label" for="fixednavbar2">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        盒子布局
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                        <label class="onoffswitch-label" for="boxedlayout">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        固定页脚
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixedfooter" class="onoffswitch-checkbox" id="fixedfooter">
                        <label class="onoffswitch-label" for="fixedfooter">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>

            <div class="title">换肤</div>
            <div class="setings-item default-skin">
                    <span class="skin-name ">
                        <a href="#" class="s-skin-0">
                            默认
                        </a>
                    </span>
            </div>
            <div class="setings-item blue-skin">
                    <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色
                        </a>
                    </span>
            </div>
            <div class="setings-item yellow-skin">
                    <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色
                        </a>
                    </span>
            </div>
            <div class="setings-item ultra-skin">
                    <span class="skin-name ">
                        <a href="#" class="md-skin">
                            绿色（没用）
                        </a>
                    </span>
            </div>
        </div>
    </div>
</div>
<script>
    // Config box

    // Enable/disable fixed top navbar
    $('#fixednavbar').click(function () {
        if ($('#fixednavbar').is(':checked')) {
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav');
            $('#boxedlayout').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout", 'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar", 'on');
            }
        } else {
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $("body").removeClass('fixed-nav-basic');
            $('#fixednavbar2').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar", 'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar2", 'off');
            }
        }
    });

    // Enable/disable fixed top navbar
    $('#fixednavbar2').click(function () {
        if ($('#fixednavbar2').is(':checked')) {
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav').addClass('fixed-nav-basic');
            $('#boxedlayout').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout", 'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar2", 'on');
            }
        } else {
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav').removeClass('fixed-nav-basic');
            $('#fixednavbar').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar2", 'off');
            }
            if (localStorageSupport) {
                localStorage.setItem("fixednavbar", 'off');
            }
        }
    });

    // Enable/disable fixed sidebar
    $('#fixedsidebar').click(function () {
        if ($('#fixedsidebar').is(':checked')) {
            $("body").addClass('fixed-sidebar');
            $('.sidebar-collapse').slimScroll({
                height: '100%',
                railOpacity: 0.9
            });

            if (localStorageSupport) {
                localStorage.setItem("fixedsidebar", 'on');
            }
        } else {
            $('.sidebar-collapse').slimscroll({destroy: true});
            $('.sidebar-collapse').attr('style', '');
            $("body").removeClass('fixed-sidebar');

            if (localStorageSupport) {
                localStorage.setItem("fixedsidebar", 'off');
            }
        }
    });

    // Enable/disable collapse menu
    $('#collapsemenu').click(function () {
        if ($('#collapsemenu').is(':checked')) {
            $("body").addClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport) {
                localStorage.setItem("collapse_menu", 'on');
            }

        } else {
            $("body").removeClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport) {
                localStorage.setItem("collapse_menu", 'off');
            }
        }
    });

    // Enable/disable boxed layout
    $('#boxedlayout').click(function () {
        if ($('#boxedlayout').is(':checked')) {
            $("body").addClass('boxed-layout');
            $('#fixednavbar').prop('checked', false);
            $('#fixednavbar2').prop('checked', false);
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $("body").removeClass('fixed-nav-basic');
            $(".footer").removeClass('fixed');
            $('#fixedfooter').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar", 'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar2", 'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixedfooter", 'off');
            }


            if (localStorageSupport) {
                localStorage.setItem("boxedlayout", 'on');
            }
        } else {
            $("body").removeClass('boxed-layout');

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout", 'off');
            }
        }
    });

    // Enable/disable fixed footer
    $('#fixedfooter').click(function () {
        if ($('#fixedfooter').is(':checked')) {
            $('#boxedlayout').prop('checked', false);
            $("body").removeClass('boxed-layout');
            $(".footer").addClass('fixed');

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout", 'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixedfooter", 'on');
            }
        } else {
            $(".footer").removeClass('fixed');

            if (localStorageSupport) {
                localStorage.setItem("fixedfooter", 'off');
            }
        }
    });

    // SKIN Select
    $('.spin-icon').click(function () {
        $(".theme-config-box").toggleClass("show");
    });

    // Default skin
    $('.s-skin-0').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
    });

    // Blue skin
    $('.s-skin-1').click(function () {
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-1");
    });

    // Inspinia ultra skin
    $('.s-skin-2').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-2");
    });

    // Yellow skin
    $('.s-skin-3').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").addClass("skin-3");
    });

    if (localStorageSupport) {
        var collapse = localStorage.getItem("collapse_menu");
        var fixedsidebar = localStorage.getItem("fixedsidebar");
        var fixednavbar = localStorage.getItem("fixednavbar");
        var fixednavbar2 = localStorage.getItem("fixednavbar2");
        var boxedlayout = localStorage.getItem("boxedlayout");
        var fixedfooter = localStorage.getItem("fixedfooter");

        if (collapse == 'on') {
            $('#collapsemenu').prop('checked', 'checked')
        }
        if (fixedsidebar == 'on') {
            $('#fixedsidebar').prop('checked', 'checked')
        }
        if (fixednavbar == 'on') {
            $('#fixednavbar').prop('checked', 'checked')
        }
        if (fixednavbar2 == 'on') {
            $('#fixednavbar2').prop('checked', 'checked')
        }
        if (boxedlayout == 'on') {
            $('#boxedlayout').prop('checked', 'checked')
        }
        if (fixedfooter == 'on') {
            $('#fixedfooter').prop('checked', 'checked')
        }
    }
</script>
<!--同步官网模板结束-->
</body>

</html>
