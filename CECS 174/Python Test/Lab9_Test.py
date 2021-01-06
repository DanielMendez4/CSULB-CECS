#This program will make a substitution cipher to encrypt a string.
#Program will diplay the substitution cipher key, encrypted string, and decrypted string.
#Authors: Daniel Mendez & John Patrick Salcedo
import random

def encrypt(string,key):
    """This function will encrypt the string based on the key generated"""
    alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if len(key) != len(alphabet):
        raise ValueError("The length of the key is not equal to the length of alphabet!")
    encryptString = ""
    for letter in string:
        if letter in alphabet:
            encryptString += key[alphabet.index(letter)]
        else:
            encryptString += letter
    return encryptString

def decrypt(string,key):
    """This function will decrypt the string back to original form"""
    alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if len(key) != len(alphabet):
        raise ValueError("The length of the key is not equal to the length of alphabet!")
    decryptString = ""
    for letter in string:
        if letter in alphabet:
            decryptString += alphabet[key.index(letter)]
        else:
            decryptString += letter
    return decryptString
    
def keygen():
    """This function makes a key that helps encrypt the string and then decrypt the string"""
    alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    alphabet = list(alphabet)
    output = ""
    for i in range(len(alphabet)):
        letter = random.randint(0, len(alphabet)-1)
        output += alphabet[letter]
        alphabet.pop(letter)
    return output

key = keygen()
print(key)
word = encrypt("computer",key)
print(word)
print(decrypt(word,key))

