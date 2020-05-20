# Demonstrating Software Quality

## Scrum sprint backlog and task estimation

In order to estimate the difficulty of task I have used the Bucket System.
Story points rate the  effort of the work involved in a Fibonacci-like format:  1, 2, 3, 5, 8, 13.. .
Regarding the priority the task are ordered based on their priority.

1. Create the model classes for Survey, SurveyResponse, Question ojects. Story Points: 2

2. Create the Controller class. Story Points: 1

3. Implement method to create new survey. Story Points: 2

4. Implement method that enables to add question to survey. Story Points: 2

5. Add method that displays list of all surveys. Story Points: 2

6. Add method to get survey by name. Story Points: 2

7. Implement method to create survey responses. Story Points: 2

8. Add method to display the survey responses associated with a survey. Story Points: 2

9. Calculate average for survey. Story Points: 2

10. Calculate standard deviation for survey. Story Points: 3

11. Get maximum and minimum score for a survey. Story Points: 3

12. Calculate standard deviation for a question. Story Points: 2

13. Get maximum and minimum score for a question. Story Points: 3

I have decided to assign 1 point to the 2nd task as it only involves th creation of a class and no testing. Starting from there as tasks get more complex and involve testing and other different steps I have decided to increase the story points. So for tasks like the 3rd and 4th I have decide to estimate 2 story points.

### The Velocity Metric

The velocity metric represents the amount of work a team can tackle during a single sprint. It is also an indicator of the average amount of backlog turned into an Increment during a Sprint.
At the end of each sprint, the team adds up effort estimates associated with all fully completed stories.
The velocity I had for this sprint was 28, out of 13 story I have fully completed them and all of the story points associated with a story added to the velocity.
In relation to the next sprint, velocity facilitates accurate forecasting of how many story points a team can do in the sprint.

## Using testing and Test-Driven development

The approach I followed for the development of this project relies on the repetition of short development cycle.
I started by writing tests that were failing then produced minimum amount of code that makes the test pass and finally refactor the code to coding standards.
For each task I have first written the test and then implemented the fuctionlity followed by refactoring if needed.

I am demostrating the use of this approach in the folowing commits:

- e441f7fa4dddc7236336eef76ccdd357906c2af3
This commit contains the a method created in order to test the method calculateSurveyAverage(). The method only contained expected and actual value. The expected value was hardcoded and the actual value was calling the method in Controller.
The method calculateSurveyAverage() in Controller at the moment was not doing anything.

- dd8861600f25a4c6202d57fdc52b85cd3d810e21
I have written the test, create the needed objects in order to use the method and after that I have implemented the functionality to calculate the average in the method in Controller.

## Test coverage metric

## Code-review checklist

- Code Indentation and Formatting

- Naming Conventions

- White-Spaces

- Proper use of comments

- Exception Handling

- Code Complexity

- Functional Requirements

- Unit tests
