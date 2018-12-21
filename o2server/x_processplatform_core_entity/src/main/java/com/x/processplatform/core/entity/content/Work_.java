/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.content;

import com.x.base.core.entity.SliceJpaObject_;
import com.x.processplatform.core.entity.element.ActivityType;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.content.Work.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Fri Dec 21 15:31:44 CST 2018")
public class Work_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Work,String> activity;
    public static volatile SingularAttribute<Work,String> activityAlias;
    public static volatile SingularAttribute<Work,Date> activityArrivedTime;
    public static volatile SingularAttribute<Work,String> activityDescription;
    public static volatile SingularAttribute<Work,String> activityName;
    public static volatile SingularAttribute<Work,String> activityToken;
    public static volatile SingularAttribute<Work,ActivityType> activityType;
    public static volatile SingularAttribute<Work,String> application;
    public static volatile SingularAttribute<Work,String> applicationAlias;
    public static volatile SingularAttribute<Work,String> applicationName;
    public static volatile SingularAttribute<Work,Boolean> beforeExecuted;
    public static volatile SingularAttribute<Work,String> creatorIdentity;
    public static volatile SingularAttribute<Work,String> creatorPerson;
    public static volatile SingularAttribute<Work,String> creatorUnit;
    public static volatile SingularAttribute<Work,String> creatorUnitLevelName;
    public static volatile SingularAttribute<Work,Boolean> dataChanged;
    public static volatile SingularAttribute<Work,String> destinationActivity;
    public static volatile SingularAttribute<Work,ActivityType> destinationActivityType;
    public static volatile SingularAttribute<Work,String> destinationRoute;
    public static volatile SingularAttribute<Work,String> destinationRouteName;
    public static volatile SingularAttribute<Work,String> embedTargetWork;
    public static volatile SingularAttribute<Work,Integer> errorRetry;
    public static volatile SingularAttribute<Work,Date> expireTime;
    public static volatile SingularAttribute<Work,Boolean> forceRoute;
    public static volatile SingularAttribute<Work,Boolean> forceRouteArriveCurrentActivity;
    public static volatile SingularAttribute<Work,String> form;
    public static volatile SingularAttribute<Work,String> id;
    public static volatile SingularAttribute<Work,String> job;
    public static volatile ListAttribute<Work,String> manualTaskIdentityList;
    public static volatile SingularAttribute<Work,String> process;
    public static volatile SingularAttribute<Work,String> processAlias;
    public static volatile SingularAttribute<Work,String> processName;
    public static volatile SingularAttribute<Work,String> serial;
    public static volatile SingularAttribute<Work,String> serviceValue;
    public static volatile SingularAttribute<Work,String> splitToken;
    public static volatile ListAttribute<Work,String> splitTokenList;
    public static volatile SingularAttribute<Work,String> splitValue;
    public static volatile SingularAttribute<Work,Boolean> splitting;
    public static volatile SingularAttribute<Work,Date> startTime;
    public static volatile SingularAttribute<Work,String> startTimeMonth;
    public static volatile SingularAttribute<Work,String> title;
    public static volatile SingularAttribute<Work,WorkStatus> workStatus;
}
