(defproject complex "0.1.0-SNAPSHOT"
  :description "A project for making graphs"
  :url "http://wbabic.github.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2030"]
                 [ring "1.2.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [org.clojure/core.async "0.1.256.0-1bf8cf-alpha"]
                 [com.cemerick/piggieback "0.1.2"]
                 [environ "0.4.0"]]
  :profiles {:dev {:source-paths ["dev"]}}
  :plugins [[lein-cljsbuild "1.0.0"]
            [lein-environ "0.4.0"]]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :cljsbuild
  {:builds
   [{:source-paths ["src/complex"]
     :compiler {:output-to "resources/public/js/complex.js"
                :optimizations :whitespace
                :pretty-print true}}]}
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [org.clojure/java.classpath "0.2.0"]]}})
