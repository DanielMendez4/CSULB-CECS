import numpy as np
import matplotlib
import matplotlib.pyplot as plt
import math

#1. Simulate continuous random variables with selected distributions ###############################
#P(1.1) a = 2.0, b = 5.0 ---------------------------------------------------------------------------
#Generate the values of the RV X
a = 2.0; b = 5.0; n = 10000;
x = np.random.uniform(a,b,n)

#Generate bins and histogram
nbins = 30;         #Number of bins
edgecolor = 'w';    #Color separating bars in the bargraph
#
bins = [float(x) for x in np.linspace(a, b, nbins + 1)]
h1, bin_edges = np.histogram(x, bins, density = True)

# Define points on the horizontal axis
be1 = bin_edges[0:np.size(bin_edges)-1]
be2 = bin_edges[1:np.size(bin_edges)]
b1 = (be1 + be2) / 2
barwidth = b1[1] - b1[0] #Width of bars in the bargraph
plt.close('all')

#Plot the bar graph
fig1 = plt.figure(1)
plt.bar(b1, h1, width = barwidth, edgecolor = edgecolor)
plt.title("PDF for a Uniform Distribution", fontsize = 14, fontweight = 'bold')
plt.xlabel("Uniform Probability Distribution from [a, b)", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)

#Plot the Uniform PDF
def UnifPDF(a,b,x):
    f = (1 / abs(b-a)) * np.ones(np.size(x))
    return f
f = UnifPDF(a,b,b1)
plt.plot(b1,f,'r')
plt.show()

#Calculate the Mean and Standard Deviation
mu_x = np.mean(x)
sig_x = np.std(x)
th_mu_x = (a + b) / 2
th_sig_x = np.sqrt((b - a)**2 / 12)
print("Experimental Mean: " + str(mu_x) + "\nExperimental Standard deviation: " + str(sig_x) + "\n")
print("Theoretical Mean: " + str(th_mu_x) + "\nTheoretical Standard deviation: " + str(th_sig_x) + "\n")

#P(1.2) beta = 0.33 --------------------------------------------------------------------------------
#Generate the values of the RV T
beta = 0.33; n = 10000;
t = np.random.exponential(beta,n)

#Create bins and histogram
nbins = 2;         #Number of bins
edgecolor = 'w';    #Color separating bars in the bargraph
#
bins = [float(t) for t in np.linspace(0, nbins + 1)]
h1, bin_edges = np.histogram(t, bins, density = True)

#Define points on the horizontal axis
be1 = bin_edges[0:np.size(bin_edges)-1]
be2 = bin_edges[1:np.size(bin_edges)]
b1 = (be1 + be2) / 2
barwidth = b1[1] - b1[0] #Width of bars in the bargraph
plt.close('all')

#Plot the bar graph
fig1 = plt.figure(1)
plt.bar(b1, h1, width = barwidth, edgecolor = edgecolor)
plt.title("PDF for an Exponential Distribution", fontsize = 14, fontweight = 'bold')
plt.xlabel("Exponential Probability Distribution", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)

#Plot the Exponential Uniform PDF
def ExpUnifPDF(beta,x):
    f = (np.exp(-(x / beta)) / beta) * np.ones(np.size(x))
    return f
f = ExpUnifPDF(beta,b1)
plt.plot(b1,f,'r')
plt.show()

#Calculate the Mean and Standard Deviation
mu_x = np.mean(t)
sig_x = np.std(t)
print("Mean: " + str(mu_x) + "\nStandard deviation: " + str(sig_x) + "\n")
print("Theoretical Mean: " + str(beta) + "\nTheoretical Standard deviation: " + str(beta) + "\n")

#P(1.3) mu = 2.5, sigma = 0.75 ---------------------------------------------------------------------
#Generate the values of the RV X
mu = 2.5; sigma = 0.75; n = 10000
x = np.random.normal(mu,sigma,n)

#Create bins and histogram
nbins = 5;          #Number of bins
edgecolor = 'w';    #Color separating bars in the bargraph
#
bins = [float(x) for x in np.linspace(0, nbins + 1)]
h1, bin_edges = np.histogram(x, bins, density = True)

#Define points on the horizontal axis
be1 = bin_edges[0:np.size(bin_edges)-1]
be2 = bin_edges[1:np.size(bin_edges)]
b1 = (be1 + be2) / 2
barwidth = b1[1] - b1[0] #Width of bars in the bargraph
plt.close('all')

#Plot the bar graph
fig1 = plt.figure(1)
plt.bar(b1, h1, width = barwidth, edgecolor = edgecolor)
plt.title("PDF for a Normal Distribution", fontsize = 14, fontweight = 'bold')
plt.xlabel("Normal Probability Distribution", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)

#Plot the Normal Uniform PDF
def NormUnifPDF(mu,sigma,x):
    f = (np.exp(-(x-mu)**2/(2*sigma**2)) / (sigma*np.sqrt(2*np.pi))) * np.ones(np.size(x))
    return f

