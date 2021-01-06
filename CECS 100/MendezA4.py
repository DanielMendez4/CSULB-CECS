#This program simulates counting from 1 to a number specified by the user
#Number needs to be >= 10 and <= 20

again = "y"
while again == "y" or again == "Y":
    str_n = input("Enter a number in the range of 10 to 20: ")
    n = int(str_n)
    if int(str_n) < 10 or int(str_n) > 20:
        print("Error! Please enter a number in the range of 10 to 20!")
            
    if int(str_n) >= 10 and int(str_n) <= 20:
        a = 1
        while a <= n:
            print(a, end =" ")
            a = a+1
            
    again = input("Try again? (y = yes): ")
