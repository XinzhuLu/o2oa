/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.report.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.report.core.entity.Report_C_WorkPlanNext.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:05:02 CST 2018")
public class Report_C_WorkPlanNext_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Report_C_WorkPlanNext,Date> date;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,Date> endTime;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> flag;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> id;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> keyWorkId;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> measuresId;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> measuresTitle;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> month;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,Integer> orderNumber;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> profileId;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> reportId;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,Date> startTime;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> targetIdentity;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> targetPerson;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> title;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> week;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> workInfoId;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> workTitle;
    public static volatile SingularAttribute<Report_C_WorkPlanNext,String> year;
}
