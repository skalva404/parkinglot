Rules						
1. We are interested in your object oriented development skills, so please solve the problem keeping this in mind.
 							
2. Please ensure that the coding conventions, directory structure and build approach of your project follow the conventions set by popular open source projects in the language that you're using.
 							
3. MANDATORY: You have to solve the problem in Java, Go or any other object oriented language ​without using any external libraries/gems​ except for a testing library for TDD. Your solution m​ust build+run on Linux.
 							
4. MANDATORY: Please use Git for version control. We expect you to send us a ​standard zip or tarball​ of your source code when you're done that includes Git metadata (the .git folder) in the tarball so we can look at your commit logs and understand how your solution evolved. Frequent commits are a huge plus.
 							
5. MANDATORY: Please ​do not ​check in class files, jars or other libraries or output from the build process. Use a standard build automation and dependency system like ant/maven/rake.
 							
6. MANDATORY: Please write comprehensive unit tests/specs. Additionally, it's a huge plus if you test drive your code.
 							
7. MANDATORY: Please ensure that you follow the syntax and formatting of both the input and output samples. We validate submissions using automated tests. For your submission to pass the automated tests, p​ lease include an executable file called parking_lot at the root of your project directory​ which builds the code, runs tests/specs, then runs the program. It takes an input file as an argument and prints the output on STDOUT. Please see the example below.
 							
8. MANDATORY: Please do not make either your solution or this problem statement publicly available by, for example, using github or bitbucket or by posting this problem to a blog or forum.
 																

Problem Statement
I own a multi-storey parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one. I want to create an automated ticketing system that allows my customers to use my parking lot without human intervention.						
When a car enters my parking lot, I want to have a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the colour of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks the slot they were using as being available.						
Due to government regulation, the system should provide me with the ability to find out:
●  Registration numbers of all cars of a particular colour.
●  Slot number in which a car with a given registration number is parked.		
●  Slot numbers of all slots where a car of a particular colour is parked.
 								
We interact with the system via a simple set of commands which produce a specific output. Please take a look at the example below, which includes all the commands you need to support - they're self explanatory. The system should allow input in two ways. Just to clarify, the same codebase should support both modes of input - we don't want two distinct submissions.
 								
1) It should provide us with an interactive command prompt based shell where commands can be typed in
 								
2) It should accept a filename as a parameter at the command prompt and read the commands from that file