f = NormUnifPDF(mu,sigma,b1)
plt.plot(b1,f,'r')
plt.show()

#Calculate the Mean and Standard Deviation
mu_x = np.mean(x)
sig_x = np.std(x)
print("Mean: " + str(mu_x) + "\nStandard deviation: " + str(sig_x) + "\n")
print("Theoretical Mean: " + str(mu) + "\nTheoretical Standard deviation: " + str(sigma) + "\n")

#2. The Central Limit Theorem a = 2.0 cm, b = 5.0 cm ###############################################
#Generate the values of the RV X
a = 2.0; b = 5.0; nBooks = 1; N = 10000; #nBooks = 1, 5, 15
mu_x = (a+b) / 2; sig_x = np.sqrt((b-a)**2 / 12)
X = np.zeros((N,1))
for k in range(0,N):
    x = np.random.uniform(a,b,nBooks)
    w = np.sum(x)
    X[k] = w

#Create bins and histogram
nbins = 30;
edgecolor = 'w'
#
bins = [float(x) for x in np.linspace(nBooks*a, nBooks*b, nbins + 1)]
h1, bin_edges = np.histogram(X, bins, density = True)

#Define points on the horizontal axis
be1 = bin_edges[0:np.size(bin_edges) - 1]
be2 = bin_edges[1:np.size(bin_edges)]
b1 = (be1 + be2) / 2
barwidth = b1[1] - b1[0] #Width of bars in the bargraph
plt.close('all')

#Plot the bar graph
fig1 = plt.figure(1)
plt.bar(b1, h1, width = barwidth, edgecolor = edgecolor)
plt.title("PDF of Book Stack Height and Comparison with Gaussian", fontsize = 14, fontweight = 'bold')
plt.xlabel("Book stack height for n = 15 books", fontsize = 14)
plt.ylabel("PDF", fontsize = 14)

#Plot the Gaussian function
def gaussian(mu, sig, z):
    f = np.exp(-(z-mu)**2/(2*sig**2)) / (sig*np.sqrt(2*np.pi))
    return f
f = gaussian(mu_x*nBooks, sig_x*np.sqrt(nBooks), b1)
plt.plot(b1, f, 'r')
plt.show()

print("Mean thickness of a single book (cm): " + str(mu_x) + "\nStandard deviation of thickness (cm): " + str(sig_x) + "\n")
print("Theoretical Mean: " + str(nBooks * mu_x) + "\nTheoretical Standard deviation: " + str(np.sqrt(nBooks) * sig_x) + "\n")

#3. Distribution of the Sum of Exponential RVs beta = 50 days, n = 30 batteries, ###################
#Y1 = 3 yrs, Y2 = 2 yrs, Y3 = 4 yrs
beta = 50; n = 30; Y1 = 3; Y2 = 2; Y3 = 4; N = 10000;
C = np.zeros((N,1))

for i in range(0, N):
    carton = np.random.exponential(beta,n)
    C[i] = np.sum(carton) / 365

#Create bins and histogram
nbins = 30;         #Number of bins
edgecolor = 'w';    #Color separating bars in the bargraph
#
bins = [float(t) for t in np.linspace(1,7,nbins + 1)]
h1, bin_edges = np.histogram(C, bins, density = True)

#Define points on the horizontal axis
be1 = bin_edges[0:np.size(bin_edges)-1]
be2 = bin_edges[1:np.size(bin_edges)]
b1 = (be1 + be2) / 2
barwidth = b1[1] - b1[0] #Width of bars in the bargraph
plt.close('all')

#Plot the bar graph
fig1 = plt.figure(1)
plt.bar(b1, h1, width = barwidth, edgecolor = edgecolor)
plt.title("Distribution of the Sum of Exponential RVs", fontsize = 14, fontweight = 'bold')
plt.xlabel("Battery Carton Life (years)", fontsize = 14)
plt.ylabel("Probability", fontsize = 14)

#Calculate the Mean and Standard Deviation
mu_x = np.mean(C)
sig_x = np.std(C)

def gaussian(mu, sig, z):
    f = np.exp(-(z-mu)**2/(2*sig**2)) / (sig*np.sqrt(2*np.pi))
    return f
f = gaussian(mu_x, sig_x, b1)
plt.plot(b1, f, 'r')
plt.show()
print("Mean: " + str(mu_x) + "\nStandard deviation: " + str(sig_x))

#Plot the CDF
yCDF = np.cumsum(h1 * barwidth)
plt.bar(b1, yCDF, width = barwidth, edgecolor = edgecolor)
plt.title("CDF of the Lifetime of a Carton", fontsize = 14, fontweight = 'bold')
plt.xlabel("Lifetime of one carton", fontsize = 14)
plt.ylabel("Probability Density", fontsize = 14)
plt.plot(b1, yCDF, 'r')
plt.show()
