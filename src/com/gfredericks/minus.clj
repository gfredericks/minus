(ns com.gfredericks.minus
  (:refer-clojure :exclude [apply]))

(defmulti diff
  "Returns a patch for transforming x1 into x2."
  (fn [x1 x2] [(type x1) (type x2)]))

(defmethod diff [Object Object]
  [x1 x2]
  (if (= x1 x2)
    {:type :identity}
    {:type :constantly
     :object x2}))


(defmulti apply
  "Applies the patch to the given object."
  (fn [patch x] (:type patch)))

(defmethod apply :identity
  [_patch x]
  x)

(defmethod apply :constantly
  [patch _x]
  (:object patch))
