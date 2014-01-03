(ns complex.color)

;; hsla color space
;; as a vector of numbers
;; [h,s,l,a]
;; h is hue, an angle in degrees, 0 to 360, mod 360
;; s is saturation, a percentage, represented as a number between 0
;; and 1, expressed as a string of a number between 0 and 100, folloed
;; by a '%' character
;; l is light, a percentage, same as s
;; a is alpha, a number between 0 and 1

(defn ratios [n]
  (map #(/ % n) (range 1 (inc n))))

(defn hsla-saturation-range [h n]
  (mapv #(vector h % 0.65 0.8) (ratios n)))

(defn hsla-hue-range [n]
  (mapv #(vector % 0.50 0.50 0.8)
        (map (partial * 360) (ratios n))))

(defn percentage->str [percentage]
  (-> percentage
      (* 100)
      Math/round
      (str "%")))

(defn hsla->str [[h s l a]]
  (str "hsla("
       h ", "
       (percentage->str s) ", "
       (percentage->str l) ", "
       a ")"))

(defn highlight-color [[h s l a]]
  [h s 0.5 1.0])
