/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.program.center.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.program.center.core.entity.PromptErrorLog.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:05:10 CST 2018")
public class PromptErrorLog_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<PromptErrorLog,Boolean> collected;
    public static volatile SingularAttribute<PromptErrorLog,String> exceptionClass;
    public static volatile SingularAttribute<PromptErrorLog,String> id;
    public static volatile SingularAttribute<PromptErrorLog,String> loggerName;
    public static volatile SingularAttribute<PromptErrorLog,String> message;
    public static volatile SingularAttribute<PromptErrorLog,Date> occurTime;
    public static volatile SingularAttribute<PromptErrorLog,String> person;
    public static volatile SingularAttribute<PromptErrorLog,String> requestBody;
    public static volatile SingularAttribute<PromptErrorLog,Long> requestBodyLength;
    public static volatile SingularAttribute<PromptErrorLog,String> requestHead;
    public static volatile SingularAttribute<PromptErrorLog,String> requestMethod;
    public static volatile SingularAttribute<PromptErrorLog,String> requestRemoteAddr;
    public static volatile SingularAttribute<PromptErrorLog,String> requestRemoteHost;
    public static volatile SingularAttribute<PromptErrorLog,String> requestUrl;
    public static volatile SingularAttribute<PromptErrorLog,String> stackTrace;
    public static volatile SingularAttribute<PromptErrorLog,String> version;
}
