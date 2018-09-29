package org.twinnation.superassert.annotation;

import java.lang.annotation.*;


/**
 * Nullable class.
 *
 * @author chris
 * @version 1.0.1
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Nullable {
	
	String message() default "The object passed as parameter can be null";
	
}
