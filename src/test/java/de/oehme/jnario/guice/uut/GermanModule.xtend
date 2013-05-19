package de.oehme.jnario.guice.uut

import com.google.inject.AbstractModule

class GermanModule extends AbstractModule {
	override protected configure() {
		bind(typeof(Greeter)).to(typeof(GermanGreeter))
	}
}