(defproject complex "0.1.0-SNAPSHOT"
  :description "A project for making graphs"
  :url "http://wbabic.github.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [ring "1.2.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [com.cemerick/piggieback "0.1.2"]
                 [environ "0.4.0"]]
  :plugins [[lein-cljsbuild "1.0.1"]
            [lein-environ "0.4.0"]]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :cljsbuild
  {:builds
   [{:id "dev"
     :source-paths ["src/complex"
                    "src/dev"]
     :compiler {:optimizations :whitespace
                :pretty-print false
                :output-to "resources/public/js/complex.js"}}
    {:id "advanced"
     :source-paths ["src/complex"]
     :compiler {:optimizations :advanced
                :pretty-print false
                :output-to "resources/public/js/complex-advanced.js"
                :output-wrapper true}}]}
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [org.clojure/java.classpath "0.2.0"]]}})
