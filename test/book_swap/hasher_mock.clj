(ns book-swap.hasher-mock
  (:require  [clojure.test :as t]
             [book-swap.hasher-interface :as hi]))

(defrecord HashMock []
    hi/Hasher
  (hash-password [_ password]
    (str "mocked hash:" password))
  (hash-verify-password [self password stored-password]
    (= (hi/hash-password self password) (:hash stored-password))))

(t/deftest test-hash-mock
  (let [hash-mock (HashMock.)
        password "password"
        mocked-hashed-password "mocked hash:password" ]
    (t/is (= mocked-hashed-password  (hi/hash-password hash-mock password)))
    (t/is (true? (hi/hash-verify-password hash-mock password {:hash mocked-hashed-password})))))
