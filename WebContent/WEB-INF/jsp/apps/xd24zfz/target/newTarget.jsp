<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>录入</title>
    <link rel="stylesheet" type="text/css" href="${path }/apps_res/xd24zfz/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${path }/apps_res/xd24zfz/css/css.css">
    <script src="${path }/apps_res/xd24zfz/js/jquery.js"></script>
    <script src="${path }/apps_res/xd24zfz/js/target.js"></script>
    <script src="${path }/apps_res/xd24zfz/js/formatDate.js"></script>
</head>
<body>
<div class="goal-layout">
    <div class="goal-header text-center">
                    目标录入
    </div>
    <form class="">
        <div class="goal-origin container-fluid">
            <div class="row form-row">
                <div class="form-group">
                    <label class="col-md-1 form-label">年度</label>
                    <div class="col-md-2">
                        <input class="form-control" id="year" placeholder="年度">
                    </div>
                    <label class="col-md-1 form-label">编制时间</label>
                    <div class="col-md-2">
                        <input class="form-control" id="bzsj" placeholder="编制时间">
                    </div>
                    <label class="col-md-1 form-label">生效时间</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="生效时间" readonly="readonly">
                    </div>
                    <label class="col-md-1 form-label">单位</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="单位" value="${user.accountName }" readonly="readonly">
                    </div>
                   
                </div>
            </div>
            <div class="row form-row">
                <div class="form-group">
                   
                    <label class="col-md-1 form-label">中心</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="中心" value="${user.centerName }" readonly="readonly">
                    </div>
                    <label class="col-md-1 form-label">部门</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="部门" value="${user.departMentName }" readonly="readonly">
                    </div>
                    <label class="col-md-1 form-label">组</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="组" value="${user.groupName }" readonly="readonly">
                    </div>
                    <label class="col-md-1 form-label">岗位</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="岗位" value="${user.postName }" readonly="readonly">
                    </div>
                </div>
            </div>
            <div class="row form-row">
                <div class="form-group">
                    
                     <label class="col-md-1 form-label">责任人</label>
                    <div class="col-md-2">
                        <input class="form-control" placeholder="责任人" value="${user.name }" readonly="readonly">
                        <input type="hidden" id="memberId" value="${user.id }" >
                    </div>
                    <label class="col-md-1 form-label">编号</label>
                    <div class="col-md-2">
                        <input class="form-control" id="code" placeholder="编号">
                    </div>
                    <label class="col-md-1 form-label">文件号</label>
                    <div class="col-md-2">
                        <input class="form-control" id="fileCode" placeholder="文件号">
                    </div>
                    
                </div>
            </div>
        </div>

        <div class="goal-content">
            <div class="goal-origin-super">
                <div class="goal-origin-super-header">
                    上级目标信息
                </div>
                <div class="goal-origin-super-content container-fluid">
                    <div class="row form-row">
                        <div class="form-group">
                            <label class="col-md-1 form-label">上级目标编号</label>
                            <div class="col-md-2">
                                <input class="form-control" placeholder="上级目标编号" id="pTargetCode">
                            </div>
                            <label class="col-md-1 form-label">上级目标维度</label>
                            <div class="col-md-2">
                                <input class="form-control" placeholder="上级目标维度">
                            </div>
                            <label class="col-md-1 form-label">上级目标名称</label>
                            <div class="col-md-5">
                                <input class="form-control" placeholder="上级目标名称">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="goal-origin-super">
                <div class="goal-origin-super-header">
                    目标承接
                </div>
                <div class="goal-origin-super-content container-fluid">
                    <div class="row form-row">
                        <div class="form-group">
                            <label class="col-md-1 form-label">目标编号</label>
                            <div class="col-md-2">
                                <input class="form-control" placeholder="目标编号" id="targetCode">
                            </div>
                            <label class="col-md-1 form-label">战略地图维度</label>
                            <div class="col-md-8">
                                <input class="form-control" placeholder="战略地图维度" id="dimension">
                            </div>
                        </div>
                    </div>
                    <div class="row form-row">
                        <div class="form-group">
                            <label class="col-md-1 form-label">目标名称</label>
                            <div class="col-md-5">
                                <input class="form-control" placeholder="目标名称" id="targetName">
                            </div>
                            <label class="col-md-1 form-label">目标来源</label>
                            <div class="col-md-5">
                                <input class="form-control" placeholder="目标来源">
                            </div>
                        </div>
                    </div>
                    <div class="row form-row">
                        <div class="form-group">
                            <label class="col-md-1 form-label">目标开始时间</label>
                            <div class="col-md-2">
                                <input class="form-control" placeholder="目标开始时间">
                            </div>
                            <label class="col-md-1 form-label">到</label>
                            <div class="col-md-2">
                                <input class="form-control" placeholder="目标结束时间">
                            </div>
                            <label class="col-md-1 form-label">是否关键目标</label>
                            <div class="col-md-5">
                                <input class="form-control" placeholder="是否关键目标">
                            </div>
                        </div>
                    </div>
                    <div class="row form-row">
                        <div class="form-group">
                            <label class="col-md-1 form-label">描述</label>
                            <div class="col-md-11">
                                <textarea class="form-control" placeholder="描述"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="goal-assessment">
                <div class="goal-assessment-header">
                    + 目标考核项
                </div>
                <div class="goal-assessment-body">
                    <div class="goal-assessment-item">
                        <div class="goal-assessment-item-header">
                            考核指标项
                        </div>
                        <div class="goal-assessment-item-body">
                            <table class="table table-bordered table-assessment text-center">
                            <thead>
                            <tr>
                                <th class="text-center">
                                    序号
                                </th>
                                <th class="text-center">
                                    目标周期
                                </th>
                                <th class="text-center">
                                    目标周期细项
                                </th>
                                <th class="text-center">
                                    月
                                </th>
                                <th class="text-center">
                                    开始日期
                                </th>
                                <th class="text-center">
                                    结束日期
                                </th>
                                <th class="text-center">
                                    指标项
                                </th>
                                <th class="text-center">
                                    度量
                                </th>
                                <th class="text-center">
                                    要求
                                </th>
                                <th class="text-center">
                                    目标直
                                </th>
                                <th class="text-center">
                                    协同负责人
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                        </div>
                        <div class="goal-assessment-item-footer">
                           <button class="btn btn-link"> + 添加</button>
                        </div>
                    </div>



                    <div class="goal-assessment-item">
                        <div class="goal-assessment-item-header">
                            考核目标项
                        </div>
                        <div class="goal-assessment-item-body">
                            <table class="table table-bordered table-assessment text-center">
                                <thead>
                                <tr>
                                    <th class="text-center">
                                        序号
                                    </th>
                                    <th class="text-center">
                                        目标周期
                                    </th>
                                    <th class="text-center">
                                        目标周期细项
                                    </th>
                                    <th class="text-center">
                                        月
                                    </th>
                                    <th class="text-center">
                                        开始日期
                                    </th>
                                    <th class="text-center">
                                        结束日期
                                    </th>
                                    <th class="text-center">
                                        工作目标完成标准
                                    </th>
                                    <th class="text-center">
                                        协同负责人
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="goal-assessment-item-footer">
                            <button class="btn btn-link"> + 添加</button>
                        </div>
                    </div>





                    <div class="goal-assessment-item">
                        <div class="goal-assessment-item-header">
                            考察指标项
                        </div>
                        <div class="goal-assessment-item-body">
                            <table class="table table-bordered table-assessment text-center">
                                <thead>
                                <tr>
                                    <th class="text-center">
                                        序号
                                    </th>
                                    <th class="text-center">
                                        目标周期
                                    </th>
                                    <th class="text-center">
                                        目标周期细项
                                    </th>
                                    <th class="text-center">
                                        月
                                    </th>
                                    <th class="text-center">
                                        开始日期
                                    </th>
                                    <th class="text-center">
                                        结束日期
                                    </th>
                                    <th class="text-center">
                                        指标项
                                    </th>
                                    <th class="text-center">
                                        度量
                                    </th>
                                    <th class="text-center">
                                        条件
                                    </th>
                                    <th class="text-center">
                                        目标直
                                    </th>
                                    <th class="text-center">
                                        协同负责人
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="goal-assessment-item-footer">
                            <button class="btn btn-link"> + 添加</button>
                        </div>
                    </div>




                    <div class="goal-assessment-item">
                        <div class="goal-assessment-item-header">
                            考察目标项
                        </div>
                        <div class="goal-assessment-item-body">
                            <table class="table table-bordered table-assessment text-center">
                                <thead>
                                <tr>
                                    <th class="text-center">
                                        序号
                                    </th>
                                    <th class="text-center">
                                        目标周期
                                    </th>
                                    <th class="text-center">
                                        目标周期细项
                                    </th>
                                    <th class="text-center">
                                        月
                                    </th>
                                    <th class="text-center">
                                        开始日期
                                    </th>
                                    <th class="text-center">
                                        结束日期
                                    </th>
                                    <th class="text-center">
                                        工作目标完成标准
                                    </th>
                                    <th class="text-center">
                                        协同负责人
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="goal-assessment-item-footer">
                            <button class="btn btn-link"> + 添加</button>
                        </div>
                    </div>



                    <div class="goal-assessment-item">
                        <div class="goal-assessment-item-header">
                            目标向下分解
                        </div>
                        <div class="goal-assessment-item-body">
                            <table class="table table-bordered table-assessment text-center">
                                <thead>
                                <tr>
                                    <th class="text-center">
                                        序号
                                    </th>
                                    <th class="text-center">
                                        目标描述
                                    </th>
                                    <th class="text-center">
                                        承接人
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="goal-assessment-item-footer">
                            <button class="btn btn-link"> + 添加</button>
                        </div>
                    </div>


                    <br/>
                    <br/>

                </div>
            </div>

        </div>
    </form>
    <div class="goal-footer text-center">
        <button class="btn btn-default goal-btn">保存</button>
        <button class="btn btn-primary">提交审批</button>
    </div>
</div>
</body>
</html>