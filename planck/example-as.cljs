#!/usr/bin/env planck

(require '[planck.core :refer [slurp *in*]])

(def data (as-> *in* d
                (slurp d)
                (JSON.parse d)
                (js->clj d :keywordize-keys true)
                (map :artist d)
                (frequencies d)
                (sort-by second > d)))

(doseq [[artist freq] data]
  (println freq artist))
