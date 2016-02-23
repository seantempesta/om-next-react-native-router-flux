(ns om-next-react-native-router-flux.components.launch
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

(defui Launch
       Object
       (render [this]
               (view {:style (:container styles)}
                     (text {} "Launch page")
                     (button {:onPress #(.login Actions (clj->js {:data  "Custom data"
                                                                  :title "Custom title"}))} "Go to Login page")
                     (button {:onPress #(.register Actions)} "Go to Register page")
                     (button {:onPress #(.register2 Actions)} "Go to Register page without animation")
                     (button {:onPress #(.modalBox Actions)} "PopUp with ReactNativeModalBox")
                     (button {:onPress #(.tabbar Actions)} "Go to TabBar")
                     (button {:onPress #(.showActionSheet Actions (clj->js {:callback (fn [index]
                                                                                        (js/alert (str "Selected:" index))
                                                                                        true)}))} "Show ActionSheet")
                     )))
