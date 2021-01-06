#This program prompts the user to enter a password.

again = "y"
while again == "y" or again == "Y":
    str_n = input("Please enter a password: ")
    n = str_n
    if len(n) < 8:  #Checks the length of the password.
        print("Error! Please enter a password greater or equal to 8 characters!")
        
    if n.islower(): #Checks if password is all lowercase.
         print("Error! Please enter a password that is not all lowercase!")
         
    if n.isupper(): #Checks if password is all uppercase.
         print("Error! Please enter a password that is not all uppercase!")
         
    if n.isalpha(): #Checks if password is only letters.
        print("Error! Please enter a password that is not all letters!")
        
    if n.isdigit(): #Checks if password is only digits.
        print("Error! Please enter a password that is not all digits!")
        
    if " " in n:    #Checks if there are spaces in the password.
        print("Error! Please enter a password containing no spaces!")

        #If password does not satisfy the following conditions, user is prompted to try again.
   
    if len(n) >= 8 and not n.islower() and not n.isupper() and not n.isalpha() and not n.isdigit() and not " " in n:
        print("Password is valid!")

        #If password satisfies the following conditions, then it is valid and user is prompted to try again.
              
    again = input("Try again? (y = yes): ")


    
