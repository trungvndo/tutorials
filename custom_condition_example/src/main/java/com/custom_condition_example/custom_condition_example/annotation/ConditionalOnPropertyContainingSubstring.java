package com.custom_condition_example.custom_condition_example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnPropertyContainingSubstringCondition.class)
public @interface ConditionalOnPropertyContainingSubstring {

    String[] value() default {};

    String prefix() default "";

    String[] name() default {};

    String containingString();
}