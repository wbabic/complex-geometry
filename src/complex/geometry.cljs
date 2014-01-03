(ns complex.geometry
  (:require [complex.complex :as complex]))

(defn ratios [n]
  (map #(/ % n) (range n)))

(defn regular-polygon [n]
  (map complex/unit-polar (ratios n)))

(def triangle (regular-polygon 3))
(def square (regular-polygon 4))
(def pentagon (regular-polygon 5))
(def hexagon (regular-polygon 6))

(def initial-situation
  {:position [0 0]
   :orientation 0
   :size 1.0})

(defn move-to [situation new-position]
  (merge situation {:position new-position}))

(defn move-by [situation relative-position]
  (let [old-position (:position situation)]
    (move-to situation (mapv + old-position relative-position))))

(defn scale-to [situation scale]
  (merge situation {:size scale}))

(defn scale-by [situation scale-factor]
  (let [old-scale (:size situation)]
    (scale-to situation (* scale-factor old-scale))))

(defn orient-to [situation orientation]
  (merge situation {:orientation orientation}))

(defn orient-by [situation orientation-delta]
  (let [old-orientation (:orientation situation)]
    (orient-to situation (+ orientation-delta old-orientation))))

(defn transform-fn
  "return a fn for given transform data structure
the function will take a situation and return a new
transformed situation"
  [transform]
  (let [op (first transform)
        arg (second transform)]
    (case op
      :move-to #(move-to % arg)
      :move-by #(move-by % arg)
      :scale-to #(scale-to % arg)
      :scale-by #(scale-by % arg)
      :orient-to #(orient-to % arg)
      :orient-by #(orient-by % arg))))

(defn render [polygon]
  (let [situation (:situation polygon)
        [x0 y0] (:position situation)
        z0 (complex/make-rect x0 y0)
        v (complex/make-polar (:size situation) (:orientation situation))
        vertices (mapv (comp (complex/add-by z0)
                             (complex/mult-by v))
                       (:base polygon))]
    (merge polygon
           {:center z0
            :vertices vertices})))
