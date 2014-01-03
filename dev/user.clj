(ns user
  "namespace for repl interaction"
  (:require [clojure.repl :refer :all]
            [clojure.pprint :refer (pprint)]
            [clojure.string :as string]
            [clojure.java.io :as io]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [complex.system :as system]
            [cljs.repl.browser :as brepl]
            [cemerick.piggieback :as pb]))

(def system nil)

(defn start-brepl
  "not working yet ..."
  []
  (pb/cljs-repl :repl-env (brepl/repl-env :port 9000)))

(defn init
  "Constructs the development system"
  []
  (alter-var-root
   #'system
   (constantly system/dev-system)))

(defn start
  "start the development system"
  []
  (alter-var-root
   #'system system/start))

(defn stop
  "Stop the development system"
  []
  (alter-var-root
   #'system
   (fn [s] (when s (system/stop s)))))

(defn go
  ""
  []
  (init)
  (start))

(defn reset
  ""
  []
  (stop)
  (refresh :after 'user/go))

(comment
  (go)
  (-> system :web))
