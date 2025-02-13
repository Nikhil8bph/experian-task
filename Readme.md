# Assignment by Experian
### Question
Create an application that will, given a UK currency amount and the purchase price of a product, display the change to be returned split down by denomination, largest first. 
### References:
1. https://d1uvxqwmcz8fl1.cloudfront.net/tes/resources/11866814/6f7353f1-c54d-4a62-9e68-cda85c00159e/image?width=500&height=500&version=1521922065081
2. https://www.bankofengland.co.uk/banknotes/current-banknotes
### Features:
1. I have set some data adhoc which can be seen in the first part of the program
2. I have created a class to store the currencies and not used lombok as it may be difficult to run at times and it'll require installation.
3. CurrencyUtils has some generic methods that will be used for withdraw and update of the denominations and it's SKUs
4. We have used Enum as well to identify if currency returned is a coin or note.

### Later enhancements:
1. Adding UI using angular.
2. Adding more boundary checks.
3. Different tabs to handle the currency.
4. creation of the RESTapi for communication with backend made in spring boot.
5. Docker to dockerize the application.
6. use docker-compose or kubernetes to deploy the containers.

### Solution By: Nikhil Sharma
Time Elapsed: 1 hour 30 mins#  
