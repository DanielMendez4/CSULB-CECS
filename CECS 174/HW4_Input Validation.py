#This program will test user input between a range
#Authors: Daniel Mendez & John Patrick Salcedo
def CheckNum(prompt,low,high):
    """Prompts the user for an integer or a floating point value until they supply you with a value between
       low and high (inclusive).
       a. prompt – A text string to tell the user what they are entering. The prompt should be relatively short.
       b. low – The lowest value that can be entered.  This must be lower than the high input parameter.
       c. high – The highest value that the user can enter.  This must be higher than the low input.
       d. Return value – The value which the user entered.
       e. Exception – Raise the ValueError exception if the low input parameter is >= the high input parameter.
       f. Your CheckNum function should be able to work for integer or floating point inputs. If the low input
       parameter is an integer, then assume that the user only enters integers.  
       If the low input parameter is a float, then assume that the user only enters floating-point numbers."""
    types = {int: CheckPosInt, float: CheckPosFloat}
    if type(high) in types:
        if type(low) == type(high):
            value = types[type(high)](input(prompt))
            while value < low or value > high:
                print("Error, value is outside of range!")
                value = types[type(high)](input(prompt))
            return value

def CheckPosInt(high):
    """Prompts the user for a positive integer until they provide a value that is both an integer and <= high.
       a. prompt – Just like CheckNum
       b. high – Just like CheckNum
       c. Return – The value that the user entered.
       d. Exception – Raise the ValueError if the high input is < 0."""
    if int(high) < 0:
        raise ValueError("Error, high is less than zero!")
    return int(high)
    

def CheckPosFloat(high):
    """Prompts the user for a positive floating-point value until they provide a value that is > 0 and < than high.
       a. prompt – Just like CheckNum
       b. high– Just like CheckNum
       c. Return – The value that the user entered.
       d. Exception – Raise the ValueError if the high input is < 0."""
    if float(high) < 0:
        raise ValueError("Error, high is less than zero!")
    return float(high)
