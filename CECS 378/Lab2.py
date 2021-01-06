"""Displays a simple menu with options for the user"""
def menu():
    print("What would you like to edit?\n" +
          "1. Player\n" +
          "2. Shamino\n" +
          "3. Iolo\n" +
          "4. Mariah\n" +
          "5. Geoffrey\n" +
          "6. Jaana\n" +
          "7. Julia\n" +
          "8. Dupre\n" +
          "9. Katrina\n" +
          "10. Sentri\n" +
          "11. Gwenno\n" +
          "12. Johne\n" +
          "13. Gorn\n" +
          "14. Maxwell\n" +
          "15. Toshi\n" +
          "16. Saduj\n" +
          "17. Equipment\n" +
          "18. Party Size")

"""
Edits the stats of one character
player - the character to be edited
hexList - representation of the binary file in hex form as a list
"""
def edit_stats(player, hexList):
    print("\nEditing {}'s stats...".format(player))
    ##################################################################
    Str = list(hex(int(input("Str (Enter a value b/t 1-99): "))))[2:]
    if (len(Str) % 2 != 0):
        Str.insert(0,"0")
    ##################################################################
    Int = list(hex(int(input("Int (Enter a value b/t 1-99): "))))[2:]
    if (len(Int) % 2 != 0):
        Int.insert(0,"0")
    ##################################################################
    Dex = list(hex(int(input("Dex (Enter a value b/t 1-99): "))))[2:]
    if (len(Dex) % 2 != 0):
        Dex.insert(0,"0")
    ##################################################################
    HP = list(hex(int(input("HP (Enter a value b/t 1-999): "))))[2:]
    if (len(HP) % 2 != 0):
        HP.insert(0,"0")
    if (len(HP) == 4):
        HP[0:2], HP[2:] = HP[2:], HP[0:2]
    if (len(HP) == 2):
        HP.append("0")
        HP.append("0")
    ##################################################################
    Max_HP = list(hex(int(input("Max HP (Enter a value b/t 1-999): "))))[2:]
    if (len(Max_HP) % 2 != 0):
        Max_HP.insert(0,"0")
    if (len(Max_HP) == 4):
        Max_HP[0:2], Max_HP[2:] = Max_HP[2:], Max_HP[0:2]
    if (len(Max_HP) == 2):
        Max_HP.append("0")
        Max_HP.append("0")
    ##################################################################
    Exp = list(hex(int(input("Exp (Enter a value b/t 1-9999): "))))[2:]
    if (len(Exp) % 2 != 0):
        Exp.insert(0,"0")
    if (len(Exp) == 4):
        Exp[0:2], Exp[2:] = Exp[2:], Exp[0:2]
    if (len(Exp) == 2):
        Exp.append("0")
        Exp.append("0")
    ##################################################################
    if player == "Player":
        hexList[28:30] = Str
        hexList[30:32] = Int
        hexList[32:34] = Dex
        hexList[36:40] = HP
        hexList[40:44] = Max_HP
        hexList[44:48] = Exp
    ##################################################################
    if player == "Shamino":
        hexList[92:94] = Str
        hexList[94:96] = Int
        hexList[96:98] = Dex
        hexList[100:104] = HP
        hexList[104:108] = Max_HP
        hexList[108:112] = Exp
        hexList[130:132] = "00"
    ##################################################################
    if player == "Iolo":
        hexList[156:158] = Str
        hexList[158:160] = Int
        hexList[160:162] = Dex
        hexList[164:168] = HP
        hexList[168:172] = Max_HP
        hexList[172:176] = Exp
        hexList[194:196] = "00"
    ##################################################################
    if player == "Mariah":
        hexList[220:222] = Str
        hexList[222:224] = Int
        hexList[224:226] = Dex
        hexList[228:232] = HP
        hexList[232:236] = Max_HP
        hexList[236:240] = Exp
        hexList[258:260] = "00"
    ##################################################################
    if player == "Geoffrey":
        hexList[284:286] = Str
        hexList[286:288] = Int
        hexList[288:290] = Dex
        hexList[292:296] = HP
        hexList[296:300] = Max_HP
        hexList[300:304] = Exp
        hexList[322:324] = "00"
    ##################################################################
    if player == "Jaana":
        hexList[348:350] = Str
        hexList[350:352] = Int
        hexList[352:354] = Dex
        hexList[356:360] = HP
        hexList[360:364] = Max_HP
        hexList[364:368] = Exp
        hexList[386:388] = "00"
    ##################################################################
    if player == "Julia":
        hexList[412:414] = Str
        hexList[414:416] = Int
        hexList[416:418] = Dex
        hexList[420:424] = HP
        hexList[424:428] = Max_HP
        hexList[428:432] = Exp
        hexList[450:452] = "00"
    ##################################################################
    if player == "Dupre":
        hexList[476:478] = Str
        hexList[478:480] = Int
        hexList[480:482] = Dex
        hexList[484:488] = HP
        hexList[488:492] = Max_HP
        hexList[492:496] = Exp
        hexList[514:516] = "00"
    ##################################################################
    if player == "Katrina":
        hexList[540:542] = Str
        hexList[542:544] = Int
        hexList[544:546] = Dex
        hexList[548:552] = HP
        hexList[552:556] = Max_HP
        hexList[556:560] = Exp
        hexList[578:580] = "00"
    ##################################################################
    if player == "Sentri":
        hexList[604:606] = Str
        hexList[606:608] = Int
        hexList[608:610] = Dex
        hexList[612:616] = HP
        hexList[616:620] = Max_HP
        hexList[620:624] = Exp
        hexList[642:644] = "00"
    ##################################################################
    if player == "Gwenno":
        hexList[668:670] = Str
        hexList[670:672] = Int
        hexList[672:674] = Dex
        hexList[676:680] = HP
        hexList[680:684] = Max_HP
        hexList[684:688] = Exp
        hexList[706:708] = "00"
    ##################################################################
    if player == "Johne":
        hexList[732:734] = Str
        hexList[734:736] = Int
        hexList[736:738] = Dex
        hexList[740:744] = HP
        hexList[744:748] = Max_HP
        hexList[748:752] = Exp
        hexList[770:772] = "00"
    ##################################################################
    if player == "Gorn":
        hexList[796:798] = Str
        hexList[798:800] = Int
        hexList[800:802] = Dex
        hexList[804:808] = HP
        hexList[808:812] = Max_HP
        hexList[812:816] = Exp
        hexList[834:836] = "00"
    ##################################################################
    if player == "Maxwell":
        hexList[860:862] = Str
        hexList[862:864] = Int
        hexList[864:866] = Dex
        hexList[868:872] = HP
        hexList[872:876] = Max_HP
        hexList[876:880] = Exp
        hexList[898:900] = "00"
    ##################################################################
    if player == "Toshi":
        hexList[924:926] = Str
        hexList[926:928] = Int
        hexList[928:930] = Dex
        hexList[932:936] = HP
        hexList[936:940] = Max_HP
        hexList[940:944] = Exp
        hexList[962:964] = "00"
    ##################################################################
    if player == "Saduj":
        hexList[988:990] = Str
        hexList[990:992] = Int
        hexList[992:994] = Dex
        hexList[996:1000] = HP
        hexList[1000:1004] = Max_HP
        hexList[1004:1008] = Exp
        hexList[1026:1028] = "00"
    ##################################################################
    print("{}'s stats have been edited!\n".format(player))

