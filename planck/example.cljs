#!/usr/bin/env planck

(require '[planck.core :refer [slurp *in*]])

(def input (-> *in*
               slurp
               JSON.parse
               (js->clj :keywordize-keys true)))

(def output (->> input
                 (map :artist)
                 frequencies
                 (sort-by second >)))

(doseq [[artist freq] output]
  (println freq artist))
