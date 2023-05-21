(ns andy
  (:require [clojure.data.csv :refer [read-csv]]
            [clojure.java.io :as io]
            [clojure.java.shell :refer [sh]]))


(defn comment? [[line :as v]]
  (and (= 1 (count v))
       (re-find #"^#" line)))

(defn read-csv-into-maps [f]
  (with-open [r (io/reader f)]
    (let [[cols & rows] (doall (->> (read-csv r {:separator \;})
                                    (remove comment?)))]
      (map (partial zipmap (map keyword cols)) rows))))

(defn note-url? [url]
  (re-find #"^https://notes\.andymatuschak\.org/.+(?<!\.js|\.css|\.png|\.gif|\.jpg|\.jpeg|\.HEIC|\.webp)$" url))

(def andy-note-urls
  ;; some PDFs might have snuck in there too...
  (->> (read-csv-into-maps "resources/andy.csv")
       (keep (comp note-url? :url))
       (into #{})
       (into [])))

(comment
  ;; open random note
  (sh "xdg-open" (rand-nth andy-note-urls))

  ;; write note urls to file
  (require '[clojure.pprint :as pp])
  (spit "resources/andy-notes-urls.edn"
        (with-out-str (pp/write andy-note-urls :dispatch pp/code-dispatch)))
  )
