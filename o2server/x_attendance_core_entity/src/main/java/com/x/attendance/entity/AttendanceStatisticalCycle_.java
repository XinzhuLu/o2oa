/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.attendance.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.attendance.entity.AttendanceStatisticalCycle.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:03:36 CST 2018")
public class AttendanceStatisticalCycle_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<AttendanceStatisticalCycle,Date> cycleEndDate;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> cycleEndDateString;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> cycleMonth;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,Date> cycleStartDate;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> cycleStartDateString;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> cycleYear;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> description;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> id;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> topUnitName;
    public static volatile SingularAttribute<AttendanceStatisticalCycle,String> unitName;
}
