package com.ekart.seller.utility;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InConstraintValidator.class)
public @interface In {
	String message() default "Not a Valid Category";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Category[] values() default { 
		Category.MOBILE, Category.TELEVISION, Category.CAMERA, Category.HEADPHONE, Category.WATCH, Category.LAPTOP	};
}

class InConstraintValidator implements ConstraintValidator<In, String> {

	private Category[] values;

	public final void initialize(final In annotation) {
		values = annotation.values();
	}

	public final boolean isValid(final String value, final ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return Stream.of(values).anyMatch(state -> state.getCategory().toLowerCase().equals(value.toLowerCase()));
	}

}
