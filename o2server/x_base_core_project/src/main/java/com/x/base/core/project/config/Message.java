package com.x.base.core.project.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.x.base.core.project.annotation.FieldDescribe;
import com.x.base.core.project.gson.GsonPropertyObject;
import com.x.base.core.project.gson.XGsonBuilder;
import com.x.base.core.project.message.MessageConnector;

public class Message extends GsonPropertyObject {

	private static final long serialVersionUID = 2536141863287117519L;

	private static final String DEFAULT_DESCRIPTION = "说明";

	public Message() {
		this.description = DEFAULT_DESCRIPTION;
	}

	public Message(String... conusmers) {
		Gson gson = XGsonBuilder.instance();
		if (null != consumers) {
			for (String arg : conusmers) {
				// this.consumersV2.put(arg, "");
				this.consumers.add(gson.toJsonTree(concreteConsumer(arg)));
			}
		}
	}

//	public Message(Map<String, String> map) {
//		if (map != null) {
//			this.consumersV2.putAll(map);
//		}
//	}

	public static Message defaultInstance() {
		return new Message();
	}

//	@FieldDescribe("早期配置,已经废弃")
//	@Deprecated
//	private Map<String, String> consumersV2 = new HashMap<>();

	@FieldDescribe("消费通道配置")
	private List<JsonElement> consumers = new ArrayList<>();

	@FieldDescribe("说明")
	private String description;

	public String getDescription() {
		return description;
	}

	public List<JsonElement> getConsumers() {
		return consumers;
	}

//	public Map<String, String> getConsumersV2() {
//		return consumersV2;
//	}
//
//	public void setConsumersV2(Map<String, String> consumersV2) {
//		this.consumersV2 = consumersV2;
//	}

	public static class Consumer implements Serializable {

		private static final long serialVersionUID = 392932139617988800L;

		public static final String FIELD_TYPE = "type";

		private static final Boolean DEFAULT_ENABLE = true;
		private static final String DEFAULT_TYPE = "";
		private static final String DEFAULT_LOADER = "";
		private static final String DEFAULT_FILTER = "";

		public Consumer() {
			this.type = DEFAULT_TYPE;
			this.enable = DEFAULT_ENABLE;
			this.loader = DEFAULT_LOADER;
			this.filter = DEFAULT_FILTER;
		}

		public Consumer(String type, boolean enable) {
			this.type = type;
			this.enable = enable;
			this.loader = DEFAULT_LOADER;
			this.filter = DEFAULT_FILTER;
		}

		public Consumer(String type) {
			this();
			this.type = type;

		}

		@FieldDescribe("消费者名称")
		private String type;
		@FieldDescribe("是否启用")
		private Boolean enable;
		@FieldDescribe("装载脚本")
		private String loader;
		@FieldDescribe("过滤脚本")
		private String filter;

		public Boolean getEnable() {
			return (null == this.enable) ? DEFAULT_ENABLE : this.enable;
		}

		public String getFilter() {
			return StringUtils.isBlank(this.filter) ? DEFAULT_FILTER : this.filter;
		}

		public String getType() {
			return StringUtils.isBlank(this.type) ? DEFAULT_TYPE : this.type;
		}

		public String getLoader() {
			return StringUtils.isBlank(this.loader) ? DEFAULT_LOADER : this.loader;
		}

	}

	public static Consumer concreteConsumer(String type) {
		switch (StringUtils.lowerCase(Objects.toString(type, ""))) {
		case MessageConnector.CONSUME_WS:
			return new WsConsumer();
		case MessageConnector.CONSUME_PMS_INNER:
			return new PmsinnerConsumer();
		case MessageConnector.CONSUME_CALENDAR:
			return new CalendarConsumer();
		case MessageConnector.CONSUME_DINGDING:
			return new DingdingConsumer();
		case MessageConnector.CONSUME_WELINK:
			return new WelinkConsumer();
		case MessageConnector.CONSUME_ZHENGWUDINGDING:
			return new ZhengwudingdingConsumer();
		case MessageConnector.CONSUME_QIYEWEIXIN:
			return new QiyeweixinConsumer();
		case MessageConnector.CONSUME_MPWEIXIN:
			return new MpweixinConsumer();
		case MessageConnector.CONSUME_KAFKA:
			return new KafkaConsumer();
		case MessageConnector.CONSUME_ACTIVEMQ:
			return new ActivemqConsumer();
		case MessageConnector.CONSUME_RESTFUL:
			return new RestfulConsumer();
		case MessageConnector.CONSUME_MAIL:
			return new MailConsumer();
		case MessageConnector.CONSUME_API:
			return new ApiConsumer();
		case MessageConnector.CONSUME_JDBC:
			return new JdbcConsumer();
		case MessageConnector.CONSUME_TABLE:
			return new TableConsumer();
		case MessageConnector.CONSUME_HADOOP:
			return new HadoopConsumer();
		default:
			return new Consumer(type);
		}
	}

