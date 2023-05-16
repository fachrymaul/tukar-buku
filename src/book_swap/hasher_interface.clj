(ns book-swap.hasher-interface)

(defprotocol Hasher
  (hash-password [self password])
  (verify-password [self password stored-password]))
