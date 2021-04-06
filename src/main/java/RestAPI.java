package pages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RestAPI {
    public String resourcePath() default "";
    public org.openqa.selenium.remote.http.HttpMethod httpMethod() default org.openqa.selenium.remote.http.HttpMethod.GET;
}
