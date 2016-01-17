(ns designer.core
  (:require
   [om.next :as om :include-macros true]
   [sablono.core :as sab :include-macros true]
   [designer.components :refer [Field]]
   [designer.state :as state])
  (:require-macros
    [designer.macros :refer [inspect inspect-with]]
    [devcards.core :as dc :refer [defcard defcard-doc defcard-om-next noframe-doc deftest dom-node]]))

(enable-console-print!)

(defonce app-state (atom state/initial-data))

(defmulti reader om/dispatch)
(defmulti mutator om/dispatch)

(def parser (om/parser {:read reader
                        :mutate mutator}))

(def reconciler (om/reconciler {:state app-state
                                :parser parser}))

(defcard-om-next app-test
  Field
  reconciler
  {:inspect-data true})

(defn main []
  ;; conditionally start the app based on wether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (js/React.render (sab/html [:div "This is working"]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

