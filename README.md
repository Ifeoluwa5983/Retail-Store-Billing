TITLE

# Retail-Store-Billing

DESCRIPTION

# A Spring Boot Java application with test cases, which exposes an API such that given a bill, it finds the net payable amount, using object oriented approach

How to Install and Run the Project

# Clone project
# Make sure you have postgressql and jdk version 11 installed on your local machine 
# Create a database named "Retail_Store_Db
# Run the application and make it is running on the set port 8081
# Test the api
# The api documentation was done with swagger - localhost:8081/swagger-ui/

SAMPLE REQUEST

{
  "customerId": 1,
  "description": "string",
  "items": [
    {
      "id": 0,
      "productId": 1,
      "quantity": 20
    },
  {
      "id": 0,
      "productId": 2,
      "quantity": 2
    }
  ]
}
