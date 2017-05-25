.ORIG x3000
DESCRIP .STRINGZ "This program calculates the are of a rectangle"
WARNING2 .STRINGZ "Please enter 1 digit numbers with a zero in the front Ex: 03"
LD R6,ASCII ; char->digit template

;description
LEA R0, DESCRIP 
TRAP x22

LD  R0, NEWLN       ;Move to next line in the monitor
TRAP    x21

LEA R0, WARNING2
TRAP x22

LD  R0, NEWLN       ;Move to next line in the monitor
TRAP    x21
LD  R0, NEWLN       ;Move to next line in the monitokr
TRAP    x21




LEA R0, ASKL ; Ask user for length
TRAP x22
 
TRAP x20     ; get input from keyboard  
TRAP x21     ; print the input to the screen
ADD R1, R0, #0 ; store ascii value to R1
ADD R1, R1, R6 ; convert to number
AND R0, R0, #0 ; clear R0

TRAP x20     ; get input from keyboard  
TRAP x21     ; print the input to the screen
ADD R2, R0, #0 ; store ascii value to R1
ADD R2, R2, R6 ; convert to number


;Process for getting two digit numbers
; mult the first digti by 10 which is R1
AND R5,R5,#0
LD R5, TEN
AND R3, R3, #0 ; clear R3 to hold the result
;loop
AGAIN ADD R3, R3, R1
ADD R5, R5, #-1 ; keep track of iterations
BRp AGAIN
AND R1,R1,#0 
ADD R1, R3, R2 ; the the first number which was mult by 10 with the second input and store it in R1
AND R2, R2, #0 
AND R3, R3, #0   

ST R1, SAVER1

LD  R0, NEWLN       ;Move to next line in the monitokr
TRAP    x21



LEA R0, ASKW ; Ask user for width
TRAP x22
 
TRAP x20     ; get input from keyboard  
TRAP x21     ; print the input to the screen
ADD R1, R0, #0 ; store ascii value to R1
ADD R1, R1, R6 ; convert to number
AND R0, R0, #0 ; clear R0

TRAP x20     ; get input from keyboard  
TRAP x21     ; print the input to the screen
ADD R2, R0, #0 ; store ascii value to R1
ADD R2, R2, R6 ; convert to number


;Process for getting two digit numbers
; mult the first digti by 10 which is R1
AND R5,R5,#0
LD R5, TEN
AND R3, R3, #0 ; clear R3 to hold the result
;loop
AGAIN1 ADD R3, R3, R1
ADD R5, R5, #-1 ; keep track of iterations
BRp AGAIN1
AND R1,R1,#0 
ADD R1, R3, R2 ; the the first number which was mult by 10 with the second input and store it in R1
AND R2, R2, #0 
AND R3, R3, #0   

ST R1, SAVER2

LD R1, SAVER1
LD R2, SAVER2


;Mult Process
AND R3, R3, #0 ; clear R3 to hold the result
;loop
AGAIN2 ADD R3, R3, R2
ADD R1, R1, #-1 ; keep track of iterations
BRp AGAIN2
AND R1,R1,#0



LD  R0, NEWLN       ;Move to next line in the monitor
TRAP    x21


AND R0, R0, #0 ;clear R0 to hold the result
ADD R0, R0, R3
AND R2, R2, #0 ;clear R2 to hold the result
AND R1, R1, #0 ;clear R1 to hold the result
AND R3, R3, #0 ;clear R3 to hold the result



;print in ascii 
BinarytoASCII LEA R1,ASCIIBUFF ; R1 points to string being generated
 ADD R0,R0,#0 ; R0 contains the binary value
 BRn NegSign ;
 LD R2,ASCIIplus ; First store the ASCII plus sign
 STR R2,R1,#0
 BRnzp Begin100
NegSign LD R2,ASCIIminus ; First store ASCII minus sign
 STR R2,R1,#0
 NOT R0,R0 ; Convert the number to absolute
 ADD R0,R0,#1 ; value; it is easier to work with.
;
Begin100 LD R2,ASCIIoffset ; Prepare for "hundreds" digit
;
 LD R3,Neg100 ; Determine the hundreds digit
Loop100 ADD R0,R0,R3
 BRn End100
 ADD R2,R2,#1
 BRnzp Loop100
;
End100 STR R2,R1,#1 ; Store ASCII code for hundreds digit
 LD R3,Pos100
 ADD R0,R0,R3 ; Correct R0 for one-too-many subtracts
;
LD R2,ASCIIoffset ; Prepare for "tens" digit
;
Begin10 LD R3,Neg10 ; Determine the tens digit
Loop10 ADD R0,R0,R3
BRn End10
ADD R2,R2,#1
BRnzp Loop10
;
End10 STR R2,R1,#2 ; Store ASCII code for tens digit
 ADD R0,R0,#10 ; Correct R0 for one-too-many subtracts
Begin1 LD R2,ASCIIoffset ; Prepare for "ones" digit
ADD R2,R2,R0
STR R2,R1,#3



AND R5,R5,#0
ADD R5,R5,R0
LEA R0, FINISH ; Show the results 
TRAP x22 
AND R0,R0,#0
ADD R0,R0,R5
LEA R0, ASCIIBUFF  
TRAP x22



HALT

ASKL .STRINGZ "Please enter the length:"
ASKW .STRINGZ "Please enter the width:"
FINISH .STRINGZ "The area of the object is:"
;DESCRIP .STRINGZ "This program calculates the are of a rectangle, Please enter one digit numbers a zero in the front"
;WARNING2 .STRINGZ "Please enter one digit numbers a zero in the front"
NEWLN .FILL   x000A
ASCII .FILL xFFD0
ASCII_1 .FILL x0031 ; ASCII char '1'
TEN .FILL x000A
SAVER1 .FILL x0000
SAVER2 .FILL x0000

Neg10 .FILL xFFF6
ASCIIplus .FILL x002B
ASCIIminus .FILL x002D
ASCIIoffset .FILL x0030
Neg100 .FILL xFF9C
Pos100 .FILL x0064

ASCIIBUFF .BLKW 10

.END





