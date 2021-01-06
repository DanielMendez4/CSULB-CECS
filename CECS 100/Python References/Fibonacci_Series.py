# Fibonacci series:
# the sum of two elements defines the next
a, b = 0, 1
print(a, end=' ')
while b < 50:
    print(b, end=' ')
    a, b = b, a+b