"""
Edits the equipment of the party
hexList - representation of the binary file in hex form as a list
"""
def edit_equipment(hexList):
    print("\nEditing equipment...")
    ##################################################################
    Gold = list(hex(int(input("Gold (Enter value b/t 0-9999): "))))[2:]
    if (len(Gold) % 2 != 0):
        Gold.insert(0,"0")
    if (len(Gold) == 4):
        Gold[0:2], Gold[2:] = Gold[2:], Gold[0:2]
    if (len(Gold) == 2):
        Gold.append("0")
        Gold.append("0")
    ##################################################################
    Key = list(hex(int(input("Key (Enter value b/t 0-100): "))))[2:]
    if (len(Key) % 2 != 0):
        Key.insert(0,"0")
    ##################################################################
    Gem = list(hex(int(input("Gem (Enter value b/t 0-100): "))))[2:]
    if (len(Gem) % 2 != 0):
        Gem.insert(0,"0")
    ##################################################################
    Magic_Carpet = list(hex(int(input("Magic Carpet (Enter value b/t 0-100): "))))[2:]
    if (len(Magic_Carpet) % 2 != 0):
        Magic_Carpet.insert(0,"0")
    ##################################################################
    Skull_Key = list(hex(int(input("Skull Key (Enter value b/t 0-100): "))))[2:]
    if (len(Skull_Key) % 2 != 0):
        Skull_Key.insert(0,"0")
    ##################################################################
    Black_Badge = int(input("Black Badge (Enter value b/t 0-1): "))
    if Black_Badge == 0:
        Black_Badge = ["0", "0"]
    if Black_Badge == 1:
        Black_Badge = ["f", "f"]
    ##################################################################
    Magic_Axe = list(hex(int(input("Magic Axe (Enter value b/t 0-100): "))))[2:]
    if (len(Magic_Axe) % 2 != 0):
        Magic_Axe.insert(0,"0")
    ##################################################################
    hexList[1032:1036] = Gold
    hexList[1036:1038] = Key
    hexList[1038:1040] = Gem
    hexList[1044:1046] = Magic_Carpet
    hexList[1046:1048] = Skull_Key
    hexList[1072:1074] = Black_Badge
    hexList[1152:1154] = Magic_Axe
    ##################################################################
    print("Equipment has been edited!\n")

