(ns complex.system
  (:require [complex.routes :as routes]
            [environ.core :as environ])
  (:use [ring.adapter jetty]))

(def dev-system
  "a new instance of the whole application
using a transient database initialized to schema."
  {:web {:port 3005}})

(defn start-web
  "start the web server when 
:web exists"
  [system options]
  (let [server (when (:web system)
                 (run-jetty (routes/get-app)
                            options))]
    (cond-> system
            server (assoc-in [:web :server] server))))

(defn start
  "start the system
start the web server"
  [system]
  (let [port (-> system :web :port)
        options {:port port :join? false}]
    (-> system
        (start-web options))))

(defn stop
  "stop the system"
  [system]
  (let [stop-web (when-let [server (-> system :web :server)]
                   (.stop server)
                   :ok)]
    (cond-> system
            stop-web (update-in [:web] dissoc :server))))
