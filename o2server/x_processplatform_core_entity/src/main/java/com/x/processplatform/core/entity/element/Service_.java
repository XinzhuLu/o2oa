/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.element;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.String;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.element.Service.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Fri Dec 21 15:31:44 CST 2018")
public class Service_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Service,String> afterArriveScript;
    public static volatile SingularAttribute<Service,String> afterArriveScriptText;
    public static volatile SingularAttribute<Service,String> afterExecuteScript;
    public static volatile SingularAttribute<Service,String> afterExecuteScriptText;
    public static volatile SingularAttribute<Service,String> afterInquireScript;
    public static volatile SingularAttribute<Service,String> afterInquireScriptText;
    public static volatile SingularAttribute<Service,String> alias;
    public static volatile SingularAttribute<Service,Boolean> allowReroute;
    public static volatile SingularAttribute<Service,Boolean> allowRerouteTo;
    public static volatile SingularAttribute<Service,String> beforeArriveScript;
    public static volatile SingularAttribute<Service,String> beforeArriveScriptText;
    public static volatile SingularAttribute<Service,String> beforeExecuteScript;
    public static volatile SingularAttribute<Service,String> beforeExecuteScriptText;
    public static volatile SingularAttribute<Service,String> beforeInquireScript;
    public static volatile SingularAttribute<Service,String> beforeInquireScriptText;
    public static volatile SingularAttribute<Service,String> description;
    public static volatile SingularAttribute<Service,String> extension;
    public static volatile SingularAttribute<Service,String> form;
    public static volatile SingularAttribute<Service,String> id;
    public static volatile SingularAttribute<Service,String> name;
    public static volatile SingularAttribute<Service,String> position;
    public static volatile SingularAttribute<Service,String> process;
    public static volatile ListAttribute<Service,String> readDataPathList;
    public static volatile SingularAttribute<Service,String> readDuty;
    public static volatile ListAttribute<Service,String> readGroupList;
    public static volatile ListAttribute<Service,String> readIdentityList;
    public static volatile SingularAttribute<Service,String> readScript;
    public static volatile SingularAttribute<Service,String> readScriptText;
    public static volatile ListAttribute<Service,String> readUnitList;
    public static volatile ListAttribute<Service,String> reviewDataPathList;
    public static volatile SingularAttribute<Service,String> reviewDuty;
    public static volatile ListAttribute<Service,String> reviewGroupList;
    public static volatile ListAttribute<Service,String> reviewIdentityList;
    public static volatile SingularAttribute<Service,String> reviewScript;
    public static volatile SingularAttribute<Service,String> reviewScriptText;
    public static volatile ListAttribute<Service,String> reviewUnitList;
    public static volatile SingularAttribute<Service,String> route;
    public static volatile SingularAttribute<Service,String> script;
    public static volatile SingularAttribute<Service,String> scriptText;
    public static volatile ListAttribute<Service,String> trustAddressList;
}
