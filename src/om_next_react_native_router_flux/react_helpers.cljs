(ns om-next-react-native-router-flux.react-helpers
  (:require [om-next-react-native-router-flux.react-requires :as rr])) ;; IMPORTANT!  Must be required first)

; react-native-navbar
;
(defn navigation-bar
  "Simple interop for third party js react-native-navbar/NavigationBar component"
  [opts & children]
  (apply js/React.createElement rr/NavigationBar (clj->js opts) (clj->js children)))

; react-native-router-flux
;
(defn schema
  "Simple interop for third party js react-native-router-flux/Schema component"
  [opts & children]
  (.createElement js/React rr/Schema (clj->js opts) (clj->js children)))

(defn router
  "Interop to react-native-router-flux/Router component

   HACK: Instead of taking props as a map and converting it to javascript (thus killing om's immutable props),
   this fn destructures a vector into router-props and om-props, converts the router-props to javascript
   and appends om-props under the key :om-props."
  [[router-props om-props] & children]
  (let [js-props (clj->js router-props)]
    (aset js-props "om-props" om-props)
    (.createElement js/React rr/Router js-props (clj->js children))))

(defn route
  "Simple interop for third party js react-native-router-flux/Route component
  NOTE: Only one child is allowed."
  [opts & children]
  (.createElement js/React rr/Route (clj->js opts) (clj->js (first children))))

(defn tab-bar
  "Simple interop for third party js react-native-router-flux/TabBar component"
  [opts & children]
  (.createElement js/React rr/TabBar (clj->js opts) (clj->js children)))

(defn actions
  "Simple interop for third party js react-native-router-flux/Actions component"
  [opts & children]
  (.createElement js/React rr/Actions (clj->js opts) (clj->js children)))

(defn animations
  "Simple interop for third party js react-native-router-flux/Animations component"
  [opts & children]
  (.createElement js/React rr/Animations (clj->js opts) (clj->js children)))

;; react-native-button
;;
(defn button
  "Simple interop for third party js react-native-button/Button component"
  [opts & children]
  (.createElement js/React rr/Button (clj->js opts) (clj->js children)))

;; react-native-tabs
;;
(defn tabs
  "Simple interop for third party js react-native-tabs/Tabs component"
  [opts & children]
  (.createElement js/React rr/Tabs (clj->js opts) (clj->js children)))


;; react-native-modalbox
(defn modal
  "Simple interop for third party js react-native-tabs/Tabs component"
  [opts & children]
  (.createElement js/React rr/ReactNativeModalbox (clj->js opts) (clj->js children)))
