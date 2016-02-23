(ns om-next-react-native-router-flux.react-requires)

; react-native
(set! js/React (js/require "react-native"))
(defonce Navigator (.-Navigator js/React))

; react-native-navbar
(defonce NavigationBar (js/require "react-native-navbar/index.js"))

; react-native-button
(defonce Button (js/require "react-native-button/Button.js"))

; react-native-tabs
(defonce Tabs (js/require "react-native-tabs/index.js"))

; react-native-router-flux
(defonce ReactNativeRouterFlux (js/require "react-native-router-flux/index.js"))
(defonce Schema (aget ReactNativeRouterFlux "Schema"))
(defonce Router (aget ReactNativeRouterFlux "Router"))
(defonce Route (aget ReactNativeRouterFlux "Route"))
(defonce TabBar (aget ReactNativeRouterFlux "TabBar"))
(defonce Actions (aget ReactNativeRouterFlux "Actions"))
(defonce Animations (aget ReactNativeRouterFlux "Animations"))

; react-native-modalbox
(defonce ReactNativeModalbox (js/require "react-native-modalbox/index.js"))