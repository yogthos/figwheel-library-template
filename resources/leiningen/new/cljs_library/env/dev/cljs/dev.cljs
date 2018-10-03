(ns ^:figwheel-no-load {{project-ns}}.dev
  (:require
    [{{project-ns}}.test-page :as test-page]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(test-page/init!)
