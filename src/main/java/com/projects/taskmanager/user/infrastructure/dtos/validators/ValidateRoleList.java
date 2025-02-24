package com.projects.taskmanager.user.infrastructure.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidateRoleListImpl.class)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateRoleList {
  String message() default "One or more roles are invalid";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default{};
}
