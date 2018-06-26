package com.ekart.user.utility;

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
	String message() default "YOURPACKAGE.In.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	State[] values() default { State.ANDHRA_PRADESH, State.ARUNACHAL_PRADESH, State.ASSAM, State.BIHAR,
			State.CHHATTISGARH, State.GOA, State.GUJARAT, State.HARYANA, State.HIMACHAL_PRADESH,
			State.JAMMU_AND_KASHMIR, State.JHARKHAND, State.KARNATAKA, State.KERALA, State.MADHYA_PRADESH,
			State.MAHARASHTRA, State.MANIPUR, State.MEGHALAYA, State.MIZORAM, State.NAGALAND, State.ODISHA,
			State.PUNJAB, State.RAJASTHAN, State.SIKKIM, State.TAMIL_NADU, State.TELANGANA, State.TRIPURA,
			State.UTTAR_PRADESH, State.UTTARAKHAND, State.WEST_BENGAL };
}

class InConstraintValidator implements ConstraintValidator<In, String> {

	private State[] values;

	public final void initialize(final In annotation) {
		values = annotation.values();
	}

	public final boolean isValid(final String value, final ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return Stream.of(values).anyMatch(state -> state.getState().equals(value.toUpperCase()));
	}

}
