package com.x.attendance.assemble.control.jaxrs.attendancedetail;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonElement;
import com.x.attendance.assemble.control.jaxrs.attendancedetail.exception.ExceptionAttendanceDetailProcess;
import com.x.base.core.project.annotation.JaxrsDescribe;
import com.x.base.core.project.annotation.JaxrsMethodDescribe;
import com.x.base.core.project.annotation.JaxrsParameterDescribe;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.http.HttpMediaType;
import com.x.base.core.project.jaxrs.ResponseFactory;
import com.x.base.core.project.jaxrs.StandardJaxrsAction;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;

@Path("attendancedetail")
@JaxrsDescribe("考勤打卡信息管理服务")
public class AttendanceDetailAction extends StandardJaxrsAction {

	private static  Logger logger = LoggerFactory.getLogger(AttendanceDetailAction.class);

	@JaxrsMethodDescribe( value = "根据ID获取考勤打卡信息", action = ActionGet.class )
	@GET
	@Path("{id}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("移动考勤打卡信息ID") @PathParam("id") String id) {
		ActionResult<ActionGet.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionGet().execute( request, effectivePerson, id );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "根据ID获取信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "获取数据库中指定导入文件名称的数据列表", action = ActionListImportByFileName.class )
	@GET
	@Path("list/{file_id}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listAttendanceDetailByBatchName(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("导入文件信息ID") @PathParam("file_id") String file_id) {
		ActionResult<List<ActionListImportByFileName.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListImportByFileName().execute( request, effectivePerson, file_id );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "获取数据库中指定导入文件名称的数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "获取指定年月的打卡数据列表", action = ActionListWithFilter.class )
	@PUT
	@Path("filter/list")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listAttendanceDetail( @Context HttpServletRequest request, JsonElement jsonElement ) {
		ActionResult<List<ActionListWithFilter.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListWithFilter().execute( request, effectivePerson, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "获取指定年月的打卡数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "获取用户指定年月的打卡数据列表", action = ActionListWithEmployee.class )
	@PUT
	@Path("filter/list/user")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listUserAttendanceDetail(@Context HttpServletRequest request, JsonElement jsonElement) {
		ActionResult<List<ActionListWithEmployee.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListWithEmployee().execute( request, effectivePerson, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "获取员工指定年月的打卡数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "获取顶层组织指定年月的打卡数据列表", action = ActionListWithTopUnit.class )
	@PUT
	@Path("filter/list/topUnit")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listTopUnitAttendanceDetail(@Context HttpServletRequest request, JsonElement jsonElement) {
		ActionResult<List<ActionListWithTopUnit.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListWithTopUnit().execute( request, effectivePerson, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "获取顶层组织指定年月的打卡数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "获取组织指定年月的打卡数据列表", action = ActionListWithUnit.class )
	@PUT
	@Path("filter/list/unit")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listUnitAttendanceDetail(@Context HttpServletRequest request, JsonElement jsonElement) {
		ActionResult<List<ActionListWithUnit.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListWithUnit().execute( request, effectivePerson, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "获取组织指定年月的打卡数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "根据周期的年份月份，以及需要考勤人员的名单，检查人员在周期内每天的考核数据是否存在，如果不存在，则进行补齐", action = ActionCheckWithPersonByCycle.class )
	@GET
	@Path("checkDetailWithPersonByCycle/{cycleYear}/{cycleMonth}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response checkDetailWithPersonByCycle( @Context HttpServletRequest request, 
			@JaxrsParameterDescribe("统计周期年份") @PathParam("cycleYear") String cycleYear, 
			@JaxrsParameterDescribe("统计周期月份") @PathParam("cycleMonth") String cycleMonth ) {
		ActionResult<ActionCheckWithPersonByCycle.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;
		if(check){
			try {
				result = new ActionCheckWithPersonByCycle().execute( request, effectivePerson, cycleYear, cycleMonth );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "根据周期检查打卡信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "分析打卡数据", action = ActionAnalyseAttendanceDetails.class )
	@GET
	@Path("analyse/{startDate}/{endDate}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response analyseAttendanceDetails(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("开始日期") @PathParam("startDate") String startDate, 
			@JaxrsParameterDescribe("结束日期") @PathParam("endDate") String endDate) {
		ActionResult<ActionAnalyseAttendanceDetails.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;
		if(check){
			try {
				result = new ActionAnalyseAttendanceDetails().execute( request, effectivePerson, startDate, endDate );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "根据时间区间分析所有员工打卡信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "分析打卡数据", action = ActionAnalyseAttendanceDetail.class )
	@GET
	@Path("analyse/id/{id}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response analyseAttendanceDetail(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("移动考勤打卡信息ID") @PathParam("id") String id) {
		ActionResult<ActionAnalyseAttendanceDetail.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;
		if(check){
			try {
				result = new ActionAnalyseAttendanceDetail().execute( request, effectivePerson, id );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "根据ID分析打卡信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "将指定的打卡记录归档", action = ActionArchiveAttendanceDetail.class )
	@GET
	@Path("archive/{id}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response archiveAttendanceDetail(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("移动考勤打卡信息ID") @PathParam("id") String id) {
		ActionResult<ActionArchiveAttendanceDetail.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;
		if(check){
			try {
				result = new ActionArchiveAttendanceDetail().execute( request, effectivePerson, id );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "根据ID归档打卡信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "列示符合过滤条件的打卡记录归档", action = ActionListNextWithFilter.class )
	@PUT
	@Path("filter/list/{id}/next/{count}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listNextWithFilter(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("最后一条信息ID") @PathParam("id") String id,
			@JaxrsParameterDescribe("每页显示的条目数量") @PathParam("count") Integer count, 
			JsonElement jsonElement) {
		ActionResult<List<ActionListNextWithFilter.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListNextWithFilter().execute( request, effectivePerson, id, count, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "列示根据过滤条件的打卡数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "列示符合过滤条件的打卡记录归档", action = ActionListPrevWithFilter.class )
	@PUT
	@Path("filter/list/{id}/prev/{count}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listPrevWithFilter(@Context HttpServletRequest request, 
			@JaxrsParameterDescribe("最后一条信息ID") @PathParam("id") String id,
			@JaxrsParameterDescribe("每页显示的条目数量") @PathParam("count") Integer count, 
			JsonElement jsonElement) {
		ActionResult<List<ActionListPrevWithFilter.Wo>> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;

		if(check){
			try {
				result = new ActionListPrevWithFilter().execute( request, effectivePerson, id, count, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "列示根据过滤条件的打卡数据列表时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	/**
	 * 打卡信息接入 1-员工姓名 EmployeeName 2-员工号 EmployeeNo 3-日期 RecordDateString 4-签到时间
	 * OnDutyTime 5-签退时间 OffDutyTime
	 * 
	 * @author liyi_
	 */
	@JaxrsMethodDescribe( value = "接入完成的上下班打卡信息记录，接入完成后直接分析", action = ActionReciveAttendance.class )
	@Path("recive")
	@POST
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recive(@Context HttpServletRequest request, JsonElement jsonElement) {
		ActionResult<ActionReciveAttendance.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;
		if(check){
			try {
				result = new ActionReciveAttendance().execute( request, effectivePerson, jsonElement );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "接入上下班打卡信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}

	@JaxrsMethodDescribe( value = "根据ID删除打卡信息记录", action = ActionDelete.class )
	@DELETE
	@Path("{id}")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@Context HttpServletRequest request, @JaxrsParameterDescribe("移动考勤打卡信息ID") @PathParam("id") String id) {
		ActionResult<ActionDelete.Wo> result = new ActionResult<>();
		EffectivePerson effectivePerson = this.effectivePerson(request);
		Boolean check = true;
		if(check){
			try {
				result = new ActionDelete().execute( request, effectivePerson, id );
			} catch (Exception e) {
				result = new ActionResult<>();
				Exception exception = new ExceptionAttendanceDetailProcess( e, "根据ID删除信息时发生异常！" );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}	
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}
}