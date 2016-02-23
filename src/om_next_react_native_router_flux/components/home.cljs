(ns om-next-react-native-router-flux.components.home
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require
    [om-next-react-native-router-flux.react-requires :refer [Actions Navigator ReactNativeModalbox TabBar]] ;; IMPORTANT!  Must be required first
    [om-next-react-native-router-flux.react-helpers :refer [button]] ;; IMPORTANT!  Must be required second
    [om.next :as om :refer-macros [defui]]))

(defui Home
  Object
  (render [this]
    (view {:style {:flex            1
                   :justifyContent  "center"
                   :alignItems      "center"
                   :backgroundColor "#F5FCFF"}}
          (text {} "Replace Screen")
          (button {:onPress #(.pop Actions)} "Back"))))
