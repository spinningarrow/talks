;; vim: set nohlsearch nonumber norelativenumber:

; ┏━┓╻ ╻┏━╸╻  ╻     ┏━┓┏━╸┏━┓╻┏━┓╺┳╸╻┏┓╻┏━╸
; ┗━┓┣━┫┣╸ ┃  ┃     ┗━┓┃  ┣┳┛┃┣━┛ ┃ ┃┃┗┫┃╺┓
; ┗━┛╹ ╹┗━╸┗━╸┗━╸   ┗━┛┗━╸╹┗╸╹╹   ╹ ╹╹ ╹┗━┛
;
;                  in
;
;   ┏━╸╻  ┏━┓ ┏┓╻ ╻┏━┓┏━╸┏━┓┏━╸┏━┓╻┏━┓╺┳╸
;   ┃  ┃  ┃ ┃  ┃┃ ┃┣┳┛┣╸ ┗━┓┃  ┣┳┛┃┣━┛ ┃
;   ┗━╸┗━╸┗━┛┗━┛┗━┛╹┗╸┗━╸┗━┛┗━╸╹┗╸╹╹   ╹
;
;                 using
;
;            ┏━┓╻  ┏━┓┏┓╻┏━╸╻┏
;            ┣━┛┃  ┣━┫┃┗┫┃  ┣┻┓
;            ╹  ┗━╸╹ ╹╹ ╹┗━╸╹ ╹
;






















; ┏━┓╻  ┏━┓┏┓╻┏━╸╻┏ ┏━┓
; ┣━┛┃  ┣━┫┃┗┫┃  ┣┻┓ ╺┛
; ╹  ┗━╸╹ ╹╹ ╹┗━╸╹ ╹ ╹
;
; http://planck-repl.org/





























; ┏━┓╻ ╻
; ┗━┓┣━┫
; ┗━┛╹ ╹
; Invoking external shell tools

(require '[planck.shell :refer [sh]])

(sh "echo" "hello")

;; NOTE: separate strings for command and arguments
(sh "ls" "-a" "-l")
















; ┏━┓┏━┓┏━╸╻ ╻┏┳┓┏━╸┏┓╻╺┳╸┏━┓
; ┣━┫┣┳┛┃╺┓┃ ┃┃┃┃┣╸ ┃┗┫ ┃ ┗━┓
; ╹ ╹╹┗╸┗━┛┗━┛╹ ╹┗━╸╹ ╹ ╹ ┗━┛
; command line arguments


(pr *command-line-args*)

;; ./args.cljs

























; ┏━╸╻╻  ┏━╸┏━┓
; ┣╸ ┃┃  ┣╸ ┗━┓
; ╹  ╹┗━╸┗━╸┗━┛
; reading and writing files

(require '[planck.core :refer [slurp spit]])

(slurp "./tom-sawyer.txt")

(spit "./math.txt" (+ 1 2 3 4 5))


























; ╻ ╻┏━┓╻┏━┓╻
; ┃ ┃┣┳┛┃┗━┓╹
; ┗━┛╹┗╸╹┗━┛╹

(require '[planck.core :refer [slurp]])

(slurp "http://www.songsterr.com/a/ra/songs.json?pattern=tom+sawyer")































; ┏━┓╺┳╸╺┳┓╻┏┓╻
; ┗━┓ ┃  ┃┃┃┃┗┫
; ┗━┛ ╹ ╺┻┛╹╹ ╹

(require '[planck.core :refer [*in* slurp]])

(pr (slurp *in*))

;; ./stdin.cljs
























;  ┏┓┏━┓┏━┓┏┓╻
;   ┃┗━┓┃ ┃┃┗┫
; ┗━┛┗━┛┗━┛╹ ╹

(require '[planck.core :refer [slurp]])
(def data (slurp "http://www.songsterr.com/a/ra/songs.json?pattern=tom+sawyer"))

;; parse
(.parse js/JSON data)

;; js->clj
(js->clj (.parse js/JSON data))

(js->clj (.parse js/JSON data) :keywordize-keys true)





































;  ┏┓┏━┓┏━┓┏┓╻
;   ┃┗━┓┃ ┃┃┗┫
; ┗━┛┗━┛┗━┛╹ ╹

;; stringify and clj->js
(clj->js {:a 1 :b 2})

(.stringify js/JSON (clj->js {:a 1 :b 2}))

(.stringify js/JSON {:a 1 :b 2})

;; shorthand
(JSON.parse data)

(JSON.stringify #js {:a 1 :b 2})


































; ╻╻┏━┓╻┏━┓╻┏┓╻┏━╸╻╻   ╺┳┓┏━┓╺┳╸┏━┓
;   ┣━┛┃┣━┛┃┃┗┫┃╺┓      ┃┃┣━┫ ┃ ┣━┫
;   ╹  ╹╹  ╹╹ ╹┗━┛     ╺┻┛╹ ╹ ╹ ╹ ╹


(js->clj
  (JSON.parse (slurp "http://www.songsterr.com/a/ra/songs.json?pattern=tom+sawyer"))
  :keywordize-keys true)

;; -> and ->>

(-> "http://www.songsterr.com/a/ra/songs.json?pattern=tom+sawyer"
    slurp
    JSON.parse
    (js->clj :keywordize-keys true))






























; ┏━╸╻ ╻┏━┓┏┳┓┏━┓╻  ┏━╸   ┏━┓┏━╸┏━┓╻┏━┓╺┳╸
; ┣╸ ┏╋┛┣━┫┃┃┃┣━┛┃  ┣╸    ┗━┓┃  ┣┳┛┃┣━┛ ┃
; ┗━╸╹ ╹╹ ╹╹ ╹╹  ┗━╸┗━╸   ┗━┛┗━╸╹┗╸╹╹   ╹

;; ./example.cljs
































; ┏┳┓┏━┓┏━┓┏━╸
; ┃┃┃┃ ┃┣┳┛┣╸
; ╹ ╹┗━┛╹┗╸┗━╸

;; Planck User Guide: http://planck-repl.org/guide.html

;; Lumo (CLJS on NodeJS): https://github.com/anmonteiro/lumo

;; Closh (Clojure bash-like shell): https://github.com/dundalek/closh




















































; ╺┳╸╻ ╻┏━┓┏┓╻╻┏ ┏━┓
;  ┃ ┣━┫┣━┫┃┗┫┣┻┓┗━┓
;  ╹ ╹ ╹╹ ╹╹ ╹╹ ╹┗━┛














