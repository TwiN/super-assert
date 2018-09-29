package org.twinnation.superassert.annotation;

import java.lang.annotation.*;


/**
 * NotNull class.
 *
 * @author chris
 * @version 1.0.1
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
	
	String message() default "The object passed as parameter cannot be null";

}
