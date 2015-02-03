(ns com.gfredericks.minus-test
  (:require [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [com.gfredericks.minus :as minus]
            [com.gfredericks.test.chuck.generators :as gen']))

(defspec general-spec 1000
  ;; using cap-size here until test.check fixes its problems with
  ;; gen/any (I think keyword-and-symbol sizes in particular)
  (prop/for-all [x (gen'/cap-size 35 gen/any)
                 y (gen'/cap-size 35 gen/any)]
    (let [patch (minus/diff x y)]
      (= y (minus/apply patch x)))))
