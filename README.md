jnario-guice
============

Guice dependency injection for Jnario Specs

[![Build Status](https://travis-ci.org/oehme/jnario-guice.svg)](https://travis-ci.org/oehme/jnario-guice)
[![Download](https://api.bintray.com/packages/oehme/maven/jnario-guice/images/download.svg) ](https://bintray.com/oehme/maven/jnario-guice/_latestVersion)

Features
========

Just annotate your Spec class with 

	@CreateWith(GuiceSpecCreator) 

and optionally specify a Guice module using

	@InjectWith(MyModule)

Now you can use the @Inject annotation in your spec.

	@CreateWith(GuiceSpecCreator)
	@InjectWith(EnglishModule)
	describe Greeter "Interface Injection" {
		@Inject
		Greeter injected
	
		fact "the subject is injected by Guice" {
			subject.greet should be "Hello"
		}
	
		fact "spec variables are injected by Guice" {
			injected.greet should be "Hello"
		}
	}
