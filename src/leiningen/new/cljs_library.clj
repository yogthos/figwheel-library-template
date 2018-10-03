(ns leiningen.new.cljs-library
  (:require [leiningen.new.templates
             :refer [renderer name-to-path ->files
                     sanitize sanitize-ns project-name]]
            [leiningen.core.main :as main]
            [clojure.string :refer [join]]))

(def render (renderer "cljs-library"))

(defn assets [name]
  (let [data {:full-name           name
              :name                (project-name name)
              :project-goog-module (sanitize (sanitize-ns name))
              :project-ns          (sanitize-ns name)
              :sanitized           (name-to-path name)}]
    [data
     ["project.clj" (render "project.clj" data)]
     ["resources/public/css/base.css" (render "resources/public/css/base.css" data)]
     ["env/dev/resources/public/css/site.css" (render "env/dev/resources/public/css/site.css" data)]
     ["env/dev/clj/{{sanitized}}/server.clj" (render "env/dev/clj/server.clj" data)]
     ["env/dev/clj/user.clj" (render "env/dev/clj/user.clj" data)]
     ["env/dev/cljs/{{sanitized}}/dev.cljs" (render "env/dev/cljs/dev.cljs" data)]
     ["env/dev/cljs/{{sanitized}}/test_page.cljs" (render "env/dev/cljs/test_page.cljs" data)]
     ["src/{{sanitized}}/core.cljs" (render "src/core.cljs" data)]
     ["test/{{sanitized}}/runner.cljs" (render "test/runner.cljs" data)]
     ["test/{{sanitized}}/test_core.cljs" (render "test/test_core.cljs" data)]
     ["LICENSE" (render "LICENSE" data)]
     ["README.md" (render "README.md" data)]
     [".gitignore" (render "gitignore" data)]]))

(defn cljs-library [name & opts]
  (main/info "Generating fresh 'lein new' cljs-library project.")
  (apply ->files (assets name)))
