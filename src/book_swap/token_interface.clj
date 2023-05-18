(ns book-swap.token-interface)

(defprotocol TokenGenerator
  (generate-token [self user]))
