# User Guide

## Usage

###Starting the Duke chat-bot
Enter the following command into the terminal to start the chat-bot
Make sure the ip.jar file is in the current directory in the terminal
```
java -jar ip.jar
```

### `todo` - adding a new todo task 
adds a new todo task to the current task list and to the duke text file.

arguments:
1. taskDescription : description of the todo task

Example of usage:
`todo <taskDescription>`

### `deadline` - adding a new deadline task
adds a new deadline task to the current task list and to the duke text file.

arguments:
1. taskDescription : description of the deadline task
2. taskDeadline : the deadline time of the task 

Example of usage:
`todo <taskDescription> /by <taskDeadline>`

### `event` - adding a new deadline task
adds a new event task to the current task list and to the duke text file.

arguments:
1. taskDescription : description of the event task
2. taskEvent : the event time of the task

Example of usage:
`event <taskDescription> /at <taskEvent>`

### `list` - listing all tasks
lists all tasks in the task list

Example of usage:
`list`

### `done` - marking a task as done
marks a task as done on the current task list and on the duke text file.  

arguments:
1. taskNumber : task number corresponding to the task in task list to be marked as done.

Example of usage:
`done <taskNumber>`

### `delete` - deleting a task 
deletes a task off the current task list and off the duke text file.

arguments:
1. taskNumber : task number corresponding to the task in task list to be marked as done.

Example of usage:
`delete <taskNumber>`

### `find` - finding a task
find a task on the current task list based on the keyword entered.

arguments:
1. keyword : keyword to be searched in the task list.

Example of usage:
`find <keyword>`

### `bye` - terminating the chat-bot
terminates and quits the duke chat-bot

Example of usage:
`bye`
### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.
