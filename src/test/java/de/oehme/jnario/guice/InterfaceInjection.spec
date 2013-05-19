package de.oehme.jnario.guice

import de.oehme.jnario.guice.uut.EnglishModule
import de.oehme.jnario.guice.uut.GermanModule
import de.oehme.jnario.guice.uut.Greeter
import javax.inject.Inject
import org.jnario.runner.CreateWith

@CreateWith(typeof(GuiceSpecCreator))
@InjectWith(typeof(EnglishModule))
describe Greeter "Interface Injection"{
	@Inject
	Greeter injected

	fact "the subject is injected by Guice"{
		subject.greet should be "Hello"
	}

	fact "spec variables are injected by Guice" {
		injected.greet should be "Hello"
	}

	context "within a non-annotated context" {
		fact "outer bindings are inherited" {
			subject.greet should be "Hello"
		}
	}

	@InjectWith(typeof(GermanModule))
	context "within an annotated context" {
		fact "the inner annotation takes precedence" {
			subject.greet should be "Hallo"
			injected.greet should be "Hallo"
		}
	}

}