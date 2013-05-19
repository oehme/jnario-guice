package de.oehme.jnario.guice;

import static com.google.common.base.Preconditions.checkState;

import org.jnario.runner.SpecCreator;

import com.google.common.base.Throwables;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * Instantiates this spec and its subjects using Guice. You can specify a module
 * with the desired bindings with the {@link InjectWith} annotation. If no
 * module is specified, only just-in-time bindings will be used.
 */
public class GuiceSpecCreator implements SpecCreator {

	private Injector injector;

	public <T> T createSpec(Class<T> spec) {
		injector = Guice.createInjector(moduleFor(spec));
		return injector.getInstance(spec);
	}

	private Module moduleFor(Class<?> spec) {
		InjectWith moduleDef = spec.getAnnotation(InjectWith.class);
		return moduleDef == null ? Modules.EMPTY_MODULE
				: instantiateModule(moduleDef);
	}

	private Module instantiateModule(InjectWith moduleDef) {
		try {
			return moduleDef.value().newInstance();
		} catch (Exception e) {
			Throwables.propagateIfPossible(e);
			throw new IllegalArgumentException("Error creating "
					+ moduleDef.value().getSimpleName()
					+ ", make sure it has a public no-argument constructor.");
		}
	}

	public <T> T createSubject(Class<T> subject) {
		checkState(injector != null,
				"Creating a subject outside of a spec is not possible.");
		return injector.getInstance(subject);
	}

	public void beforeSpecRun() {
	}

	public void afterSpecRun() {
	}
}
