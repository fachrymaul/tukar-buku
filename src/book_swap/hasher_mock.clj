(ns book-swap.hasher-mock
  (:require [book-swap.hasher-interface :as hi]))

(defrecord HashMock []
  hi/Hasher
  (hash-password [_ password]
    (str "mocked hash: " password))
  (verify-password [self password stored-password]
    (= (hi/hash-password self password) (:hash stored-password))))
