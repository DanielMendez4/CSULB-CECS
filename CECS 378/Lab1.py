import math
import random
import nltk
from nltk.corpus import words
setOfWords = set(words.words())

#1. Brute-force Decryption ########################################################################

# Utilizes casar cipher algorithm to decrypt a phrase
# phrase - text string to be decrypted
def caesar_cipher(phrase):
	temp = phrase.replace(" ", "")
	results = []
	for i in range(1, 27):
		offset = i
		newStr = ""
		for j in range(len(temp)):
			if (ord(temp[j]) + offset) > ord('z'):
				newOff = (ord(temp[j]) + offset) - ord('z')
				newStr += chr(ord('a') - 1 + newOff)
			else:
				newStr += chr(ord(temp[j]) + offset)
		checkStr = ""
		for j in range(len(newStr)):
			checkStr += newStr[j]
			if ( (len(checkStr) >= 2) and (checkStr in setOfWords) ):
				results.append(newStr)
				break
	print("-----Best Results-----")
	for i in range(len(results)):
		print("{}. {}".format(i+1, results[i]))
	print("")

# Attempted code to decrypt phrase 3 and 4 in part 1
# Proved unsuccessful
"""
def generate_keys(phrase):
	alphabet = {}
	temp = phrase.replace(" ", "")
	for char in temp:
		if char.isalpha():
			alphabet[char] = 0
	sortedChar = sorted(alphabet, key = alphabet.get, reverse = True)
	results = []
	size = 0
	while (size != math.factorial(len(sortedChar))):
		alphabet = list("abcdefghijklmnopqrstuvwxyz")
		newKey = ""
		for i in range(len(sortedChar)):
			letter = random.randint(0, len(alphabet)-1)
			newKey += alphabet[letter]
			alphabet.pop(letter)
		if newKey not in results:
			results.append(newKey)
			size += 1
	return results
	
def sub_cipher(phrase):
	alphabet = "abcdefghijklmnopqrstuvwxyz"
	temp = phrase.replace(" ","")
	results = []
	keys = generate_keys(phrase)
	for i in range(len(keys)):
		newStr = ""
		for letter in temp:
			if letter in alphabet:
				newStr += alphabet[key[i].index(letter)]
			else:
				newStr += letter
		checkStr = ""
		for j in range(len(newStr)):
			checkStr += newStr[j]
			if ( (len(checkStr) >= 2) and (checkStr in setOfWords) ):
				results.append(newStr)
				break
	print("-----Best Results-----")
	for i in range(len(results)):
		print("{}. {}".format(i+1, results[i]))
	print("")
"""
	
phrase1 = "fqjcb rwjwj vnjax bnkhj whxcq nawjv nfxdu mbvnu ujbbf nnc"

phrase2 = "oczmz vmzor jocdi bnojv dhvod igdaz admno ojbzo rcvot jprvi oviyv aozmo cvooj ziejt dojig toczr dnzno jahvi fdiyv xcdzq zoczn zxjiy"

phrase3 = "ejitp spawa qleji taiul rtwll rflrl laoat wsqqj atgac kthls iraoa twlpl qjatw jufrh lhuts qataq itats aittk stqfj cae"

phrase4 = "iyhqz ewqin azqej shayz niqbe aheum hnmnj jaqii yuexq ayqkn jbeuq iihed yzhni ifnun sayiz yudhe sqshu qesqa iluym qkque aqaqm oejjs hqzyu jdzqa diesh niznj jayzy uiqhq vayzq shsnj jejjz nshna hnmyt isnae sqfun dqzew qiead zevqi zhnjq shqze udqai jrmtq uishq ifnun siiqa suoij qqfni syyle iszhn bhmei squih nimnx hsead shqmr udquq uaqeu iisqe jshnj oihyy snaxs hqihe lsilu ymhni tyz"

caesar_cipher(phrase1)
caesar_cipher(phrase2)

"""
sub_cipher(phrase3)
sub_cipher(phrase4)
"""
###################################################################################################

#2. Simple Substitution Encrypter / Decrypter #####################################################

# Generates a random key using both upper and lower case letters
# returns a new key with lower and upper case letters
def generate_key():
	alphabet = list("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
	random.shuffle(alphabet)
	newKey = "".join(alphabet)
	return newKey

# Encrypts a phrase using a specific key
# phrase - text to be encrypted
# key - modified alphabet used to encrypt phrase
# returns the encrypted text
def encrypt(phrase,key):
	alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	encryptStr = ""
	for letter in phrase:
		if letter in alphabet:
			encryptStr += key[alphabet.index(letter)]
		else:
			encryptStr += letter
	return encryptStr

# Decrypts a phrase using a specific key
# phrase - text to be decrypted
# key - modified alphabet used to decrypt the phrase
# returns the decrypted text
def decrypt(phrase,key):
	alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
	decryptStr = ""
	for letter in phrase:
		if letter in alphabet:
			decryptStr += alphabet[key.index(letter)]
		else:
			decryptStr += letter
	return decryptStr

phrase5 = "He who fights with monsters should look to it that he himself does not become a monster. And if you gaze long into an abyss, the abyss also gazes into you."

phrase6 = "There is a theory which states that if ever anybody discovers exactly what the Universe is for and why it is here, it will instantly disappear and be replaced by something even more bizarre and inexplicable. There is another theory which states that this has already happened."

phrase7 = "Whenever I find myself growing grim about the mouth; whenever it is a damp, drizzly November in my soul; whenever I find myself involuntarily pausing before coffin warehouses, and bringing up the rear of every funeral I meet; and especially whenever my hypos get such an upper hand of me, that it requires a strong moral principle to prevent me from deliberately stepping into the street, and methodically knocking people’s hats off - then, I account it high time to get to sea as soon as I can."

alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

#First phrase
print("Standard alphabet: {}".format(alphabet))
key1 = generate_key()
print("Modified alphabet: {}".format(key1))
encrypt1 = encrypt(phrase5,key1)
print("-----Ciphertext-----\n{}".format(encrypt1))
decrypt1 = decrypt(encrypt1,key1)
print("-----Plaintext-----\n{}\n".format(decrypt1))

#Second phrase
print("Standard alphabet: {}".format(alphabet))
key2 = generate_key()
print("Modified alphabet: {}".format(key2))
encrypt2 = encrypt(phrase6,key2)
print("-----Ciphertext-----\n{}".format(encrypt2))
decrypt2 = decrypt(encrypt2,key2)
print("-----Plaintext-----\n{}\n".format(decrypt2))

#Third phrase
print("Standard alphabet: {}".format(alphabet))
key3 = generate_key()
print("Modified alphabet: {}".format(key3))
encrypt3 = encrypt(phrase7,key3)
print("-----Ciphertext-----\n{}".format(encrypt3))
decrypt3 = decrypt(encrypt3,key3)
print("-----Plaintext-----\n{}\n".format(decrypt3))
###################################################################################################
