package com.projectU.framework;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author sanjeet.pandit
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Info {
    String description();
    String status();
    String category();
}