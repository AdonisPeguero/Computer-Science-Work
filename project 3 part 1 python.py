
# Factorial of a number
def main():
	n=int(raw_input("Enter a non-negative integer: " ))
	
	def factorial(n):
		if n<0:
			return "Wrong value, Enter a integer" # checking input
		else: 
			if n==0: #base case
				return 1
			else:
				return n*factorial(n-1) #recursive call
		
	print ("Factorial of", n, "is", factorial(n))
	#Return the factorial for the specified number
	
	n=int(raw_input("Press enter to quit: "))
	
if __name__ == '__main__':
        main()
