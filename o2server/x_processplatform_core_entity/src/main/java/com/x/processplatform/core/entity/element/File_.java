/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.element;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.element.File.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:04:55 CST 2018")
public class File_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<File,String> alias;
    public static volatile SingularAttribute<File,String> application;
    public static volatile SingularAttribute<File,String> data;
    public static volatile SingularAttribute<File,String> description;
    public static volatile SingularAttribute<File,String> fileName;
    public static volatile SingularAttribute<File,String> id;
    public static volatile SingularAttribute<File,String> lastUpdatePerson;
    public static volatile SingularAttribute<File,Date> lastUpdateTime;
    public static volatile SingularAttribute<File,Long> length;
    public static volatile SingularAttribute<File,String> name;
}
