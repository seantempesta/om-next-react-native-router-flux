(ns om-next-react-native-router-flux.components.tab-view
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

(defui TabIcon
  Object
  (render [this]
    (let [all-props (om/props this)
          title "TITLE!"
          selected true]
      (text {:style {:color (if selected "red" "black")}} title))))

(defui TabView
       Object
       (render [this]
               (let [title "TITLE!"]
                 (view {:style (:container styles)}
                       (text {} (str "Tab " title))
                       (button {:onPress #(.pop Actions)} "Back")
                       (button {:onPress #(.tab1 Actions)} "Switch to tab1")))))

(defui TabView2
       Object
       (render [this]
               (let [name "1"]
                 (view {:style (:container styles)}
                       (text {} (str "Tab " name))))))
