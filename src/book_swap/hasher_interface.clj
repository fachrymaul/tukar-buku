(ns book-swap.hasher-interface)

(defprotocol Hasher
  (hash-password [self password])
  (hash-verify-password [self password stored-password]))
