# CSC3430 Stable Matching
## Processes
### Overview
This assignment was to implement the given pseudocode from https://canvas.spu.edu/courses/58355/files/3659012?module_item_id=878818. We were supposed to write this in the language of our choice and being mindful of the chosen data structures.
### Implementation 
This implementation was followed as closely as possible to keep the algorithm at O(n^2). I chose to use maps and queues to keep access to elements as fast as possible.
### The Program
An example of executing this program from the command line is you will give the row, cols, group1.txt, group2.txt and will output the stable match. Example gs.jar 4, 5, a.txt, b.txt. The text files are supposed to look like a 2d matrix seperated with commands below you'll see an example.

a.txt:
    Bill,Jane,Joan,Diana,Brianna
    Alex,Joan,Jane,Brianna,Diana
    John,Joan,Diana,Brianna,Jane
    Alfred,Diana,Brianna,Joan,Jane

b.txt:
    Jane,Alex,Bill,John,Alfred
    Joan,John,Alex,Bill,Alfred
    Diana,Alfred,Alex,John,Bill
    Brianna,Bill,Alex,John,Alfred

### Example output from the given data
Alfred <3 Diana
Bill <3 Brianna
John <3 Joan
Alex <3 Jane
