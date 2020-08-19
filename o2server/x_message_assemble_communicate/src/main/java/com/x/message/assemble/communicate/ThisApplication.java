package com.x.message.assemble.communicate;

import com.x.base.core.project.message.MessageConnector;
import org.apache.commons.lang3.BooleanUtils;

import com.x.base.core.project.Context;
import com.x.base.core.project.cache.CacheManager;
import com.x.base.core.project.config.Config;
import com.x.base.core.project.logger.LoggerFactory;
import com.x.message.assemble.communicate.schedule.Clean;
import com.x.message.assemble.communicate.schedule.TriggerMq;
import com.x.message.core.entity.Message;

public class ThisApplication {

	protected static Context context;

	public static WsConsumeQueue wsConsumeQueue = new WsConsumeQueue();

	public static PmsConsumeQueue pmsConsumeQueue = new PmsConsumeQueue();

	public static CalendarConsumeQueue calendarConsumeQueue = new CalendarConsumeQueue();

	public static QiyeweixinConsumeQueue qiyeweixinConsumeQueue = new QiyeweixinConsumeQueue();

	public static ZhengwuDingdingConsumeQueue zhengwuDingdingConsumeQueue = new ZhengwuDingdingConsumeQueue();

	public static DingdingConsumeQueue dingdingConsumeQueue = new DingdingConsumeQueue();

	public static WeLinkConsumeQueue weLinkConsumeQueue = new WeLinkConsumeQueue();

	public static PmsInnerConsumeQueue pmsInnerConsumeQueue = new PmsInnerConsumeQueue();

	public static MQConsumeQueue mqConsumeQueue = new MQConsumeQueue();

	public static Context context() {
		return context;
	}

	public static void init() {
		try {
			CacheManager.init(context.clazz().getSimpleName());
			LoggerFactory.setLevel(Config.logLevel().x_message_assemble_communicate());
			if (Config.communicate().wsEnable()) {
				wsConsumeQueue.start();
			}
			if (Config.communicate().pmsEnable()) {
				pmsConsumeQueue.start();
			}
			if (Config.communicate().calendarEnable()) {
				calendarConsumeQueue.start();
			}
			if (BooleanUtils.isTrue(Config.communicate().clean().getEnable())) {
				context().schedule(Clean.class, Config.communicate().clean().getCron());
			}
			if (BooleanUtils.isTrue(Config.qiyeweixin().getEnable())
					&& BooleanUtils.isTrue(Config.qiyeweixin().getMessageEnable())) {
				qiyeweixinConsumeQueue.start();
			}
			if (BooleanUtils.isTrue(Config.zhengwuDingding().getEnable())
					&& BooleanUtils.isTrue(Config.zhengwuDingding().getMessageEnable())) {
				zhengwuDingdingConsumeQueue.start();
			}
			if (Config.dingding().getEnable() && Config.dingding().getMessageEnable()) {
				dingdingConsumeQueue.start();
			}
			if (BooleanUtils.isTrue(Config.pushConfig().getEnable())) {
				pmsInnerConsumeQueue.start();
			}
			if (Config.weLink().getEnable() && Config.weLink().getMessageEnable()) {
				weLinkConsumeQueue.start();
			}

			if (Config.mq().getEnable()) {
				mqConsumeQueue.start();
			}

			MessageConnector.start(context());

			if (BooleanUtils.isTrue(Config.communicate().cronMq().getEnable())) {
				context().schedule(TriggerMq.class, Config.communicate().cronMq().getCron());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void destroy() {
		try {
			CacheManager.shutdown();
			wsConsumeQueue.stop();
			pmsConsumeQueue.stop();
			calendarConsumeQueue.stop();
			qiyeweixinConsumeQueue.stop();
			zhengwuDingdingConsumeQueue.stop();
			dingdingConsumeQueue.stop();
			pmsInnerConsumeQueue.stop();
			weLinkConsumeQueue.stop();
			MessageConnector.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
