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
    <link rel="stylesheet" type="text/css" href="${path }/apps_res/xd24zfz/js/datepicker/css/bootstrap-datepicker.css">
<script src="${path }/apps_res/xd24zfz/js/bootstrap.js"></script>
<script src="${path }/apps_res/xd24zfz/js/bootstrap-datepicker.js"></script>
<script src="${path }/apps_res/xd24zfz/js/datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<script src="${path }/apps_res/xd24zfz/js/target.js"></script>
<script src="${path }/apps_res/xd24zfz/js/formatDate.js"></script>
</head>
<body>
	<div class="goal-layout">
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
							<input class="datepicker" id="bzsj" placeholder="编制时间">
						</div>
						<label class="col-md-1 form-label">生效时间</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="生效时间"
								readonly="readonly">
						</div>
						<label class="col-md-1 form-label">单位</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="单位"
								value="${user.accountName }" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="row form-row">
					<div class="form-group">
						<label class="col-md-1 form-label">中心</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="中心"
								value="${user.centerName }" readonly="readonly">
						</div>
						<label class="col-md-1 form-label">部门</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="部门"
								value="${user.departMentName }" readonly="readonly">
						</div>
						<label class="col-md-1 form-label">组</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="组"
								value="${user.groupName }" readonly="readonly">
						</div>
						<label class="col-md-1 form-label">岗位</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="岗位" value="${user.postName }" readonly="readonly">
							<input type="hidden" value="${user.postId }" id="postId">
						</div>
					</div>
				</div>
				<div class="row form-row">
					<div class="form-group">

						<label class="col-md-1 form-label">责任人</label>
						<div class="col-md-2">
							<input class="form-control" placeholder="责任人"
								value="${user.name }" readonly="readonly"> <input
								type="hidden" id="memberId" value="${user.id }">
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
				<div class="goal-origin-super" id="pid">
					<div class="goal-origin-super-header">上级目标信息</div>
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
					<div class="goal-origin-super-header">目标承接</div>
					<div class="goal-origin-super-content container-fluid">
						<div class="row form-row">
							<div class="form-group">
								<label class="col-md-1 form-label">目标编号</label>
								<div class="col-md-2">
									<input class="form-control" placeholder="目标编号" id="targetCode">
								</div>
								<label class="col-md-1 form-label">战略地图维度</label>
								<div class="col-md-8 common_selectbox_wrap">
									<select id="dimensionId" name=""dimensionId"" class="codecfg"
										codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.DimensionCategoryEnum'">
										<option value="">${ctp:i18n('level.select.choose')}</option>
									</select>
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
									<input type="radio" name="targetAttr" id="bcmc" value="0">补充目标
									<input type="radio" name="targetAttr" id="cjmc" value="1">承接目标
									<div id="jtmc_div">
										<input type="radio" name="targetAttr" id="jtmc" value="2">集团目标(首目标)
									</div>
								</div>
							</div>
						</div>
						<div class="row form-row">
							<div class="form-group">
								<label class="col-md-1 form-label">目标开始时间</label>
								<div class="col-md-2">
									<input class="comp"
										comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
										id="startDate" placeholder="目标开始时间">
								</div>
								<label class="col-md-1 form-label">到</label>
								<div class="col-md-2">
									<input class="comp"
										comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
										id="endDate" placeholder="目标结束时间">
								</div>
								<label class="col-md-1 form-label">是否关键目标</label>
								<div class="col-md-5">
									<input type="radio" name="isCore" id="isCore_yes" value="0">是
									<input type="radio" name="isCore" id="isCore_no" value="1">否
								</div>
							</div>
						</div>
						<div class="row form-row">
							<div class="form-group">
								<label class="col-md-1 form-label">描述</label>
								<div class="col-md-11">
									<textarea class="form-control" placeholder="描述" id="description"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="goal-assessment">
					<div class="goal-assessment-header">+ 目标考核项</div>
					<div class="goal-assessment-body">
						<div class="goal-assessment-item">
							<div class="goal-assessment-item-header">考核指标项</div>
							<div class="goal-assessment-item-body">
								<table class="table table-bordered table-assessment text-center">
									<thead>
										<tr>
											<th class="text-center">序号</th>
											<th class="text-center">目标周期</th>
											<th class="text-center">目标周期细项</th>
											<th class="text-center">月</th>
											<th class="text-center">开始日期</th>
											<th class="text-center">结束日期</th>
											<th class="text-center">指标项</th>
											<th class="text-center">度量</th>
											<th class="text-center">要求</th>
											<th class="text-center">目标值</th>
											<th class="text-center">协同负责人</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input class="form-control" placeholder="序号"></td>
											<td><input class="form-control" placeholder="目标周期" id="khzb_mbzq"></td>
											<td><input class="form-control" placeholder="目标周期细项" id="khzb_mbzqxx"></td>
											<td>
												<div class="common_selectbox_wrap">
													<select id="khzb_monthId" name="khzb_monthId"
														class="codecfg"
														codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.MonthCategoryEnum'">
														<option value="">${ctp:i18n('level.select.choose')}</option>
													</select>
												</div>
											</td>
											<td>
												<input class="comp"
													comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
													id="khzb_startDate" placeholder="开始时间">
											</td>
											<td>
												<input class="comp"
													comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
													id="khzb_endDate" placeholder="结束时间">
											</td>
											<td>
												<input class="form-control" placeholder="指标项" id="khzb_zbx">
												<span class="ico16 relate_file_16"></span>
											</td>
											<td>
												<input class="form-control" placeholder="度量" id="khzb_dl">
											</td>
											<td>
												<div class="common_selectbox_wrap">
													<select id="khzb_claimId" name="khzb_claimId"
														class="codecfg"
														codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.ClaimCategoryEnum'">
														<option value="">${ctp:i18n('level.select.choose')}</option>
													</select>
												</div>
											</td>
											<td><input class="form-control" placeholder="目标值"></td>
											<td><input id="khzb_userName" name="khzb_userName"
												class="comp form-control"
												comp="type:'selectPeople',mode:'open',panels:'Department,Team,Post,Level',selectType:'Member',maxSize:10" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="goal-assessment-item-footer">
								<button class="btn btn-link">+ 添加</button>
							</div>
						</div>
						<div class="goal-assessment-item">
							<div class="goal-assessment-item-header">考核目标项</div>
							<div class="goal-assessment-item-body">
								<table class="table table-bordered table-assessment text-center">
									<thead>
										<tr>
											<th class="text-center">序号</th>
											<th class="text-center">目标周期</th>
											<th class="text-center">目标周期细项</th>
											<th class="text-center">月</th>
											<th class="text-center">开始日期</th>
											<th class="text-center">结束日期</th>
											<th class="text-center">工作目标完成标准</th>
											<th class="text-center">协同负责人</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input class="form-control" placeholder="序号"></td>
											<td><input class="form-control" placeholder="目标周期" id="khmb_mbzq"></td>
											<td><input class="form-control" placeholder="目标周期细项" id="khmb_mbzqxx"></td>
											<td>
												<div class="common_selectbox_wrap">
													<select id="khmb_monthId" name="khmb_monthId"
														class="codecfg"
														codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.MonthCategoryEnum'">
														<option value="">${ctp:i18n('level.select.choose')}</option>
													</select>
												</div>
											</td>
											<td>
												<input class="comp"
														comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
														id="khmb_startDate" placeholder="目标开始时间">
											</td>
											<td>
												<input class="comp"
														comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
														id="khmb_startDate" placeholder="目标结束时间">
											</td>
											<td><input class="form-control" placeholder="完成标准" id="khmb_wcbz"></td>
											<td><input id="khmb_userName" name="khmb_userName"
												class="comp form-control"
												comp="type:'selectPeople',mode:'open',panels:'Department,Team,Post,Level',selectType:'Member',maxSize:10" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="goal-assessment-item-footer">
								<button class="btn btn-link">+ 添加</button>
							</div>
						</div>
						<div class="goal-assessment-item">
							<div class="goal-assessment-item-header">考察指标项</div>
							<div class="goal-assessment-item-body">
								<table class="table table-bordered table-assessment text-center">
									<thead>
										<tr>
											<th class="text-center">序号</th>
											<th class="text-center">目标周期</th>
											<th class="text-center">目标周期细项</th>
											<th class="text-center">月</th>
											<th class="text-center">开始日期</th>
											<th class="text-center">结束日期</th>
											<th class="text-center">指标项</th>
											<th class="text-center">度量</th>
											<th class="text-center">要求</th>
											<th class="text-center">目标值</th>
											<th class="text-center">协同负责人</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input class="form-control" placeholder="序号"></td>
											<td><input class="form-control" placeholder="周期" id="kczb_zbzq"></td>
											<td><input class="form-control" placeholder="周期细项" id="kczb_zbzqxx"></td>
											<td>
												<div class="common_selectbox_wrap">
													<select id="kczb_monthId" name="kczb_monthId"
														class="codecfg"
														codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.MonthCategoryEnum'">
														<option value="">${ctp:i18n('level.select.choose')}</option>
													</select>
												</div>
											</td>
											<td>
												<input class="comp"
														comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
														id="kczb_startDate" placeholder="开始时间">
											</td>
											<td>
												<input class="comp"
														comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
														id="kczb_startDate" placeholder="结束时间">
											</td>
											<td>
												<input class="form-control" placeholder="指标项" id="kczb_zbx">
												<span class="ico16 relate_file_16"></span>
											</td>
											<td>
												<input class="form-control" placeholder="度量" id="kczb_zbx">
											</td>
											<td>
												<div class="common_selectbox_wrap">
													<select id="kczb_claimId" name="kczb_claimId"
														class="codecfg"
														codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.ClaimCategoryEnum'">
														<option value="">${ctp:i18n('level.select.choose')}</option>
													</select>
												</div>
											</td>
											<td>
												<input class="form-control" placeholder="目标值" id="kczb_mbz">
											</td>
											<td><input id="kczb_memberId" name="kczb_userName"
												class="comp form-control"
												comp="type:'selectPeople',mode:'open',panels:'Department,Team,Post,Level',selectType:'Member',maxSize:10" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="goal-assessment-item-footer">
								<button class="btn btn-link">+ 添加</button>
							</div>
						</div>
						<div class="goal-assessment-item">
							<div class="goal-assessment-item-header">考察目标项</div>
							<div class="goal-assessment-item-body">
								<table class="table table-bordered table-assessment text-center">
									<thead>
										<tr>
											<th class="text-center">序号</th>
											<th class="text-center">目标周期</th>
											<th class="text-center">目标周期细项</th>
											<th class="text-center">月</th>
											<th class="text-center">开始日期</th>
											<th class="text-center">结束日期</th>
											<th class="text-center">工作目标完成标准</th>
											<th class="text-center">协同负责人</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input class="form-control" placeholder="序号"></td>
											<td><input class="form-control" placeholder="目标周期" id="kcmb_mbzq"></td>
											<td><input class="form-control" placeholder="周期细项" id="kcmb_mbzqxx"></td>
											<td>
												<div class="common_selectbox_wrap">
													<select id="kcmb_monthId" name="kczb_monthId"
														class="codecfg"
														codecfg="codeType:'java',codeId:'com.seeyon.apps.xd.constants.MonthCategoryEnum'">
														<option value="">${ctp:i18n('level.select.choose')}</option>
													</select>
												</div>
											</td>
											<td>
												<input class="comp"
														comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
														id="kcmb_startDate" placeholder="开始时间">
											</td>
											<td>
												<input class="comp"
														comp="type:'calendar',ifFormat:'%Y-%m-%d %H:%M',showsTime:true,cache:false"
														id="kcmb_endDate" placeholder="结束时间">
											</td>
											<td><input class="form-control" placeholder="工作目标完成标准" id="kcmb_gzmuwcbz"></td>
											<td><input id="kczb_memberId" name="kczb_userName"
												class="comp form-control"
												comp="type:'selectPeople',mode:'open',panels:'Department,Team,Post,Level',selectType:'Member',maxSize:10" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="goal-assessment-item-footer">
								<button class="btn btn-link">+ 添加</button>
							</div>
						</div>
						<div class="goal-assessment-item">
							<div class="goal-assessment-item-header">目标向下分解</div>
							<div class="goal-assessment-item-body">
								<table class="table table-bordered table-assessment text-center">
									<thead>
										<tr>
											<th class="text-center">序号</th>
											<th class="text-center">目标描述</th>
											<th class="text-center">承接人</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input class="form-control"></td>
											<td><textarea class="form-control" placeholder="描述" id="fj_description"></textarea>
											</td>
											<td><input id="mbfj_MemberId" name="mbfj_userName"
												placeholder="承接人" class="comp form-control"
												comp="type:'selectPeople',mode:'open',panels:'Department,Team,Post,Level',selectType:'Member',maxSize:1" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="goal-assessment-item-footer">
								<button class="btn btn-link">+ 添加</button>
							</div>
						</div>


						<br /> <br />

					</div>
				</div>

			</div>
		</form>
	</div>
</body>
</html>