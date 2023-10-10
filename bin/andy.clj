#!/usr/bin/env bb

(require '[clojure.edn :as edn]
         '[clojure.java.io :as io]
         '[clojure.java.shell :refer [sh]])
(import java.io.PushbackReader)


(with-open [r (io/reader (io/resource "andy-notes-urls.edn"))]
  (let [rand-url (rand-nth (edn/read (PushbackReader. r)))]
    (println (str "opening " rand-url))
    (sh "xdg-open" rand-url)))
