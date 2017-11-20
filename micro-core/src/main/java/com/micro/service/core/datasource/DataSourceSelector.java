package com.micro.service.core.datasource;

import java.lang.annotation.*;

/**
 *
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSourceSelector {

	String value() default "master";

}

