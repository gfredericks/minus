(defproject com.gfredericks/minus "0.1.0-SNAPSHOT"
  :description "Diffing/patching for Clojure data"
  :url "https://github.com/gfredericks/minus"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles
  {:dev
   {:dependencies [[com.gfredericks/test.chuck "0.1.13"]
                   [org.clojure/test.check "0.6.2"]]}})