	public static class WsConsumer extends Consumer {

		private static final long serialVersionUID = 8702816982685612136L;

		public WsConsumer() {
			super(MessageConnector.CONSUME_WS, true);
		}

	}

	public static class PmsinnerConsumer extends Consumer {

		private static final long serialVersionUID = -1246633610717846231L;

		public PmsinnerConsumer() {
			super(MessageConnector.CONSUME_PMS_INNER, true);
		}

	}

	public static class CalendarConsumer extends Consumer {

		private static final long serialVersionUID = -1453591270935170682L;

		public CalendarConsumer() {
			super(MessageConnector.CONSUME_CALENDAR, false);
		}

	}

	public static class DingdingConsumer extends Consumer {

		private static final long serialVersionUID = -2273422698767839910L;

		public DingdingConsumer() {
			super(MessageConnector.CONSUME_DINGDING, true);
		}

	}

	public static class WelinkConsumer extends Consumer {

		private static final long serialVersionUID = -5796171639649346866L;

		public WelinkConsumer() {
			super(MessageConnector.CONSUME_WELINK, true);
		}

	}

	public static class ZhengwudingdingConsumer extends Consumer {

		private static final long serialVersionUID = -1805579720843025600L;

		public ZhengwudingdingConsumer() {
			super(MessageConnector.CONSUME_ZHENGWUDINGDING, true);
		}

	}

	public static class QiyeweixinConsumer extends Consumer {

		private static final long serialVersionUID = -3957612144231971034L;

		public QiyeweixinConsumer() {
			super(MessageConnector.CONSUME_QIYEWEIXIN, true);
		}

	}

	public static class MpweixinConsumer extends Consumer {

		private static final long serialVersionUID = -9116678126784563430L;

		public MpweixinConsumer() {
			super(MessageConnector.CONSUME_MPWEIXIN, true);
		}

	}

	public static class ApiConsumer extends Consumer {

		private static final long serialVersionUID = -4452633351300698272L;

		public ApiConsumer() {
			super(MessageConnector.CONSUME_API, false);
			this.application = DEFAULT_APPLICATION;
			this.path = DEFAULT_PATH;
			this.method = DEFAULT_METHOD;
		}

		private static final String DEFAULT_APPLICATION = "";
		private static final String DEFAULT_PATH = "";
		private static final String DEFAULT_METHOD = "get";

		@FieldDescribe("应用")
		private String application;
		@FieldDescribe("路径")
		private String path;
		@FieldDescribe("方法")
		private String method;

		public String getApplication() {
			return StringUtils.isBlank(this.application) ? DEFAULT_APPLICATION : this.application;
		}

		public String getPath() {
			return StringUtils.isBlank(this.path) ? DEFAULT_PATH : this.path;
		}

		public String getMethod() {
			return StringUtils.isBlank(this.method) ? DEFAULT_METHOD : this.method;
		}

	}

	public static class MailConsumer extends Consumer {

		private static final long serialVersionUID = -8411174187306234827L;

		public MailConsumer() {
			super(MessageConnector.CONSUME_MAIL, false);
			this.host = DEFAULT_HOST;
			this.port = DEFAULT_PORT;
			this.sslEnable = DEFAULT_SSLENABLE;
			this.auth = DEFAULT_AUTH;
			this.from = DEFAULT_FROM;
			this.password = DEFAULT_PASSWORD;
		}

		private static final String DEFAULT_HOST = "";
		private static final Integer DEFAULT_PORT = 465;
		private static final Boolean DEFAULT_SSLENABLE = true;
		private static final Boolean DEFAULT_AUTH = true;
		private static final String DEFAULT_FROM = "admin@o2oa.net";
		private static final String DEFAULT_PASSWORD = "password";

		@FieldDescribe("smtp主机.")
		private String host;

		@FieldDescribe("smtp端口.")
		private Integer port;

		@FieldDescribe("smtp 使用ssl加密.")
		private Boolean sslEnable;

		@FieldDescribe("stmp启用认证.")
		private Boolean auth;

		@FieldDescribe("发件人.")
		private String from;

		@FieldDescribe("发件人密码.")
		private String password;

		public String getHost() {
			return StringUtils.isBlank(this.host) ? DEFAULT_HOST : this.host;
		}

