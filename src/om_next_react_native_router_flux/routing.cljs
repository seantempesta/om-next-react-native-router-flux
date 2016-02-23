(ns om-next-react-native-router-flux.routing
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require
    [om-next-react-native-router-flux.react-requires :refer [Actions Navigator ReactNativeModalbox TabBar]]
    [om-next-react-native-router-flux.react-helpers :refer [router route schema]]
    [om-next-react-native-router-flux.components.home :refer [Home]]
    [om-next-react-native-router-flux.components.launch :refer [Launch]]
    [om-next-react-native-router-flux.components.login :refer [Login Login2]]
    [om-next-react-native-router-flux.components.register :refer [Register]]
    [om-next-react-native-router-flux.components.tab-view :refer [TabView TabIcon]]
    [om-next-react-native-router-flux.components.modalbox :refer [Modalbox]]
    [om.next :as om :refer-macros [defui]]))

(defui Header
       Object
       (render [this]
               (text {} "Header")))

(defui Routing
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
                                 :component Modalbox})
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