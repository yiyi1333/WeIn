<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 电子商务产品编辑</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/summernote/summernote-bs4.css" rel="stylesheet">

    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">



</head>

<body>

<div id="wrapper">

    <jsp:include page="navigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="topSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>电子商务产品编辑</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.html">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>电子商务</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>产品编辑</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">

            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">
                            <ul class="nav nav-tabs">
                                <li><a class="nav-link active" data-toggle="tab" href="#tab-1"> 产品编辑</a></li>
<%--                                <li><a class="nav-link" data-toggle="tab" href="#tab-2"> 产品数据</a></li>--%>
<%--                                <li><a class="nav-link" data-toggle="tab" href="#tab-3"> 产品折扣</a></li>--%>
<%--                                <li><a class="nav-link" data-toggle="tab" href="#tab-4"> 产品图片</a></li>--%>
                            </ul>
                            <div class="tab-content">
                                <div id="tab-1" class="tab-pane active">
                                    <div class="panel-body">

                                        <fieldset>
                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品名称:</label>
                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="商品名称"></div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品价格:</label>
                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="$160.00"></div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品描述:</label>
                                                <div class="col-sm-10">
                                                    <div class="summernote">
                                                        <h3>乐高玩具2017</h3>
                                                        乐高拼砌玩具曾经伴随无数多孩子的成长，在孩子和家长的心目中，乐高代表的是快乐，是无限的想象，是创意的未来。
                                                        <br/>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-2 col-form-label">标签标题:</label>
                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="..."></div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-2 col-form-label">标题说明:</label>
                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="无限的想象，是创意的未来"></div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-2 col-form-label">标题关键字:</label>
                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="乐高, 高达"></div>
                                            </div>
                                        </fieldset>

                                    </div>
                                </div>
<%--                                <div id="tab-2" class="tab-pane">--%>
<%--                                    <div class="panel-body">--%>

<%--                                        <fieldset>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品编码:</label>--%>
<%--                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="543"></div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品型号:</label>--%>
<%--                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="..."></div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品定位:</label>--%>
<%--                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="location"></div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品税收:</label>--%>
<%--                                                <div class="col-sm-10">--%>
<%--                                                    <select class="form-control" >--%>
<%--                                                        <option>选项 1</option>--%>
<%--                                                        <option>选项 2</option>--%>
<%--                                                    </select>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品数量:</label>--%>
<%--                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="产品数量"></div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">最小数量:</label>--%>
<%--                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="2"></div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品排序:</label>--%>
<%--                                                <div class="col-sm-10"><input type="text" class="form-control" placeholder="0"></div>--%>
<%--                                            </div>--%>
<%--                                            <div class="form-group row"><label class="col-sm-2 col-form-label">产品状态:</label>--%>
<%--                                                <div class="col-sm-10">--%>
<%--                                                    <select class="form-control" >--%>
<%--                                                        <option>选项 1</option>--%>
<%--                                                        <option>选项 2</option>--%>
<%--                                                    </select>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </fieldset>--%>


<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div id="tab-3" class="tab-pane">--%>
<%--                                    <div class="panel-body">--%>

<%--                                        <div class="table-responsive">--%>
<%--                                            <table class="table table-stripped table-bordered">--%>

<%--                                                <thead>--%>
<%--                                                <tr>--%>
<%--                                                    <th>--%>
<%--                                                        组--%>
<%--                                                    </th>--%>
<%--                                                    <th>--%>
<%--                                                        数量--%>
<%--                                                    </th>--%>
<%--                                                    <th>--%>
<%--                                                        折扣--%>
<%--                                                    </th>--%>
<%--                                                    <th style="width: 20%">--%>
<%--                                                        日期开始--%>
<%--                                                    </th>--%>
<%--                                                    <th style="width: 20%">--%>
<%--                                                        日期结束--%>
<%--                                                    </th>--%>
<%--                                                    <th>--%>
<%--                                                        操作--%>
<%--                                                    </th>--%>
<%--                                                </tr>--%>
<%--                                                </thead>--%>
<%--                                                <tbody>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                            <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <select class="form-control" >--%>
<%--                                                            <option selected>产品组 1</option>--%>
<%--                                                            <option>产品组 2</option>--%>
<%--                                                            <option>产品组 3</option>--%>
<%--                                                            <option>产品组 4</option>--%>
<%--                                                        </select>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="10">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" placeholder="$10.00">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <div class="input-group date">--%>
<%--                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="07/01/2014">--%>
<%--                                                        </div>--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>

<%--                                                </tbody>--%>

<%--                                            </table>--%>
<%--                                        </div>--%>

<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <div id="tab-4" class="tab-pane">--%>
<%--                                    <div class="panel-body">--%>

<%--                                        <div class="table-responsive">--%>
<%--                                            <table class="table table-bordered table-stripped">--%>
<%--                                                <thead>--%>
<%--                                                <tr>--%>
<%--                                                    <th>--%>
<%--                                                        图像预览--%>
<%--                                                    </th>--%>
<%--                                                    <th>--%>
<%--                                                        图片网址--%>
<%--                                                    </th>--%>
<%--                                                    <th>--%>
<%--                                                        排序--%>
<%--                                                    </th>--%>
<%--                                                    <th>--%>
<%--                                                        操作--%>
<%--                                                    </th>--%>
<%--                                                </tr>--%>
<%--                                                </thead>--%>
<%--                                                <tbody>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/2s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image1.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="1">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/1s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image2.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="2">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/3s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image3.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="3">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/4s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image4.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="4">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/5s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image5.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="5">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/6s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image6.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="6">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                <tr>--%>
<%--                                                    <td>--%>
<%--                                                        <img src="img/gallery/7s.jpg">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" disabled value="http://mydomain.com/images/image7.png">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <input type="text" class="form-control" value="7">--%>
<%--                                                    </td>--%>
<%--                                                    <td>--%>
<%--                                                        <button class="btn btn-white"><i class="fa fa-trash"></i> </button>--%>
<%--                                                    </td>--%>
<%--                                                </tr>--%>
<%--                                                </tbody>--%>
<%--                                            </table>--%>
<%--                                        </div>--%>

<%--                                    </div>--%>
<%--                                </div>--%>
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

<!-- SUMMERNOTE -->
<script src="js/plugins/summernote/summernote-bs4.js"></script>

<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

<script>
    $(document).ready(function(){

        $('.summernote').summernote();

        $('.input-group.date').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true
        });

    });
</script>

</body>

</html>

