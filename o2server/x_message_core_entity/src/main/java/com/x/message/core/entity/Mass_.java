/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.message.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.message.core.entity.Mass.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Fri Dec 21 15:31:11 CST 2018")
public class Mass_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Mass,String> body;
    public static volatile SingularAttribute<Mass,String> creatorPerson;
    public static volatile ListAttribute<Mass,String> groupList;
    public static volatile SingularAttribute<Mass,String> id;
    public static volatile ListAttribute<Mass,String> identityList;
    public static volatile ListAttribute<Mass,String> personList;
    public static volatile ListAttribute<Mass,String> sendPersonList;
    public static volatile SingularAttribute<Mass,String> type;
    public static volatile ListAttribute<Mass,String> unitList;
}
