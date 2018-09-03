package org.twinnation.superassert.annotation;

import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Nullable {
	
	String message() default "The object passed as parameter can be null";
	
}
