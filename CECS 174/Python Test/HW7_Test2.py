def inList(tuples, task):
    """Boolean expression to tell whether a given item is already in the list of things to do.
       Arguments:
       a. tuples – The list of items to do.
       b. task – The task that the user wants to add to the todo list.
       Returns: True if the task is already in the tuples list, false otherwise."""
    for i in range(len(todos)):
        if task == todos[i][1]:
            return True
        else:
            return False
            
def addTask(tuples, priority, description):
    """Adds a new task to the todo list.
       Arguments:
       a. tuples – The list of items to do.
       b. priority – The priority of the new task. This has to be a positive integer.
       c. description – The textual description of the new task.
       Checks:
       a. If the priority is not an integer – raise a TypeError exception
       b. If the priority is not between 0 and 10 (not inclusive) raise a ValueError.
       c. If the type of the task argument is not a string, then raise a TypeError exception.
       d. If the task argument is already in the to do list, raise a ValueError exception."""
    while True:
        priority = input("Enter a priority or 0 to exit --> ")
        try:
            int_check = int(priority)
            if int_check == 0:
                break
        except ValueError:
            print("The type of your priority is not an integer!")
            continue
        else:
            if int_check < 0 or int_check > 9:
                print("The priority is out of range!")
                continue
            else:      
                task = input("Enter name of your task to add --> ")
                try:
                    if task.isdigit():
                        raise ValueError("That task is not a string description!")
                except ValueError:
                    print("That task is not a string description!")
                    continue
                else:
                    if inList(todos, task):
                        print("That task is already in your todo list!")
                        continue
                    else:     
                        todos.append((priority, task))
       
def getMostImportant(todos):
    """Returns the most important element from the remaining items in the to do list and then removes that item.
       Arguments:
       a. todos –The list of items that need to get done.
       Returns:
       a. The description of the next most important task in the to do list."""
    if not todos:
        raise IndexError("Congratulations, you are out of items in your todo list!")
    final = todos[0][1]
    del todos[0]
    return final
    
def getPriority(todos):
    return todos[0]

todos = []

def main():
    priority = None
    description = None
    return addTask(todos, priority, description)

main()
