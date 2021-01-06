again = "y"
while again == "y" or again == "Y":
    str_n = input("Please enter a password: ")
    n = str_n
    if len(n) < 8:
        print("Error! Please enter a password greater than 8 characters!")
    if n.islower():
         print("Error! Please enter a password that is not all lowercase!")
    if n.isupper():
         print("Error! Please enter a password that is not all uppercase!")
    if n.isalpha():
        print("Error! Please enter a password that is not all letters!")
    if n.isdigit():
        print("Error! Please enter a password that is not all digits!")
    if " " in n:
        print("Error! Please enter a password containing no spaces!")
   
    if len(n) >= 8 and not n.islower() and not n.isupper() and not n.isalpha() and not n.isdigit() and not " " in n:
        print("Password is valid! Congratulations!")
              
    again = input("Try again? (y = yes): ")


    
