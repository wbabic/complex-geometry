(ns complex.draw
  (:require [complex.complex :as complex]
            [complex.geometry :as geometry]
            [complex.color :as color]))

(defn draw-circle [surface center radius]
  [:darw-circle {:center center :radius radius}])

;; origin one i x-axis y-axis S1
;; square {1 i -1 -i}
;; squares 1 2 3 
;; tri-1 {1 e^iT/3 e^-iT/3}
;; tri-2 tri-3 tri-4
;; hex-1 hex-2
;; dodec-1

;; mapping from complex plane
;; into a canvas of finite resolution

;; 400 by 400

;; center = (200,200)
;; radius = 200

;; twelth roots of unity
;; regular polygons
;; symmetry groups
;; arithmetic modulo one, tau = 2pi
;; multiplication of 
