/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.cms.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.cms.core.entity.Log.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Fri Dec 21 15:30:33 CST 2018")
public class Log_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Log,String> appId;
    public static volatile SingularAttribute<Log,String> categoryId;
    public static volatile SingularAttribute<Log,String> description;
    public static volatile SingularAttribute<Log,String> documentId;
    public static volatile SingularAttribute<Log,String> fileId;
    public static volatile SingularAttribute<Log,String> id;
    public static volatile SingularAttribute<Log,String> operationLevel;
    public static volatile SingularAttribute<Log,String> operationType;
    public static volatile SingularAttribute<Log,String> operatorName;
    public static volatile SingularAttribute<Log,String> operatorUid;
}
