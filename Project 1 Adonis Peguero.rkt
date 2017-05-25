#lang racket
;Adonis Peguero
;Programming Languages

; Function 1 (make-seq-list)

(define (make-seq-List x y)
  (if (>= x y) (if (= x y)
                   (cons y empty) #f)
      (cons x (make-seq-List (+ x 1) y))))

;------------------------------------------

; Function 2 (make-whole-list)

(define (make-whole-list x)
  (rest (build-list (+ 1 x) values)))

;------------------------------------------

; Function 3 (list-length)

(define (list-length lst)
  (cond
   [(empty? lst) 0]
   [else (+ 1 (list-length (rest lst)))]))

;------------------------------------------

; Function 4 (concat-list)

(define (conc-list np pn)
  (if (null? np)
      pn
      (cons (car np) (conc-list (cdr np) pn))))

;------------------------------------------

;Function 5 (Merge)

(define (merge np pn)
  (cond
    [(null? np) pn]
    
    [(null? pn) np]
    
    [(< (car np) (car pn))
    
     (cons (car np) (merge (cdr np) pn))]
    
    [#t 
     (cons (car pn) (merge np (cdr pn)))]))