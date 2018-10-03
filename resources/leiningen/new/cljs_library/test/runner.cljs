(ns {{project-ns}}.runner
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [{{project-ns}}.test-core]))

(doo-tests '{{project-ns}}.test-core)
