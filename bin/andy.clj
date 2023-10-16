#!/usr/bin/env bb

(require '[babashka.fs :as fs]
         '[clojure.edn :as edn]
         '[clojure.java.io :as io]
         '[clojure.java.shell :refer [sh]]
         '[clojure.string :as str])
(import java.io.PushbackReader)

(def f (if (str/blank? *file*) ; i.e. REPLing
         "../resources/andy-notes-urls.edn"
         ;; follow the symlink (see README.md)
         (-> *file* fs/real-path fs/parent fs/parent (fs/path "resources/andy-notes-urls.edn") str)))

(with-open [r (io/reader f)]
  (let [rand-url (rand-nth (edn/read (PushbackReader. r)))]
    (println (str "opening " rand-url))
    (sh "xdg-open" rand-url)))
