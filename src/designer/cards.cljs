(ns designer.cards
  (:require
   [om.next :as om :include-macros true]
   [sablono.core :as sab :include-macros true]
   [designer.components :as components]
   [designer.core :as core]
   [designer.state :as state]
   [designer.parsing :as parsing])
  (:require-macros
    [designer.macros :refer [inspect inspect-with]]
    [devcards.core :as dc :refer [defcard defcard-doc defcard-om-next noframe-doc deftest dom-node]]))

(enable-console-print!)

(defcard-om-next app-test
  components/Root
  core/reconciler
  {:inspect-data true})
