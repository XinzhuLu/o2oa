/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.cms.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.cms.core.entity.Review.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:04:08 CST 2018")
public class Review_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Review,String> appAlias;
    public static volatile SingularAttribute<Review,String> appId;
    public static volatile SingularAttribute<Review,String> appName;
    public static volatile SingularAttribute<Review,String> categoryAlias;
    public static volatile SingularAttribute<Review,String> categoryId;
    public static volatile SingularAttribute<Review,String> categoryName;
    public static volatile SingularAttribute<Review,String> creatorIdentity;
    public static volatile SingularAttribute<Review,String> creatorPerson;
    public static volatile SingularAttribute<Review,String> creatorUnit;
    public static volatile SingularAttribute<Review,String> documentId;
    public static volatile SingularAttribute<Review,String> id;
    public static volatile SingularAttribute<Review,Boolean> isPublic;
    public static volatile SingularAttribute<Review,Date> publishTime;
    public static volatile SingularAttribute<Review,String> publishTimeMonth;
    public static volatile SingularAttribute<Review,String> readerName;
    public static volatile SingularAttribute<Review,String> readerType;
    public static volatile SingularAttribute<Review,String> title;
}
