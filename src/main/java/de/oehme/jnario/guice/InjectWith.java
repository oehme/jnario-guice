package de.oehme.jnario.guice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.Module;

/**
 * Specifies which Guice module to use when creating this spec and its subjects.
 * Can be omitted if you want to use just-in-time bindings only.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface InjectWith {
	Class<? extends Module> value();
}
