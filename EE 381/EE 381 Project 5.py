import numpy as np
import matplotlib.pyplot as plt
import math

N = 1200000
mu = 45
sigma = 3
n = 180

#1. Effect of sample size on confidnece intervals ##################################################
X_bar = np.zeros((n,1))
sigma_X_bar = np.zeros((n,1))
sample_size = np.zeros((n,1))
mu_line = np.full((n,1), mu)

for i in range(1, n+1):
    X = np.random.normal(mu,sigma,i)
    X_bar[i-1] = np.sum(X) / i
    sigma_X_bar[i-1] = sigma / math.sqrt(i)
    sample_size[i-1] = i

# 95% Confidence Interval
CI95_pos = np.zeros((n,1))
CI95_neg = np.zeros((n,1))

for i in range(0, n):
    CI95_pos[i] = mu + (sigma_X_bar[i] * 1.96)
    CI95_neg[i] = mu - (sigma_X_bar[i] * 1.96)
    plt.plot(sample_size[i] ,X_bar[i], 'b', marker = 'x')

plt.title("Sample Means and 95% confidence intervals", fontsize = 14, fontweight = 'bold')
plt.xlabel("Sample Size", fontsize = 14)
plt.ylabel("X_bar", fontsize = 14)
plt.plot(sample_size,CI95_pos,'r',linestyle = '--')
plt.plot(sample_size,mu_line,'k')
plt.plot(sample_size,CI95_neg,'r',linestyle = '--')
plt.show()

# 99% Confidence Interval
CI99_pos = np.zeros((n,1))
CI99_neg = np.zeros((n,1))

for i in range(0, n):
    CI99_pos[i] = mu + (sigma_X_bar[i] * 2.58)
    CI99_neg[i] = mu - (sigma_X_bar[i] * 2.58)
    plt.plot(sample_size[i] ,X_bar[i], 'b', marker = 'x')

plt.title("Sample Means and 99% confidence intervals", fontsize = 14, fontweight = 'bold')
plt.xlabel("Sample Size", fontsize = 14)
plt.ylabel("X_bar", fontsize = 14)
plt.plot(sample_size,CI99_pos,'g',linestyle = '--')
plt.plot(sample_size,mu_line,'k')
plt.plot(sample_size,CI99_neg,'g',linestyle = '--')
plt.show()

####################################################################################################

#2. Using the sample mean to estimate the population mean ##########################################
n1 = 5
n2 = 40
n3 = 120
M = 10000
def confidence_interval(n, M, mu, sigma, crit_val):
    success = 0
    for i in range(0, M):
        X = np.random.normal(mu,sigma,n)
        X_bar = np.sum(X) / n
        T = np.zeros((n,1))
        for j in range(0, n):
            T[j] = (X[j] - X_bar)**2
        S_hat = math.sqrt(np.sum(T) / (n - 1))
        mu_lower = X_bar - (crit_val * (S_hat / math.sqrt(n)))
        mu_upper = X_bar + (crit_val * (S_hat / math.sqrt(n)))
        if (mu > mu_lower) and (mu < mu_upper):
            success += 1
    return success

#2.1 95% and 99% Confidence Interval with n = 5 ----------------------------------------------------
# 95% Confidence Interval using Normal Distribution
norm_success1 = confidence_interval(n1,M,mu,sigma,1.96)
print("Percentage of success for 95% Confidence Interval using Normal Distribution: " + str((norm_success1 / M) * 100))

# 99% Confidence Interval using Normal Distribution
norm_success2 = confidence_interval(n1,M,mu,sigma,2.58)
print("Percentage of success for 99% Confidence Interval using Normal Distribution: " + str((norm_success2 / M) * 100))

# 95% Confidence Interval using t Distribution
t_success1 = confidence_interval(n1,M,mu,sigma,2.78)
print("Percentage of success for 95% Confidence Interval using t Distribution: " + str((t_success1 / M) * 100))

# 99% Confidence Interval using t Distribution
t_success2 = confidence_interval(n1,M,mu,sigma,4.60)
print("Percentage of success for 99% Confidence Interval using t Distribution: " + str((t_success2 / M) * 100))

#2.2 95% and 99% Confidence Interval with n = 40 ---------------------------------------------------
# 95% Confidence Interval using Normal Distribution
norm_success3 = confidence_interval(n2,M,mu,sigma,1.96)
print("Percentage of success for 95% Confidence Interval using Normal Distribution: " + str((norm_success3 / M) * 100))

# 99% Confidence Interval using Normal Distribution
norm_success4 = confidence_interval(n2,M,mu,sigma,2.58)
print("Percentage of success for 99% Confidence Interval using Normal Distribution: " + str((norm_success4 / M) * 100))

# 95% Confidence Interval using t Distribution
t_success3 = confidence_interval(n2,M,mu,sigma,2.02)
print("Percentage of success for 95% Confidence Interval using t Distribution: " + str((t_success3 / M) * 100))

# 99% Confidence Interval using t Distribution
t_success4 = confidence_interval(n2,M,mu,sigma,2.70)
print("Percentage of success for 99% Confidence Interval using t Distribution: " + str((t_success4 / M) * 100))

#2.3 95% and 99% Confidence Interval with n = 120 --------------------------------------------------
# 95% Confidence Interval using Normal Distribution
norm_success5 = confidence_interval(n3,M,mu,sigma,1.96)
print("Percentage of success for 95% Confidence Interval using Normal Distribution: " + str((norm_success5 / M) * 100))

# 99% Confidence Interval using Normal Distribution
norm_success6 = confidence_interval(n3,M,mu,sigma,2.58)
print("Percentage of success for 99% Confidence Interval using Normal Distribution: " + str((norm_success6 / M) * 100))

# 95% Confidence Interval using t Distribution
t_success5 = confidence_interval(n3,M,mu,sigma,1.98)
print("Percentage of success for 95% Confidence Interval using t Distribution: " + str((t_success5 / M) * 100))

# 99% Confidence Interval using t Distribution
t_success6 = confidence_interval(n3,M,mu,sigma,2.62)
print("Percentage of success for 99% Confidence Interval using t Distribution: " + str((t_success6 / M) * 100))

####################################################################################################
