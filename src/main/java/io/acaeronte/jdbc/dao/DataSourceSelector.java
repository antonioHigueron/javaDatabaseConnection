package io.acaeronte.jdbc.dao;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceSelector {
    String name();
}