		public Integer getPort() {
			return null == port ? DEFAULT_PORT : this.port;
		}

		public Boolean getSslEnable() {
			return null == sslEnable ? DEFAULT_SSLENABLE : this.sslEnable;
		}

		public Boolean getAuth() {
			return null == auth ? DEFAULT_AUTH : this.auth;
		}

		public String getFrom() {
			return StringUtils.isBlank(this.from) ? DEFAULT_FROM : this.from;
		}

		public String getPassword() {
			return StringUtils.isBlank(this.password) ? DEFAULT_PASSWORD : this.password;
		}

	}

	public static class JdbcConsumer extends Consumer {

		private static final long serialVersionUID = 3234273317758806957L;

		public JdbcConsumer() {
			super(MessageConnector.CONSUME_JDBC, false);
			this.driverClass = DEFAULT_DRIVERCLASS;
			this.url = DEFAULT_URL;
			this.username = DEFAULT_USERNAME;
			this.password = DEFAULT_PASSWORD;
			this.catalog = DEFAULT_CATALOG;
			this.schema = DEFAULT_SCHEMA;
			this.table = DEFAULT_TABLE;
		}

		private static final String DEFAULT_DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
		private static final String DEFAULT_URL = "jdbc:mysql://";
		private static final String DEFAULT_USERNAME = "root";
		private static final String DEFAULT_PASSWORD = "password";
		private static final String DEFAULT_CATALOG = "";
		private static final String DEFAULT_SCHEMA = "";
		private static final String DEFAULT_TABLE = "NEWTABLE";

		@FieldDescribe("驱动类")
		private String driverClass;

		@FieldDescribe("地址")
		private String url;

		@FieldDescribe("用户名")
		private String username;

		@FieldDescribe("密码")
		private String password;

		@FieldDescribe("catalog")
		private String catalog;

		@FieldDescribe("schema")
		private String schema;

		@FieldDescribe("表名")
		private String table;

		public String getDriverClass() {
			return StringUtils.isBlank(this.driverClass) ? DEFAULT_DRIVERCLASS : this.driverClass;
		}

		public String getUrl() {
			return StringUtils.isBlank(this.url) ? DEFAULT_URL : this.url;
		}

		public String getUsername() {
			return StringUtils.isBlank(this.username) ? DEFAULT_USERNAME : this.username;
		}

		public String getPassword() {
			return StringUtils.isBlank(this.password) ? DEFAULT_PASSWORD : this.password;
		}

		public String getCatalog() {
			return StringUtils.isBlank(this.catalog) ? DEFAULT_CATALOG : this.catalog;
		}

		public String getSchema() {
			return StringUtils.isBlank(this.schema) ? DEFAULT_SCHEMA : this.schema;
		}

		public String getTable() {
			return StringUtils.isBlank(this.table) ? DEFAULT_TABLE : this.table;
		}

	}

	public static class TableConsumer extends Consumer {

		private static final long serialVersionUID = 1791986872720051543L;

		public TableConsumer() {
			super(MessageConnector.CONSUME_TABLE, false);
			this.table = DEFAULT_TABLE;
		}

		private static final String DEFAULT_TABLE = "";

		@FieldDescribe("自建表")
		private String table;

		public String getTable() {
			return StringUtils.isBlank(this.table) ? DEFAULT_TABLE : this.table;
		}
	}

	public static class RestfulConsumer extends Consumer {

		private static final long serialVersionUID = 3700827567810061437L;

		private static final String DEFAULT_URL = "";
		private static final String DEFAULT_METHOD = "get";

		public RestfulConsumer() {
			super(MessageConnector.CONSUME_RESTFUL, false);
			this.url = DEFAULT_URL;
			this.method = DEFAULT_METHOD;
		}

		@FieldDescribe("地址")
		private String url;

		@FieldDescribe("方法")
		private String method;

		public String getUrl() {
			return StringUtils.isBlank(this.url) ? DEFAULT_URL : this.url;
		}

		public String getMethod() {
			return StringUtils.isBlank(this.method) ? DEFAULT_METHOD : this.method;
		}
	}

	public static class HadoopConsumer extends Consumer {

		private static final long serialVersionUID = -8274136904009320770L;

		public HadoopConsumer() {
			super(MessageConnector.CONSUME_HADOOP, false);
			this.fsDefaultFS = DEFAULT_FS_DEFAULTFS;
			this.username = DEFAULT_USERNAME;
			this.path = DEFAULT_PATH;
		}

		private static final String DEFAULT_FS_DEFAULTFS = "hdfs://";
		private static final String DEFAULT_USERNAME = "";
		private static final String DEFAULT_PATH = "";

