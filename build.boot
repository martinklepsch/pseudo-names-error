(set-env!
 :source-paths    #{"src/cljs"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs      "0.0-2629-8" :scope "test"]
                 [adzerk/boot-reload    "0.2.4"      :scope "test"]
                 [reagent "0.4.3"]
                 [cljsjs/react "0.12.2-3"]
                 [cljsjs/boot-cljsjs "0.4.1"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-reload    :refer [reload]]
 '[cljsjs.boot-cljsjs :refer [from-cljsjs]])
