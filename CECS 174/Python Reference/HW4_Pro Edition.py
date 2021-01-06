# Example Type enforcement
def integer(string):
    """Returns the integer version of a string input. This is normally done
       by using the str function. But that is actually a method call, so we
       cannot treat it like a typical function. So we wrote a wrapper for it.
       Arguments:
       string: The string that needs converting to an integer.
       Return: The integer equivalent.
       Note: There is no recovery if the user enters something not an integer."""
    return int(string)
def floatingPoint(string):
    """Returns the float version of a string input. This is normally done
       by using the float function. But that is actually a method call, so we
       cannot treat it like a typical function. So we wrote a wrapper for it.
       Arguments:
       string: The string that needs converting to an floating point.
       Return: The floating point equivalent.
       Note: There is no recovery if the user enters something not an integer."""
    return float(string)
def Boolean(string):
    if string == 'True':
        return True
    else:
        return False
def getInRange (low, high, prompt):
    """Prompt the user for a value between low and high, respecting the
       type of both of the input boundaries.
       Arguments:
       low: The lower bound of the range.
       high: The upper bound of the range.
       prompt: The text prompt to tell the user what they are entering.
       Returns: The entered value."""
    # Create a dictionary that maps from a type to a conversion function.
    types = {int: integer, float: floatingPoint, bool: Boolean}
    # Make sure that the low value is of one of our accepted types.
    if type(low) in types:              # see if it's a valid type
        if type(low) == type(high):	# Make sure low type == high type
            # prompt for the value and convert it using the proper function.
            value = types[type(low)](input(prompt))
            # loop until the user gives us a valid value.
            while value < low or value > high:
                print ('Error, value is outside of range. Reenter.')
                value = types[type(low)](input(prompt))
            return value
        else:				# Type mismatch
            raise TypeError('Error, the type of high != type of low')
    else:				# Invalid type
        raise TypeError('Error, low is an invalid type')
                
