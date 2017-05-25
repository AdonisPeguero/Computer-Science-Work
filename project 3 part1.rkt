#lang racket
(define factorial
  (lambda (n)
    (cond
     ((= n 0) 1)
     ((= n 1) 1)
     (else (* n (factorial (- n 1)))))))

(define factorial*
  (lambda (n)
    (cond
      ((null? (cdr n)) (factorial (car n)))
      (else
       (cons (factorial (car n)) (factorial* (cdr n)))))))
