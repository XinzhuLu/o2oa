/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.element;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.element.Delay.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:04:55 CST 2018")
public class Delay_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Delay,String> afterArriveScript;
    public static volatile SingularAttribute<Delay,String> afterArriveScriptText;
    public static volatile SingularAttribute<Delay,String> afterExecuteScript;
    public static volatile SingularAttribute<Delay,String> afterExecuteScriptText;
    public static volatile SingularAttribute<Delay,String> afterInquireScript;
    public static volatile SingularAttribute<Delay,String> afterInquireScriptText;
    public static volatile SingularAttribute<Delay,String> alias;
    public static volatile SingularAttribute<Delay,Boolean> allowReroute;
    public static volatile SingularAttribute<Delay,Boolean> allowRerouteTo;
    public static volatile SingularAttribute<Delay,String> beforeArriveScript;
    public static volatile SingularAttribute<Delay,String> beforeArriveScriptText;
    public static volatile SingularAttribute<Delay,String> beforeExecuteScript;
    public static volatile SingularAttribute<Delay,String> beforeExecuteScriptText;
    public static volatile SingularAttribute<Delay,String> beforeInquireScript;
    public static volatile SingularAttribute<Delay,String> beforeInquireScriptText;
    public static volatile SingularAttribute<Delay,String> delayDataPath;
    public static volatile SingularAttribute<Delay,Integer> delayMinute;
    public static volatile SingularAttribute<Delay,String> delayScript;
    public static volatile SingularAttribute<Delay,String> delayScriptText;
    public static volatile SingularAttribute<Delay,Date> delayTime;
    public static volatile SingularAttribute<Delay,DelayType> delayType;
    public static volatile SingularAttribute<Delay,String> description;
    public static volatile SingularAttribute<Delay,String> extension;
    public static volatile SingularAttribute<Delay,String> form;
    public static volatile SingularAttribute<Delay,String> id;
    public static volatile SingularAttribute<Delay,String> name;
    public static volatile SingularAttribute<Delay,String> position;
    public static volatile SingularAttribute<Delay,String> process;
    public static volatile ListAttribute<Delay,String> readDataPathList;
    public static volatile SingularAttribute<Delay,String> readDuty;
    public static volatile ListAttribute<Delay,String> readGroupList;
    public static volatile ListAttribute<Delay,String> readIdentityList;
    public static volatile SingularAttribute<Delay,String> readScript;
    public static volatile SingularAttribute<Delay,String> readScriptText;
    public static volatile ListAttribute<Delay,String> readUnitList;
    public static volatile ListAttribute<Delay,String> reviewDataPathList;
    public static volatile SingularAttribute<Delay,String> reviewDuty;
    public static volatile ListAttribute<Delay,String> reviewGroupList;
    public static volatile ListAttribute<Delay,String> reviewIdentityList;
    public static volatile SingularAttribute<Delay,String> reviewScript;
    public static volatile SingularAttribute<Delay,String> reviewScriptText;
    public static volatile ListAttribute<Delay,String> reviewUnitList;
    public static volatile SingularAttribute<Delay,String> route;
    public static volatile SingularAttribute<Delay,Boolean> workMinute;
}
