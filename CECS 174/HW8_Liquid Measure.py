#This program will calculate the total number of gallons, quarts, cups and ounces.
#From total number of ounces, program will determine how many gallons, quarts, cups and ounces can be extracted.
#Authors: Daniel Mendez & John Patrick Salcedo
class LiquidMeasure:
    
    def __init__(self, gallons, quarts, cups, ounces):
        gallons_to_ounces = 128
        quarts_to_ounces = 32
        cups_to_ounces = 8
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
            total_gallons = int(float(total_ounces / gallons_to_ounces))
            #Calculates new total ounces after subtracting original total from ounces used by gallons
            total_ounces = total_ounces - (total_gallons * gallons_to_ounces)
            #Calculates number of quarts from remaining total ounces
            total_quarts = int(float(total_ounces / quarts_to_ounces))
            #Calculates new total ounces after subtracting previous total from ounces used by quarts
            total_ounces = total_ounces - (total_quarts * quarts_to_ounces)
            #Calculates number of cups from remaining total ounces
            total_cups = int(float(total_ounces / cups_to_ounces))
            #Calculates new total ounces after subtracting previous total from ounces used by cups
            total_ounces = total_ounces - (total_cups * cups_to_ounces)
            #Gives new values to self.gallons/quarts/cups/ounces
            self.gallons = total_gallons
            self.quarts = total_quarts
            self.cups = total_cups
            self.ounces = total_ounces

    def __add__(self, other):
        if type(other) == str:
            raise TypeError("Right hand opperand must be another instance of LiquidMeasure or integer!")
        if type(other) == int:
            total_gallons = self.gallons
            total_quarts = self.quarts 
            total_cups = self.cups 
            total_ounces = self.ounces + other
        else:
            total_gallons = self.gallons + other.gallons
            total_quarts = self.quarts + other.quarts
            total_cups = self.cups + other.cups
            total_ounces = self.ounces + other.ounces
        return LiquidMeasure(total_gallons, total_quarts, total_cups, total_ounces)
    
    def __sub__(self, other):
        total_gallons = self.gallons - other.gallons
        total_quarts = self.quarts - other.quarts
        total_cups = self.cups - other.cups
        total_ounces = self.ounces - other.ounces
        return LiquidMeasure(total_gallons, total_quarts, total_cups, total_ounces)
    
    def __lt__(self, other):
        self_ounces = (self.gallons*128) + (self.quarts*32) + (self.cups*8) + (self.ounces)
        other_ounces = (other.gallons*128) + (other.quarts*32) + (other.cups*8) + (other.ounces)
        if self_ounces < other_ounces:
            return True
        else:
            return False
        
    def __gt__(self, other):
        self_ounces = (self.gallons*128) + (self.quarts*32) + (self.cups*8) + (self.ounces)
        other_ounces = (other.gallons*128) + (other.quarts*32) + (other.cups*8) + (other.ounces)
        if self_ounces > other_ounces:
            return True
        else:
            return False
    
    def __eq__(self, other):
        self_ounces = (self.gallons*128) + (self.quarts*32) + (self.cups*8) + (self.ounces)
        other_ounces = (other.gallons*128) + (other.quarts*32) + (other.cups*8) + (other.ounces)
        if self_ounces == other_ounces:
            return True
        else:
            return False
    
    def __mul__(self, other):
        if type(other) != int:
            raise TypeError("Right hand opperand needs to be an integer!")
        else:
            total_gallons = self.gallons * other
            total_quarts = self.quarts * other
            total_cups = self.cups * other
            total_ounces = self.ounces * other
        return LiquidMeasure(total_gallons, total_quarts, total_cups, total_ounces)

    def __str__(self):
        return ("{} gallons, {} quarts, {} cups, {} ounces".format(self.gallons,self.quarts,self.cups,self.ounces))
