<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn商家后台</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
<div id="wrapper">
    <jsp:include page="shopNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="shopTopSidebar.jsp"/>
        <div class="wrapper wrapper-content animated fadeIn">
            <div class="p-w-md m-t-sm">
                <div class="row">

                    <div class="col-sm-4">
                        <h1 class="m-b-xs">
                            26,900
                        </h1>
                        <small>
                            本月销售
                        </small>
                        <div id="sparkline1" class="m-b-sm"></div>
                        <div class="row">
                            <div class="col-4">
                                <small class="stats-label">访问页面 / 浏览量</small>
                                <h4>236 321.80</h4>
                            </div>

                            <div class="col-4">
                                <small class="stats-label">% 新访问</small>
                                <h4>46.11%</h4>
                            </div>
                            <div class="col-4">
                                <small class="stats-label">上个星期</small>
                                <h4>432.021</h4>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-4">
                        <h1 class="m-b-xs">
                            98,100
                        </h1>
                        <small>
                            过去24小时销售
                        </small>
                        <div id="sparkline2" class="m-b-sm"></div>
                        <div class="row">
                            <div class="col-4">
                                <small class="stats-label">访问页面 / 浏览量</small>
                                <h4>166 781.80</h4>
                            </div>

                            <div class="col-4">
                                <small class="stats-label">% 新访问</small>
                                <h4>22.45%</h4>
                            </div>
                            <div class="col-4">
                                <small class="stats-label">上个星期</small>
                                <h4>862.044</h4>
                            </div>
                        </div>


                    </div>
                    <div class="col-sm-4">

                        <div class="row m-t-xs">
                            <div class="col-6">
                                <h5 class="m-b-xs">上个月收入</h5>
                                <h1 class="no-margins">160,000</h1>
                                <div class="font-bold text-navy">98% <i class="fa fa-bolt"></i></div>
                            </div>
                            <div class="col-6">
                                <h5 class="m-b-xs">今年收入</h5>
                                <h1 class="no-margins">42,120</h1>
                                <div class="font-bold text-navy">98% <i class="fa fa-bolt"></i></div>
                            </div>
                        </div>


                        <table class="table small m-t-sm">
                            <tbody>
                            <tr>
                                <td>
                                    <strong>142</strong> 项目

                                </td>
                                <td>
                                    <strong>22</strong> 消息
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <strong>61</strong> 注释
                                </td>
                                <td>
                                    <strong>54</strong> 用品
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <strong>154</strong> 公司
                                </td>
                                <td>
                                    <strong>32</strong> 客户端
                                </td>
                            </tr>
                            </tbody>
                        </table>



                    </div>

                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="small float-left col-md-3 m-l-lg m-t-md">
                            <strong>销售</strong> 随时可能有变化
                        </div>
                        <div class="small float-right col-md-3 m-t-md text-right">
                            <strong>通知</strong> 我是通知我是通知
                        </div>
                        <div class="flot-chart m-b-xl">
                            <div class="flot-chart-content" id="flot-dashboard5-chart"></div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox">



                            <div class="ibox-content">

                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label" for="product_name">项目名</label>
                                            <input type="text" id="product_name" name="product_name" value="" placeholder="Project Name" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <div class="form-group">
                                            <label class="col-form-label" for="price">名称</label>
                                            <input type="text" id="price" name="price" value="" placeholder="Name" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <div class="form-group">
                                            <label class="col-form-label" for="quantity">公司</label>
                                            <input type="text" id="quantity" name="quantity" value="" placeholder="Company" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="col-form-label" for="status">状态</label>
                                            <select name="status" id="status" class="form-control">
                                                <option value="1" selected="">已完成</option>
                                                <option value="0">待完成</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="table-responsive">
                                    <table class="table table-striped">

                                        <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$892,074</td>
                                            <td>企鹅公司</td>
                                            <td><strong>20%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$963,486</td>
                                            <td>企鹅公司</td>
                                            <td><strong>40%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$996,824</td>
                                            <td>企鹅公司</td>
                                            <td><strong>75%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$105,192</td>
                                            <td>企鹅公司</td>
                                            <td><strong>18%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$674,803</td>
                                            <td>企鹅公司</td>
                                            <td><strong>40%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>6</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$174,729</td>
                                            <td>企鹅公司</td>
                                            <td><strong>20%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>7</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$823,198</td>
                                            <td>企鹅公司</td>
                                            <td><strong>18%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>8</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$778,696</td>
                                            <td>企鹅公司</td>
                                            <td><strong>20%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>9</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$861,063</td>
                                            <td>企鹅公司</td>
                                            <td><strong>40%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>10</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$109,125</td>
                                            <td>企鹅公司</td>
                                            <td><strong>75%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>11</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$600,978</td>
                                            <td>企鹅公司</td>
                                            <td><strong>18%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>12</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$150,161</td>
                                            <td>企鹅公司</td>
                                            <td><strong>40%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>13</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$160,586</td>
                                            <td>企鹅公司</td>
                                            <td><strong>20%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>14</td>
                                            <td>王者农药</td>
                                            <td>天美工作室</td>
                                            <td>$110,612</td>
                                            <td>企鹅公司</td>
                                            <td><strong>18%</strong></td>
                                            <td>2017.12.12</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        </tbody>
                                    </table>
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
<script src="js/plugins/flot/jquery.flot.symbol.js"></script>
<script src="js/plugins/flot/jquery.flot.time.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- Sparkline -->
<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>


<script>
    $(document).ready(function() {

        var sparklineCharts = function(){
            $("#sparkline1").sparkline([34, 43, 43, 35, 44, 32, 44, 52], {
                type: 'line',
                width: '100%',
                height: '50',
                lineColor: '#1ab394',
                fillColor: "transparent"
            });

            $("#sparkline2").sparkline([32, 11, 25, 37, 41, 32, 34, 42], {
                type: 'line',
                width: '100%',
                height: '50',
                lineColor: '#1ab394',
                fillColor: "transparent"
            });

            $("#sparkline3").sparkline([34, 22, 24, 41, 10, 18, 16,8], {
                type: 'line',
                width: '100%',
                height: '50',
                lineColor: '#1C84C6',
                fillColor: "transparent"
            });
        };

        var sparkResize;

        $(window).resize(function(e) {
            clearTimeout(sparkResize);
            sparkResize = setTimeout(sparklineCharts, 500);
        });

        sparklineCharts();




        var data1 = [
            [0,4],[1,8],[2,5],[3,10],[4,4],[5,16],[6,5],[7,11],[8,6],[9,11],[10,20],[11,10],[12,13],[13,4],[14,7],[15,8],[16,12]
        ];
        var data2 = [
            [0,0],[1,2],[2,7],[3,4],[4,11],[5,4],[6,2],[7,5],[8,11],[9,5],[10,4],[11,1],[12,5],[13,2],[14,5],[15,2],[16,0]
        ];
        $("#flot-dashboard5-chart").length && $.plot($("#flot-dashboard5-chart"), [
                data1,  data2
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

                    borderWidth: 2,
                    color: 'transparent'
                },
                colors: ["#1ab394", "#1C84C6"],
                xaxis:{
                },
                yaxis: {
                },
                tooltip: false
            }
        );

    });
</script>
</body>
</html>

