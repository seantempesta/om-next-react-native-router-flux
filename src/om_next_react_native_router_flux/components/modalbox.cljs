(ns om-next-react-native-router-flux.components.modalbox
  (:require-macros [natal-shell.components :refer [view text image touchable-highlight]]
                   [natal-shell.alert :refer [alert]])
  (:require
    [om-next-react-native-router-flux.react-requires :refer [Actions]] ;; IMPORTANT!  Must be required first
    [om-next-react-native-router-flux.react-helpers :refer [modal]] ;; IMPORTANT!  Must be required second
    [om.next :as om :refer-macros [defui]]))

(def styles {:modal {:justifyContent "center"
                     :alignItems     "center"
                     :height         300
                     :width          300}
             :text  {:color    "black"
                     :fontSize 22}})

(defui Modalbox
  Object
  (componentWillMount [this]
    (om/set-state! this {:isOpen true}))
  (render [this]
    (let [local-state (om.next/get-state this)
          isOpen (:isOpen local-state)]
      (modal {:style             (:modal styles)
              :animationDuration 200
              :swipeThreshold    100
              :position          "center"
              :isOpen            isOpen
              :onClosed          #(.dismiss Actions)}
             (text {:key "text-1"
                    :style (:text styles)} "ReactNativeModalBox")
             (text {:key "text-2"} "(swipe down to close")))))