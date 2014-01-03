(ns complex.routes
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))

(defn get-app-routes []
  (routes
   (route/resources "/")
   (route/not-found "not found")))

(defn get-app []
  (-> (get-app-routes)
      (handler/site)))
