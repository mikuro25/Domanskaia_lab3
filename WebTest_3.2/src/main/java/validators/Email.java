package validators;

public @interface Email {
    String message() default "Invalid email";
}