		@FieldDescribe("hadoop地址.")
		private String fsDefaultFS;

		@FieldDescribe("hadoop用户名.")
		private String username;

		@FieldDescribe("fs路径前缀.")
		private String path;

		public String getFsDefaultFS() {
			return StringUtils.isEmpty(this.fsDefaultFS) ? DEFAULT_FS_DEFAULTFS : this.fsDefaultFS;
		}

		public String getUsername() {
			return StringUtils.isEmpty(this.username) ? DEFAULT_USERNAME : this.username;
		}

		public String getPath() {
			return StringUtils.isEmpty(this.path) ? DEFAULT_PATH : this.path;
		}
	}

	public static class KafkaConsumer extends Consumer {

		private static final long serialVersionUID = 8788289001004063043L;

		public KafkaConsumer() {
			super(MessageConnector.CONSUME_KAFKA, false);
			this.bootstrapServers = DEFAULT_BOOTSTRAPSERVERS;
			this.topic = DEFAULT_TOPIC;
			this.securityProtocol = DEFAULT_SECURITYPROTOCOL;
			this.saslMechanism = DEFAULT_SASLMECHANISM;
			this.username = DEFAULT_USERNAME;
			this.password = DEFAULT_PASSWORD;
		}

		private static final String DEFAULT_BOOTSTRAPSERVERS = "";
		private static final String DEFAULT_TOPIC = "o2oa";
		private static final String DEFAULT_SECURITYPROTOCOL = "SASL_PLAINTEXT";
		private static final String DEFAULT_SASLMECHANISM = "PLAIN";
		private static final String DEFAULT_USERNAME = "";
		private static final String DEFAULT_PASSWORD = "";

		@FieldDescribe("服务器地址")
		private String bootstrapServers;

		@FieldDescribe("主题")
		private String topic;

		@FieldDescribe("认证协议")
		private String securityProtocol;

		@FieldDescribe("加密机制")
		private String saslMechanism;

		@FieldDescribe("用户名")
		private String username;

		@FieldDescribe("密码")
		private String password;

		public String getBootstrapServers() {
			return StringUtils.isBlank(this.bootstrapServers) ? DEFAULT_BOOTSTRAPSERVERS : this.bootstrapServers;
		}

		public String getTopic() {
			return StringUtils.isBlank(this.topic) ? DEFAULT_TOPIC : this.topic;
		}

		public String getSecurityProtocol() {
			return StringUtils.isBlank(this.securityProtocol) ? DEFAULT_SECURITYPROTOCOL : this.securityProtocol;
		}

		public String getSaslMechanism() {
			return StringUtils.isBlank(this.saslMechanism) ? DEFAULT_SASLMECHANISM : this.saslMechanism;
		}

		public String getUsername() {
			return StringUtils.isBlank(this.username) ? DEFAULT_USERNAME : this.username;
		}

		public String getPassword() {
			return StringUtils.isBlank(this.password) ? DEFAULT_PASSWORD : this.password;
		}

	}

	public static class ActivemqConsumer extends Consumer {

		private static final long serialVersionUID = -7469816290407400176L;

		public ActivemqConsumer() {
			super(MessageConnector.CONSUME_ACTIVEMQ, false);
			this.username = DEFAULT_USERNAME;
			this.password = DEFAULT_PASSWORD;
			this.url = DEFAULT_URL;
			this.queueName = DEFAULT_QUEUENAME;
		}

		private static final String DEFAULT_USERNAME = "";
		private static final String DEFAULT_PASSWORD = "";
		private static final String DEFAULT_URL = "";
		private static final String DEFAULT_QUEUENAME = "";

		@FieldDescribe("用户名")
		private String username;

		@FieldDescribe("密码")
		private String password;

		@FieldDescribe("服务器地址")
		private String url;

		@FieldDescribe("消息队列名")
		private String queueName;

		public String getUsername() {
			return StringUtils.isBlank(this.username) ? DEFAULT_USERNAME : this.username;
		}

		public String getPassword() {
			return StringUtils.isBlank(this.password) ? DEFAULT_PASSWORD : this.password;
		}

		public String getUrl() {
			return StringUtils.isBlank(this.url) ? DEFAULT_URL : this.url;
		}

		public String getQueueName() {
			return StringUtils.isBlank(this.queueName) ? DEFAULT_QUEUENAME : this.queueName;
		}
	}

	public Message cloneThenSetDescription(String description) {
		Message clone = XGsonBuilder.convert(this, Message.class);
		clone.description = description;
		return clone;
	}

}
