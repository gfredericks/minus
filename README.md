# minus

Minus is a Clojure library that compares two data structures and
generates a patch for turning the first into the second.

## Is it pretty dumb so far?

Yes.

## Obtention

Leiningen coordinates: `[com.gfredericks/minus "0.1.0"]`

## Usage

``` clojure
user> (require '[com.gfredericks.minus :as minus])
nil
user> (def the-data {:foo 12, :bar [1 2 3]})
#'user/the-data
user> (def the-different-data
        (-> the-data
            (assoc :bam "okay")
            (dissoc :foo)
            (update-in [:bar] conj 99)))
#'user/the-different-data
user> (= the-different-data
         (minus/apply (minus/diff the-data the-different-data)
                      the-data))
true
```

## License

Copyright © 2015 Gary Fredericks

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
