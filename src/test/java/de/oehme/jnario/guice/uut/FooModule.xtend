package de.oehme.jnario.guice.uut

import com.google.inject.AbstractModule

class FooModule extends AbstractModule {
	override protected configure() {
		bind(typeof(String)).toInstance("Foo")
	}
}