"""
Edits the size of the party
hexList - representation of the binary file in hex form as a list
"""
def edit_party_size(hexList):
    print("\nEditing party size...")
    ##################################################################
    Party_Size = list(hex(int(input("Party Size (Enter value b/t 1-6): "))))[2:]
    if (len(Party_Size) % 2 != 0):
        Party_Size.insert(0, "0")
    ##################################################################
    hexList[1386:1388] = Party_Size
    print("Party Size has been edited!\n")

###########################################################################
with open('C:/OLDGAMES/Ultima_5/SAVED.GAM', 'rb') as f:
    hexdata = f.read().hex()

#Converts hexdata into a list
hexList = list(hexdata)

menu()
option = int(input("Enter integer (1-18) or 0 to exit: "))
while(option != 0):
    if option == 1:
        edit_stats("Player", hexList)
    if option == 2:
        edit_stats("Shamino", hexList)
    if option == 3:
        edit_stats("Iolo", hexList)
    if option == 4:
        edit_stats("Mariah", hexList)
    if option == 5:
        edit_stats("Geoffrey", hexList)
    if option == 6:
        edit_stats("Jaana", hexList)
    if option == 7:
        edit_stats("Julia", hexList)
    if option == 8:
        edit_stats("Dupre", hexList)
    if option == 9:
        edit_stats("Katrina", hexList)
    if option == 10:
        edit_stats("Sentri", hexList)
    if option == 11:
        edit_stats("Gwenno", hexList)
    if option == 12:
        edit_stats("Johne", hexList)
    if option == 13:
        edit_stats("Gorn", hexList)
    if option == 14:
        edit_stats("Maxwell", hexList)
    if option == 15:
        edit_stats("Toshi", hexList)
    if option == 16:
        edit_stats("Saduj", hexList)
    if option == 17:
        edit_equipment(hexList)
    if option == 18:
        edit_party_size(hexList)
    menu()
    option = int(input("Enter integer (1-18) or 0 to exit: "))

#Combines every 2 elements together to represent hex format
hexList = ["".join(x) for x in zip(hexList[0::2], hexList[1::2])]

#Converts every hex value to its decimal value
decList = []
for i in range(len(hexList)):
    decList.append(int(hexList[i], 16))

#Converts every decimal value to its binary value
binary_format = bytearray(decList)
with open('C:/OLDGAMES/Ultima_5/SAVED.GAM', 'w+b') as f:
    f.write(binary_format)

print("Relaunch game to see changes!")
###########################################################################
