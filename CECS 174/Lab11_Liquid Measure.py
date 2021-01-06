#This program will calculate the total number of gallons, quarts, cups and ounces.
#From total number of ounces, program will determine how many gallons, quarts, cups and ounces can be extracted.
#Authors: Daniel Mendez & John Patrick Salcedo
class LiquidMeasure:
    
    def __init__(self, gallons, quarts, cups, ounces):
        self.gallons = gallons
        self.quarts = quarts
        self.cups = cups
        self.ounces = ounces
        #Checks if the type of the parameter is not an integer, which will result in a TypeError.
        if type(self.gallons) != int or type(self.quarts) != int or \
           type(self.cups) != int or type(self.ounces) != int:
            raise TypeError("Parameters must be integers!")
        else:
            #Calculates the total number of ounces
            total_ounces = (self.gallons*128) + (self.quarts*32) + (self.cups*8) + (self.ounces)
            #Calculates number of gallons from total ounces
            num_gallons = int(float(total_ounces / 128))
            #Calculates new total ounces after subtracting original total from ounces used by gallons
            total_ounces = total_ounces - (num_gallons*128)
            #Calculates number of quarts from remaining total ounces
            num_quarts = int(float(total_ounces / 32))
            #Calculates new total ounces after subtracting previous total from ounces used by quarts
            total_ounces = total_ounces - (num_quarts*32)
            #Calculates number of cups from remaining total ounces
            num_cups = int(float(total_ounces / 8))
            #Calculates new total ounces after subtracting previous total from ounces used by cups
            total_ounces = total_ounces - (num_cups*8)
            #Gives new values to self.gallons/quarts/cups/ounces
            self.gallons = num_gallons
            self.quarts = num_quarts
            self.cups = num_cups
            self.ounces = total_ounces

    def __str__(self):
        return ("{} gallons, {} quarts, {} cups, {} ounces".format(self.gallons,self.quarts,self.cups,self.ounces))
