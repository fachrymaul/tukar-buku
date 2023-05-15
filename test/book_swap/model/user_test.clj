(ns book-swap.model.user-test
  (:require [book-swap.model.user :as sut]
            [clojure.test :as t]
            [book-swap.hasher-interface :as hi]
            [book-swap.hasher-mock :refer [HashMock]]))

(t/deftest positive-test-validate-email
  (t/is (true? (sut/validate-email "john.doe@email.com")))
  (t/is (true? (sut/validate-email "john.doe@email.co.au")))
  (t/is (true? (sut/validate-email "johndoe@email.org")))
  (t/is (true? (sut/validate-email "john_doe@email.org"))))

(t/deftest negative-test-validate-email
  (t/is (false? (sut/validate-email "john.doe@email.")))
  (t/is (false? (sut/validate-email "john.doe@email")))
  (t/is (false? (sut/validate-email "@email.com")))
  (t/is (false? (sut/validate-email "john.doeemail.com"))))

(t/deftest positive-test-validate-password
  (t/is (true? (sut/validate-password "Aaaaa111222333")))
  (t/is (true? (sut/validate-password "Aaaa 111222333")))
  (t/is (true? (sut/validate-password "Aaaa ! 1222333")))
  )

(t/deftest negative-test-validate-password
  (t/is (false? (sut/validate-password "a")))
  (t/is (false? (sut/validate-password "A")))
  (t/is (false? (sut/validate-password "1")))
  (t/is (false? (sut/validate-password "aA1")))
  (t/is (false? (sut/validate-password "aaaaaaaaaa")))
  (t/is (false? (sut/validate-password "AAAAAAAAAA")))
  (t/is (false? (sut/validate-password "1111111111")))
  (t/is (false? (sut/validate-password "aaaaAAAA1111111111111")))
  )

(t/deftest positive-test-authenticate
  (let [hasher (HashMock.)
        password "aaaAAA123"]
    (t/is (true? (sut/authenticate password {:hash (hi/hash-password hasher password) :salt ""} hasher)))))
