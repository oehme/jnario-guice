package de.oehme.jnario.guice.uut

import com.google.inject.AbstractModule

class EnglishModule extends AbstractModule {
	override protected configure() {
		bind(typeof(Greeter)).to(typeof(EnglishGreeter))
	}
}
