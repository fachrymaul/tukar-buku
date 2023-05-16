(ns book-swap.model.user
  (:require [book-swap.hasher-interface :as hi]))

(defrecord User [id username email password])

(defprotocol DatabaseInteractor
  (get-user-by-email-from-db [email] )
  (get-user-by-username-from-db [username] )
  (update-username-db [user username] )
  (update-email-db [user email])
  (update-password-db [user password]))

(defn validate-email [email]
  (not (nil? (re-matches #".+@.+\..+" email))))

(defn validate-password [password]
  (not (nil? (re-matches #"^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$" password))))

(defn authenticate [hasher password stored-password]
  (hi/verify-password hasher password stored-password))

(defn generate-auth-token [user] )

(defn update-username [user username] )

(defn update-email [user email] )

(defn update-password [user password] )

(defn get-user-info-by-email [email] )

(defn get-user-info-by-user [username])
