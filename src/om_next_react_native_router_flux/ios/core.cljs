(ns om-next-react-native-router-flux.ios.core
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require [om.next :as om :refer-macros [defui]]
            [re-natal.support :as sup]
            [om-next-react-native-router-flux.state :as state]))

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

; react-native-navbar
;
(defn navigation-bar
  "Simple interop for third party js react-native-navbar/NavigationBar component"
  [opts & children]
  (apply js/React.createElement NavigationBar (clj->js opts) (clj->js children)))

; react-native-router-flux
;
(defn schema
  "Simple interop for third party js react-native-router-flux/Schema component"
  [opts & children]
  (.createElement js/React Schema (clj->js opts) (clj->js children)))

(defn router
  "Interop to react-native-router-flux/Router component

   HACK: Instead of taking props as a map and converting it to javascript (thus killing om's immutable props),
   this fn destructures a vector into router-props and om-props, converts the router-props to javascript
   and appends om-props under the key :om-props."
  [[router-props om-props] & children]
  (let [js-props (clj->js router-props)]
    (aset js-props "om-props" om-props)
    (.log js/console "Router! " (clj->js children))
    (.createElement js/React Router js-props (clj->js children))))

(defn route
  "Simple interop for third party js react-native-router-flux/Route component
  NOTE: Only one child is allowed."
  [opts & children]
  (.createElement js/React Route (clj->js opts) (clj->js (first children))))

(defn tab-bar
  "Simple interop for third party js react-native-router-flux/TabBar component"
  [opts & children]
  (.createElement js/React TabBar (clj->js opts) (clj->js children)))

(defn actions
  "Simple interop for third party js react-native-router-flux/Actions component"
  [opts & children]
  (.createElement js/React Actions (clj->js opts) (clj->js children)))

(defn animations
  "Simple interop for third party js react-native-router-flux/Animations component"
  [opts & children]
  (.createElement js/React Animations (clj->js opts) (clj->js children)))

;; react-native-button
;;
(defn button
  "Simple interop for third party js react-native-button/Button component"
  [opts & children]
  (.createElement js/React Button (clj->js opts) (clj->js children)))

;; react-native-tabs
;;
(defn tabs
  "Simple interop for third party js react-native-tabs/Tabs component"
  [opts & children]
  (.createElement js/React Tabs (clj->js opts) (clj->js children)))


;; react-native-modalbox
(defn modalbox
  "Simple interop for third party js react-native-tabs/Tabs component"
  [opts & children]
  (.createElement js/React ReactNativeModalbox (clj->js opts) (clj->js children)))





(defui Home
  Object
  (render [this]
    (view {:style {:flex            1
                   :justifyContent  "center"
                   :alignItems      "center"
                   :backgroundColor "#F5FCFF"}}
          (text {} "Replace Screen")
          (button {:onPress #(.pop Actions)} "Back"))))

(def home (om/factory Home))

(defui Launch
  Object
  (render [this]
    (view {:style {:flex            1
                   :justifyContent  "center"
                   :alignItems      "center"
                   :backgroundColor "transparent"}}
          (text {} "Launch page")
          (button {:onPress #(.login Actions (clj->js {:data  "Custom data"
                                                       :title "Custom title"}))} "Go to Login page")
          (button {:onPress #(.register Actions)} "Go to Register page")
          (button {:onPress #(.register2 Actions)} "Go to Register page without animation")
          (button {:onPress #(.modalBox Actions)} "PopUp with ReactNativeModalBox")
          (button {:onPress #(.tabbar Actions)} "Go to TabBar")
          (button {:onPress #(.showActionSheet Actions
                                               (clj->js {:callback
                                                         (fn [index] (.log js/console "Selected:" index))}))} "Show ActionSheet")
          )))

;  <Button onPress={Actions.register2}>Go to Register page without animation</Button>
;<Button onPress={()=>Actions.error("Error message")}>Popup error</Button>
;<Button onPress={Actions.modalBox}>PopUp with ReactNativeModalBox</Button>
;<Button onPress={Actions.tabbar}>Go to TabBar page</Button>
;<Button onPress={()=>Actions.showActionSheet({callback:index=>alert("Selected:"+index)})}>Show ActionSheet</Button>


(def launch (om/factory Launch))

(defui Register
  Object
  (render [this]
    (view {:style {:flex            1
                   :justifyContent  "center"
                   :alignItems      "center"
                   :backgroundColor "transparent"}}
          (text {} "Register page")
          (button {:onPress #(.home Actions)} "Replace screen")
          (button {:onPress #(.pop Actions)} "Back"))))

(def register (om/factory Register))

(defui Login
  Object
  (render [this]
    (let [all-props (om/props this)
          data "FIXME"]
      (view {:style {:flex            1
                     :justifyContent  "center"
                     :alignItems      "center"
                     :backgroundColor "#F5FCFF"}}
            (text {} (str "Login page " data))
            (button {:onPress #(.loginModal2 Actions)} "Login 2")
            (button {:onPress #(.pop Actions)} "Back")))))

(def login (om/factory Login))

(defui Login2
  Object
  (render [this]
    (let [all-props (om/props this)
          data "FIXME"]
      (view {:style {:flex            1
                     :justifyContent  "center"
                     :alignItems      "center"
                     :backgroundColor "#F5FCFF"}}
            (text {} (str "Login2 page: " data))
            (button {:onPress #(.pop Actions)} "Back")))))

(def login2 (om/factory Login2))

(defui TabView
  Object
  (render [this]
    (let [all-props (om/props this)
          title "TITLE!"
          name "NAME!"]
      (view {:style {:flex            1
                     :justifyContent  "center"
                     :alignItems      "center"
                     :backgroundColor "#F5FCFF"}}
            (text {} (str "Tab " title))
            (button {:onPress #(.pop Actions)} "Back")
            (button {:onPress #(.tab1 Actions)} "Switch to tab1")))))

(def tab-view (om/factory TabView))

(defui TabView2
  Object
  (render [this]
    (let [all-props (om/props this)
          name "1"]
      (view {:style {:flex            1
                     :justifyContent  "center"
                     :alignItems      "center"
                     :backgroundColor "#F5FCFF"}}
            (text {} (str "Tab " name))))))

(def tab-view2 (om/factory TabView2))

(defui TabIcon
  Object
  (render [this]
    (let [all-props (om/props this)
          title "TITLE!"
          selected true]
      (text {:style {:color (if selected "red" "black")}} title))))

(def tab-icon (om/factory TabIcon))

(defui Header
  Object
  (render [this]
    (text {} "Header")))

(def header (om/factory Header))


(defui Example
  Object
  (render [this]
    (let [om-props (om/props this)]
      (router [{:hideNavBar true
                :name       "root"}
               om-props]
              (schema {:key         "schema-modal"
                       :name        "modal"
                       :sceneConfig (aget Navigator "SceneConfigs" "FloatFromBottom")})
              (schema {:key         "schema-default"
                       :name        "default"
                       :sceneConfig (aget Navigator "SceneConfigs" "FloatFromRight")})
              (schema {:key  "schema-withoutAnimation"
                       :name "withoutAnimation"})
              (schema {:key  "schema-tab"
                       :name "tab"
                       :type "switch"
                       :icon TabIcon})
              (route {:key       "route-register"
                      :name      "register"
                      :component Register})
              (route {:key                    "route-showActionSheet"
                      :name                   "showActionSheet"
                      :type                   "actionSheet"
                      :title                  "What do you want to do?"
                      :options                ["Delete" "Save" "Cancel"]
                      :cancelButtonIndex      2
                      :destructiveButtonIndex 0})
              (route {:key       "route-home"
                      :name      "home"
                      :component Home
                      :title     "Replace"
                      :type      "replace"})
              (route {:key    "route-login"
                      :name   "login"
                      :schema "modal"}
                     (router [{:key  "router-loginRouter"
                               :name "loginRouter"}
                              om-props]
                             (route {:key       "route-loginModal"
                                     :name      "loginModal"
                                     :component Login
                                     :schema    "modal"})
                             (route {:key        "route-loginModal2"
                                     :name       "loginModal2"
                                     :hideNavBar true
                                     :component  Login2
                                     :title      "Login2"})))
              (route {:key       "route-register2"
                      :name      "register2"
                      :component Register
                      :title     "Register2"
                      :schema    "withoutAnimation"})
              (route {:key       "route-modalBox"
                      :name      "modalBox"
                      :type      "modal"
                      :component modalbox})
              (route {:key  "route-tabbar"
                      :name "tabbar"}
                     (router [{:key               "router-tabbar"
                               :footer            TabBar
                               :showNavigationBar false}
                              om-props]
                             (route {:key    "route-tab1"
                                     :name   "tab1"
                                     :schema "tab"
                                     :title  "Tab #1"}
                                    (router [{:key   "router-tab1"
                                              :onPop #(do (.log js/console "onPop is called!")
                                                          true)}
                                             om-props]
                                            (route {:key       "route-tab1_1"
                                                    :name      "tab1_1"
                                                    :component TabView
                                                    :title     "Tab #1_1"})))
                             (route {:key    "route-tab2"
                                     :name   "tab2"
                                     :schema "tab"
                                     :title  "Tab #2"
                                     :hideNavBar true}
                                    (router [{:key   "router-tab2"
                                              :onPop #(do (.log js/console "onPop is called!")
                                                          true)}
                                             om-props]
                                            (route {:key       "route-tab2_1"
                                                    :name      "tab1_1"
                                                    :component TabView
                                                    :title     "Tab #2_1"})
                                            (route {:key "route-tab2_2"
                                                    :name "tab2_2"
                                                    :component TabView
                                                    :title "Tab #2_2"})))
                             (route {:key "route-tab3"
                                     :name "tab3"
                                     :schema "tab"
                                     :title "Tab #3"
                                     :component TabView
                                     :hideTabBar true})
                             (route {:key "route-tab4"
                                     :name "tab4"
                                     :schema "tab"
                                     :title "Tab #4"
                                     :component TabView})
                             (route {:key "route-tab5"
                                     :name "tab5"
                                     :schema "tab"
                                     :title "Tab #5"
                                     :component TabView})
                             ))

              (route {:key        "route-launch"
                      :name       "launch"
                      :title      "Launch"
                      :component  Launch
                      :header     Header
                      :wrapRouter true
                      :hideNavBar true
                      :initial    true})

              ))))



(def app-registry (.-AppRegistry js/React))
(def logo-img (js/require "./images/cljs.png"))

(defui AppRoot
  static om/IQuery
  (query [this]
    '[:app/msg])
  Object
  (render [this]
    (let [{:keys [app/msg]} (om/props this)]
      (view {:style {:flexDirection "column" :margin 40 :alignItems "center"}}
            (text {:style {:fontSize 30 :fontWeight "100" :marginBottom 20 :textAlign "center"}} msg)
            (image {:source logo-img
                    :style  {:width 80 :height 80 :marginBottom 30}})
            (touchable-highlight {:style   {:backgroundColor "#999" :padding 10 :borderRadius 5}
                                  :onPress #(alert "HELLO!")}
                                 (text {:style {:color "white" :textAlign "center" :fontWeight "bold"}} "press me"))))))

(defonce RootNode (sup/root-node! 1))
(defonce app-root (om/factory Example))

(defn init []
  (om/add-root! state/reconciler Example 1)
  (.registerComponent app-registry "OmNextReactNativeRouterFlux" (fn [] app-root)))