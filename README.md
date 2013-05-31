Enables injection of subjects and fields in Jnario tests. Works with both the Specifiaction and Feature language.

[![Build Status](https://oehme.ci.cloudbees.com/job/jnario-guice/badge/icon)](https://oehme.ci.cloudbees.com/job/jnario-guice/)

A small example:

    @CreateWith(typeof(GuiceSpecCreator))
    @InjectWith(typeof(SpecialFoolModule))
    describe Foo {
      @Inject Foo variable
      
      fact "injection just works" {
        subject should not be null
        variable should not be null
      }
    }

For more examples, see the tests of this project.
