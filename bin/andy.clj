#!/usr/bin/env bb

(require '[clojure.edn :as edn]
         '[clojure.java.io :as io]
         '[clojure.java.shell :refer [sh]])
(import java.io.PushbackReader)


(def abs-base "Documents/Coding/Clojure-Randoms/andy/")

(with-open [r (io/reader (str abs-base "resources/andy-notes-urls.edn"))]
  (let [rand-url (rand-nth (edn/read (PushbackReader. r)))]
    (println (str "opening " rand-url))
    (sh "xdg-open" rand-url)))
