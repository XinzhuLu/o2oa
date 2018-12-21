package com.x.okr.assemble.control.jaxrs.okrworkbaseinfo;


import javax.servlet.http.HttpServletRequest;

import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.base.core.project.jaxrs.WoId;
import com.x.base.core.project.logger.Logger;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.okr.assemble.control.OkrUserCache;
import com.x.okr.assemble.control.jaxrs.okrworkbaseinfo.exception.ExceptionGetOkrUserCache;
import com.x.okr.assemble.control.jaxrs.okrworkbaseinfo.exception.ExceptionWorkBaseInfoProcess;
import com.x.okr.assemble.control.jaxrs.okrworkbaseinfo.exception.ExceptionWorkIdEmpty;
import com.x.okr.assemble.control.jaxrs.okrworkbaseinfo.exception.ExceptionWorkNotExists;
import com.x.okr.assemble.control.jaxrs.queue.WrapInWorkDynamic;
import com.x.okr.entity.OkrWorkBaseInfo;

public class ActionArchive extends BaseAction {

	private static  Logger logger = LoggerFactory.getLogger( ActionArchive.class );
	
	protected ActionResult<Wo> execute( HttpServletRequest request, EffectivePerson effectivePerson, String id ) throws Exception {
		ActionResult<Wo> result = new ActionResult<>();
		OkrWorkBaseInfo okrWorkBaseInfo = null;
		OkrUserCache  okrUserCache  = null;
		Boolean check = true;
		
		if( id == null || id.isEmpty() ){
			check = false;
			Exception exception = new ExceptionWorkIdEmpty();
			result.error( exception );
		}
		try {
			okrUserCache = okrUserInfoService.getOkrUserCacheWithPersonName( effectivePerson.getDistinguishedName() );
		}catch(Exception e){
			check = false;
			Exception exception = new ExceptionGetOkrUserCache( e, effectivePerson.getDistinguishedName() );
			result.error( exception );
			logger.error( e, effectivePerson, request, null);
		}
		if(check){
			try {
				okrWorkBaseInfo = okrWorkBaseInfoService.get( id );
				if( okrWorkBaseInfo == null ){
					check = false;
					Exception exception = new ExceptionWorkNotExists( id );
					result.error( exception );
				}
			} catch ( Exception e ) {
				check = false;
				Exception exception = new ExceptionWorkBaseInfoProcess( e, "查询指定ID的具体工作信息时发生异常。ID：" + id );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}
		}
		if( check ){
			try{
				okrWorkBaseInfoOperationService.archive( id );
				result.setData( new Wo( id ) );
				
				if( okrWorkBaseInfo != null ) {
					WrapInWorkDynamic.sendWithWorkInfo( okrWorkBaseInfo, 
							effectivePerson.getDistinguishedName(), 
							okrUserCache.getLoginUserName(), 
							okrUserCache.getLoginIdentityName() , 
							"归档具体工作", 
							"具体工作归档成功！"
					);
				}
			}catch(Exception e){
				Exception exception = new ExceptionWorkBaseInfoProcess( e, "系统根据工作ID列表查询附件信息列表发生异常. ID：" + id );
				result.error( exception );
				logger.error( e, effectivePerson, request, null);
			}
		}
		return result;
	}
	
	public static class Wo extends WoId {
		public Wo( String id ) {
			this.setId( id );
		}
	}
}