/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.attendance.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.attendance.entity.AttendanceScheduleSetting.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:03:36 CST 2018")
public class AttendanceScheduleSetting_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> absenceStartTime;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> id;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> lateStartTime;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> leaveEarlyStartTime;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> offDutyTime;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> onDutyTime;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> topUnitName;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> unitName;
    public static volatile SingularAttribute<AttendanceScheduleSetting,String> unitOu;
}
