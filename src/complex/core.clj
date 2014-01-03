(ns complex.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def tau (* 2 Math/PI))

(defn ratios [n]
  (map (fn [k] (/ k n)) (range n)))

(def twelve-fold (ratios 12))

(def twentyfour-fold (ratios 24))

(defn degrees [ratios]
  (map (fn [k] (* k 360)) twelve-fold))

(defn radians [ratios]
  (map (fn [k] (* k tau)) twelve-fold))

(comment
 (degrees twelve-fold)
 (radians twelve-fold)
 )

