/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.organization.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.organization.core.entity.Identity.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Mon Dec 24 19:04:46 CST 2018")
public class Identity_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Identity,String> description;
    public static volatile SingularAttribute<Identity,String> distinguishedName;
    public static volatile SingularAttribute<Identity,String> id;
    public static volatile SingularAttribute<Identity,Boolean> major;
    public static volatile SingularAttribute<Identity,String> name;
    public static volatile SingularAttribute<Identity,Integer> orderNumber;
    public static volatile SingularAttribute<Identity,String> person;
    public static volatile SingularAttribute<Identity,String> pinyin;
    public static volatile SingularAttribute<Identity,String> pinyinInitial;
    public static volatile SingularAttribute<Identity,String> unique;
    public static volatile SingularAttribute<Identity,String> unit;
    public static volatile SingularAttribute<Identity,Integer> unitLevel;
    public static volatile SingularAttribute<Identity,String> unitLevelName;
    public static volatile SingularAttribute<Identity,String> unitName;
}
