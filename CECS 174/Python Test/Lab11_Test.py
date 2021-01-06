class LiquidMeasure:
    
    def __init__(self, gallons, quarts, cups, ounces):
        self.gallons = gallons
        self.quarts = quarts
        self.cups = cups
        self.ounces = ounces
        if type(self.gallons) != int or type(self.quarts) != int or \
           type(self.cups) != int or type(self.ounces) != int:
            raise TypeError("Parameters must be integers!")
        else:
            self.gallons = abs(gallons)
            self.quarts = abs(quarts)
            self.cups = abs(cups)
            self.ounces = abs(ounces)
            total_ounces = (self.gallons*128) + (self.quarts*32) + (self.cups*8) + (self.ounces)
            if self.gallons == 0:
                num_gallons = total_ounces // 128
            else:   
                num_gallons = total_ounces // 128
            total_ounces = total_ounces - (num_gallons*128)
            if self.quarts == 0:
                num_quarts = total_ounces // 32
            else:
                num_quarts = total_ounces // (self.quarts*32)
            total_ounces = total_ounces - (num_quarts*32)
            if self.cups == 0:
                num_cups = total_ounces // 8
            else:
                num_cups = total_ounces // (self.cups*8)
            total_ounces = total_ounces - (num_cups*8)

            self.gallons = num_gallons
            self.quarts = num_quarts
            self.cups = num_cups
            self.ounces = total_ounces

    def __str__(self):
        return ("{} gallons, {} quarts, {} cups, {} ounces".format(self.gallons,self.quarts,self.cups,self.ounces))
            
