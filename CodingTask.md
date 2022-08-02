## Purpose

Welcome to *`<Company Name>`*! We're glad that you're considering joining our team and would like to get to know you a little better. Our aim is to gauge your problem solving skills and coding experience. We don't believe in having you implement a complex algorithm to solve some tricky academic problem with an interviewer scruitinizing you. Instead, we would like you to solve the kind of problems we encounter at *`<Company Name>`* on a daily basis. The following coding exercise is designed to do exactly that.
  
## Process

You will be required to submit your solution no less than 1 hour prior to the scheduled Technical Conversation. When we meet, we will request that you run the solution, and then perform a code walkthrough. We're looking to understand your approach to problem solving and decision making. Please come prepared to share why you chose to solve a problem in a particular fashion, and if you considered alternatives. We're not trying to trick you or test your recollection of some obscure Java library. We're simply interested in learning how you design your code and why. To that end, feel free to use resources online. However, if you come across a solution uploaded to the web by a previous interviewee, please refrain from using it. Our journey together will end soon if we're not completely honest in our interactions.

## Business Case

Vancouver Credit Union (VCU) is in the initial stages of building their Credit Card Rewards Redemption system. VCU has several credit card products with different reward types like Cash, Miles and Points. A customer may have multiple products, but each product can have only one reward type. 

## Your Task

You've been hired to build a ReSTful API that will serve as the middle tier for an application that will be used by both customers and VCU administrators. The rewards data available in the attached data.sql will serve as your back-end. Your may not make any changes to the data model. Your task is to create a Java based Microservice that exposes endpoints which enable the following:

1. Given a customer, provide a list of all rewards that are currently available to that customer.
   - This endpoint will be used to display the available rewards to a customer upon landing on the homepage of the VCU Credit Card Rewards Redemption application.
   - Remember to provide available rewards for all of the customer's credit cards.
   - A reward is deemed available if it is not expired and the customer has enough `RewardBalance` to be able to redeem that reward.
1. Given a customer and a specific credit card, redeem the customer's available rewards balance for the *_highest_* valued reward.
   - This endpoint will drive an experimental feature called _One Click Redemption_ that will allow customers to get the best rewards.
   - Redeeming a reward means to decrement the `RewardBalance` and update the `LastRedemptionDate`.
1. Create endpoints that allow a VCU Administrator to add and update Reward Options.
   - Clearly, these endpoints will be for VCU-internal use only and the security setup required is out of scope for this exercise. 

## Requirements
1. Use Java version 7 or higher
1. Use an in-memory database (e.g. [H2](https://www.h2database.com/html/main.html), [Apache Derby](https://db.apache.org/derby/))
1. Follow Open API Standards (https://swagger.io/docs/specification/about/)
1. Use an [Enum](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) for `RewardType`.

## Delivery
1. Source code
1. Instructions on how to run the code
1. Client (e.g. cURL commands, Postman collection, Swagger UI, etc.) to invoke the ReSTful endpoints
1. Description of any assumptions you made or anything you think is required to understand and run your solution
1. Provide a list of tasks that you would need to complete to productionize your solution
