# Demonstration of formatting strings using % and .format()
statistics={'Bob':{'weight':150,'height':72},'Harry':{'weight':175,'height':78},'Lucy':{'weight':120,'height':66}}
# use the classic % operator
kind = 'classic % operator'
print(('-'*20+'{}'+'-'*20).format(kind))            # put out a separator line
for person in statistics:
    stats = statistics[person]
    print('Name: %10s' % person + ' ' + 'Weight is: %(weight)5d and Height is: %(height)5d' % stats)

# in the print statement below, use a variable argument and set it each time
# to say what option we used.
kind = 'implied positional'
print(('-'*20+'{}'+'-'*20).format(kind))            # put out a separator line

# Use the format function, but inferred positional
for person in statistics:
    stats = statistics[person]
    print('Name: {} Weight is: {} and Height is: {}'.\
          format(person.rjust(10), '{:>5}'.format(statistics[person]['weight']),\
                 '{:>5}'.format(statistics[person]['height'])))

kind = 'deliberate positional'
print(('-'*20+'{}'+'-'*17).format(kind))            # put out a separator line
# Use the format function, but positional
for person in statistics:
    stats = statistics[person]
    print('Name: {2:>10} Weight is: {1:>5} and Height is: {0:>5}'.format(stats['height'], stats['weight'], person))
    
# Use the format function, but the Named approach - matching argument 
kind = 'keyword argument'
print(('-'*20+'{}'+'-'*22).format(kind))            # put out a separator line
for person in statistics:
    stats = statistics[person]
    print('Name: {name:>10} Weight is: {weight:>5} and Height is: {height:>5}'\
          .format(name=person, height = stats['height'],\
                  weight = stats['weight']))
