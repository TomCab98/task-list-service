package com.projects.taskmanager.user.infrastructure.dtos.validators;

import com.projects.taskmanager.user.infrastructure.dtos.RoleEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateRoleListImpl implements ConstraintValidator<ValidateRoleList, List<String>> {

  private List<String> validRoles;

  @Override
  public void initialize(ValidateRoleList constraintAnnotation) {
    validRoles = Arrays.stream(RoleEnum.values())
      .map(Enum::name)
      .collect(Collectors.toList());
  }

  @Override
  public boolean isValid(List<String> roles, ConstraintValidatorContext context) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (roles != null) {
      System.out.println("Roles distinto de null");
      if (
        authentication == null ||
        !authentication.isAuthenticated() ||
        authentication.getAuthorities().stream().noneMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))
      ) {
        setValidationMessage(context, "Unauthorized request");
        return false;
      }

      if (roles.isEmpty()) {
        setValidationMessage(context, "Role list cannot be empty");
        return false;
      }

      List<String> invalidRoles = roles.stream()
        .filter(role -> !validRoles.contains(role))
        .toList();

      if (!invalidRoles.isEmpty()) {
        setValidationMessage(context, "Invalid roles found: " + invalidRoles);
        return false;
      }

      return true;
    }

    return true;
  }

  private void setValidationMessage(ConstraintValidatorContext context, String message) {
    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
  }
}
