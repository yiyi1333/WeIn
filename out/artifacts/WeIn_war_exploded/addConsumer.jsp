<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/2
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>xxx | 基础表单</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <img alt="image" class="rounded-circle" src="img/profile_small.jpg"/>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="block m-t-xs font-bold">xxx</span>
                            <span class="text-muted text-xs block">管理员 <b class="caret"></b></span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="dropdown-item" href="profile.html">个人信息</a></li>
                            <li><a class="dropdown-item" href="contacts.html">好友</a></li>
                            <li><a class="dropdown-item" href="mailbox.html">信箱</a></li>
                            <li class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="login.html">登出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                <li>
                    <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="index.html">主页示例 v.1</a></li>
                        <li><a href="dashboard_2.html">主页示例 v.2</a></li>
                        <li><a href="dashboard_3.html">主页示例 v.3</a></li>
                        <li><a href="dashboard_4_1.html">主页示例 v.4</a></li>
                        <li><a href="dashboard_5.html">主页示例 v.5 </a></li>
                    </ul>
                </li>
                <li>
                    <a href="layouts.html"><i class="fa fa-diamond"></i> <span class="nav-label">Layouts</span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="graph_flot.html">Flot Charts</a></li>
                        <li><a href="graph_morris.html">Morris.js Charts</a></li>
                        <li><a href="graph_rickshaw.html">Rickshaw Charts</a></li>
                        <li><a href="graph_chartjs.html">Chart.js</a></li>
                        <li><a href="graph_chartist.html">Chartist</a></li>
                        <li><a href="c3.html">c3 charts</a></li>
                        <li><a href="graph_peity.html">Peity Charts</a></li>
                        <li><a href="graph_sparkline.html">Sparkline Charts</a></li>
                    </ul>
                </li>
                <li>
                    <a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">邮件 </span><span class="label label-warning float-right">16/24</span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="mailbox.html">收件箱</a></li>
                        <li><a href="mail_detail.html">邮件内容</a></li>
                        <li><a href="mail_compose.html">撰写邮件</a></li>
                        <li><a href="email_template.html">邮件模板</a></li>
                    </ul>
                </li>
                <li>
                    <a href="metrics.html"><i class="fa fa-pie-chart"></i> <span class="nav-label">指标</span>  </a>
                </li>
                <li>
                    <a href="widgets.html"><i class="fa fa-flask"></i> <span class="nav-label">窗口小部件</span></a>
                </li>
                <li class="active">
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li class="active"><a href="form_basic.html">基本表单</a></li>
                        <li><a href="form_advanced.html">高级表单</a></li>
                        <li><a href="form_wizard.html">表单向导</a></li>
                        <li><a href="form_file_upload.html">文件上传</a></li>
                        <li><a href="form_editors.html">编辑器</a></li>
                        <li><a href="form_autocomplete.html">搜索自动补全</a></li>
                        <li><a href="form_markdown.html">Markdown编辑器</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">应用</span>  <span class="float-right label label-primary">特别</span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="contacts.html">名片</a></li>
                        <li><a href="profile.html">会员</a></li>
                        <li><a href="profile_2.html">会员 v.2</a></li>
                        <li><a href="contacts_2.html">联系人 v.2</a></li>
                        <li><a href="projects.html">项目</a></li>
                        <li><a href="project_detail.html">项目详情</a></li>
                        <li><a href="activity_stream.html">活动</a></li>
                        <li><a href="teams_board.html">团队</a></li>
                        <li><a href="social_feed.html">社交</a></li>
                        <li><a href="clients.html">客户端</a></li>
                        <li><a href="full_height.html">Outlook 视图</a></li>
                        <li><a href="vote_list.html">投票</a></li>
                        <li><a href="file_manager.html">文件管理器</a></li>
                        <li><a href="calendar.html">日历</a></li>
                        <li><a href="issue_tracker.html">问题</a></li>
                        <li><a href="blog.html">博客</a></li>
                        <li><a href="article.html">文章</a></li>
                        <li><a href="faq.html">帮助</a></li>
                        <li><a href="timeline.html">时间线</a></li>
                        <li><a href="pin_board.html">便签</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-files-o"></i> <span class="nav-label">页面</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="search_results.html">搜索</a></li>
                        <li><a href="lockscreen.html">锁屏</a></li>
                        <li><a href="invoice.html">发票</a></li>
                        <li><a href="login.html">登录</a></li>
                        <li><a href="login_two_columns.html">登录 v.2</a></li>
                        <li><a href="forgot_password.html">忘记密码</a></li>
                        <li><a href="register.html">注册</a></li>
                        <li><a href="404.html">404 页面</a></li>
                        <li><a href="500.html">500 页面</a></li>
                        <li><a href="empty_page.html">空白页</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-globe"></i> <span class="nav-label">组件</span><span class="label label-info float-right">新</span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="toastr_notifications.html">toastr 通知</a></li>
                        <li><a href="nestable_list.html">拖动排序</a></li>
                        <li><a href="agile_board.html">Agile board</a></li>
                        <li><a href="timeline_2.html">时间轴 v.2</a></li>
                        <li><a href="diff.html">Diff</a></li>
                        <li><a href="pdf_viewer.html">PDF 查看器</a></li>
                        <li><a href="i18support.html">i18 support</a></li>
                        <li><a href="sweetalert.html">弹层组件</a></li>
                        <li><a href="idle_timer.html">空闲计时器</a></li>
                        <li><a href="truncate.html">截断字符串</a></li>
                        <li><a href="password_meter.html">密码</a></li>
                        <li><a href="spinners.html">加载动画</a></li>
                        <li><a href="spinners_usage.html">Spinners usage</a></li>
                        <li><a href="tinycon.html">Live favicon</a></li>
                        <li><a href="google_maps.html">谷歌地图</a></li>
                        <li><a href="datamaps.html">数据地图</a></li>
                        <li><a href="social_buttons.html">社交按钮</a></li>
                        <li><a href="code_editor.html">代码编辑器</a></li>
                        <li><a href="modal_window.html">模态窗口</a></li>
                        <li><a href="clipboard.html">文本剪贴板</a></li>
                        <li><a href="text_spinners.html">Text spinners</a></li>
                        <li><a href="forum_main.html">论坛</a></li>
                        <li><a href="validation.html">验证</a></li>
                        <li><a href="tree_view.html">树形菜单</a></li>
                        <li><a href="loading_buttons.html">加载按钮</a></li>
                        <li><a href="chat_view.html">聊天视窗</a></li>
                        <li><a href="masonry.html">瀑布流布局</a></li>
                        <li><a href="tour.html">新手指引</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">UI 元素</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="typography.html">排版</a></li>
                        <li><a href="icons.html">图标</a></li>
                        <li><a href="draggable_panels.html">拖动排序</a></li> <li><a href="resizeable_panels.html">内容缩放</a></li>
                        <li><a href="buttons.html">按钮</a></li>
                        <li><a href="video.html">视频</a></li>
                        <li><a href="tabs_panels.html">面板</a></li>
                        <li><a href="tabs.html">标签</a></li>
                        <li><a href="notifications.html">通知 & 工具</a></li>
                        <li><a href="helper_classes.html">css 辅助</a></li>
                        <li><a href="badges_labels.html">徽章 & 标签 & 进度条</a></li>
                    </ul>
                </li>

                <li>
                    <a href="grid_options.html"><i class="fa fa-laptop"></i> <span class="nav-label">栅格</span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">表格</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="table_basic.html">静态表格</a></li>
                        <li><a href="table_data_tables.html">数据表格</a></li>
                        <li><a href="table_foo_table.html">Foo 表格</a></li>
                        <li><a href="jq_grid.html">jqGrid</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-shopping-cart"></i> <span class="nav-label">商城</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="ecommerce_products_grid.html">产品图表</a></li>
                        <li><a href="ecommerce_product_list.html">产品列表</a></li>
                        <li><a href="ecommerce_product.html">产品编辑</a></li>
                        <li><a href="ecommerce_product_detail.html">产品详情</a></li>
                        <li><a href="ecommerce-cart.html">购物车</a></li>
                        <li><a href="ecommerce-orders.html">订购页</a></li>
                        <li><a href="ecommerce_payments.html">支付页</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">相册</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="basic_gallery.html">基本图库</a></li>
                        <li><a href="slick_carousel.html">图片切换</a></li>
                        <li><a href="carousel.html">Bootstrap 相册</a></li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">菜单 </span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li>
                            <a href="#">三级菜单 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="#">三级菜单</a>
                                </li>
                                <li>
                                    <a href="#">三级菜单</a>
                                </li>
                                <li>
                                    <a href="#">三级菜单</a>
                                </li>

                            </ul>
                        </li>
                        <li><a href="#">二级菜单</a></li>
                        <li>
                            <a href="#">二级菜单</a></li>
                        <li>
                            <a href="#">二级菜单</a></li>
                    </ul>
                </li>
                <li>
                    <a href="css_animation.html"><i class="fa fa-magic"></i> <span class="nav-label">CSS 动画 </span><span class="label label-info float-right">62</span></a>
                </li>
                <li class="landing_link">
                    <a target="_blank" href="landing.html"><i class="fa fa-star"></i> <span class="nav-label">着陆页</span> <span class="label label-warning float-right">新</span></a>
                </li>
                <li class="special_link">
                    <a href="package.html"><i class="fa fa-database"></i> <span class="nav-label">组件</span></a>
                </li>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入搜索内容" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">欢迎来到xxx管理后台</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="float-right">46 小时前</small>
                                        <strong>小明</strong> 评论了 <strong>小红</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="float-right text-navy">5 小时前</small>
                                        <strong>小红</strong> 打电话给了 <strong>小黑</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/profile.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="float-right">23 小时前</small>
                                        <strong>小黑</strong> 点赞了 <strong>小红</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html" class="dropdown-item">
                                        <i class="fa fa-envelope"></i> <strong>阅读所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 你有16条消息
                                        <span class="float-right text-muted small">4 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a href="profile.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 个新的关注者
                                        <span class="float-right text-muted small">12 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a href="grid_options.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> 重启服务器
                                        <span class="float-right text-muted small">4 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html" class="dropdown-item">
                                        <strong>查看所有信息</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> 注销
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>添加企业人员</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="showenterpriseuser.action">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理企业人员</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>添加企业人员</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>表格填写 <small>按照实际情况填写表格</small></h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#" class="dropdown-item">选项 1</a>
                                    </li>
                                    <li><a href="#" class="dropdown-item">选项 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <form action="addconsumer.action">
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">姓名</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" name="consumer.name"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">身份证号</label>
                                    <div class="col-sm-10"><input type="text" class="form-control"  name="consumer.idCardNumber"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-2 col-form-label">密码</label>
                                    <div class="col-sm-10"><input name="consumer.password" type="text" class="form-control"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">邮箱地址</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" name="consumer.email"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">手机号</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" name="consumer.phoneNumber"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-2 col-form-label">部门编号</label>

                                    <div class="col-sm-10"><select class="form-control m-b"  name="consumer.enterpriseDepartmentNumber">
                                        <option value="2">行政部</option>
                                        <option value="3">财务部</option>
                                        <option value="4">质量管理部</option>
                                        <option value="5">营销部</option>
                                        <option value="6">技术部</option>
                                        <option value="7">维修部</option>
                                        <option value="8">人力资源部</option>
                                        <option value="9">客户服务部</option>
                                    </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-white btn-sm" type="submit">取消</button>
                                        <button class="btn btn-primary btn-sm" type="submit">保存更改</button>
                                    </div>
                                </div>
                            </form>
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
</div>


<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>

</html>

