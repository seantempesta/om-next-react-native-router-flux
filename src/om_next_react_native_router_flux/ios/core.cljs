(ns om-next-react-native-router-flux.ios.core
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require [om-next-react-native-router-flux.react-requires] ;; IMPORTANT!  Must be required first
            [om-next-react-native-router-flux.react-helpers]  ;; IMPORTANT!  Must be required second
            [om.next :as om :refer-macros [defui]]
            [re-natal.support :as sup]
            [om-next-react-native-router-flux.state :as state]
            [om-next-react-native-router-flux.routing :refer [Routing]]))

(def app-registry (.-AppRegistry js/React))
(def logo-img (js/require "./images/cljs.png"))

(def AppRoot Routing)

(defonce RootNode (sup/root-node! 1))
(defonce app-root (om/factory Routing))

(defn init []
  (om/add-root! state/reconciler Routing 1)
  (.registerComponent app-registry "OmNextReactNativeRouterFlux" (fn [] app-root)))