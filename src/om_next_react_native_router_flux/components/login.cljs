(ns om-next-react-native-router-flux.components.login
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require
    [om-next-react-native-router-flux.react-requires :refer [Actions Navigator ReactNativeModalbox TabBar]]
    [om-next-react-native-router-flux.react-helpers :refer [button]]
    [om.next :as om :refer-macros [defui]]))


(def styles {:container {:flex            1
                         :justifyContent  "center"
                         :alignItems      "center"
                         :backgroundColor "#F5FCFF"}})
(defui Login
       Object
       (render [this]
               (let [all-props (om/props this)
                     data "FIXME"]
                 (view {:style (:container styles)}
                       (text {} (str "Login page " data))
                       (button {:onPress #(.loginModal2 Actions)} "Login 2")
                       (button {:onPress #(.pop Actions)} "Back")))))

(defui Login2
  Object
  (render [this]
    (let [data "FIXME"]
      (view {:style (:container styles)}
            (text {} (str "Login2 page: " data))
            (button {:onPress #(.pop Actions)} "Back")))))