# Filtering users from Stack Exchange API


### Overview
The project retrieve the list of stack overflow users meeting the following criteria:
1. Are located in Romania or Moldova
2. Have a reputation of min 223 points.
3. Answered min 1 question
4. Have the tags: "java",".net","docker" or "C#"

### Project description
Project uses an HttpClient to get all users from api.stackexchange.com. Then filter them and output to STDOUT.

### Attention
For reason that API has limits of request per second, the program is working and filtering users simultaneously.  

### To run project you should

1. Clone the project from GitHub
2. Run project