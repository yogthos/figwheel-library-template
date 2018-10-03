# cljs-library-template

A Figwheel enabled ClojureScript library template. This template
creates a dev harness that runs Figwheel with a custom Ring handler, and
sets up [lein-doo](https://github.com/bensu/doo) for testing.
This setup allows for interactive development and testing for ClojureScript
libraries.

The template will generate a stub for the `<project-name>.core` namespace under
`src/<proejct-name>`, and test sources in the `env/dev/<project-name>/` folder.

A test page is generated in the `env/dev<project-name>/test_page.cljs` file.
This page will be loaded when `lein figwheel` is run.

## Usage

create a new library project

    lein new cljs-lib mylib

run in development mode:

    lein figwheel

run tests once

    lein test

watch for changes and run tests

    lein test-watch

## License

Copyright © 2018 Dmitri Sotnikov

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
