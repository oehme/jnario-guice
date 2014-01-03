jnario-guice
============

Guice dependency injection for Jnario Specs

[![Build Status](https://oehme.ci.cloudbees.com/job/jnario-guice/badge/icon)](https://oehme.ci.cloudbees.com/job/jnario-guice/)

    <dependency>
      <groupId>com.github.oehme.jnario</groupId>
      <artifactId>jnario-guice</artifactId>
      <version>...</version>
    </dependency>
    
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
	
See the tests for more examples.