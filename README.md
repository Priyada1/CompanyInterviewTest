# CompanyInterviewTest
1) there are 3 test case has been added
   a) CustomerSearchTest for all users which is present in DB
   b) CustomerSearchTestByUsingMobileNumber- it is used for test scenario with valid customer
   c) CustomerSearchTestByUsingInvalidMobileNumber- it is used for test scenario with invalid customer
   
  we can make test case scenario more generic by using Data Provider but time is less  



Test Cases for both Apis
Test case for Auth Api
1) Validate Auth token is getting generated with 200 when user sends correct body parameters
2) Validate Auth Api is giving 400 Bad Request if user send incorrect bodyParams
3) Validate error is getting displayed with client error when user sends incorrect base URI.

Test Case for User Api
1)Validate correct Response is getting generated with 200 when user sends correct data with valid Auth Token for User Api (All Users should get displayed)
2) Validate User Api is giving 401 when user sends correct data with Invalid Auth Token for User Api
3) Validate User Api is giving 400 error when user sends incorrect mobilenumber with valid Token
4) Validate error is getting displayed with client error when user sends incorrect base URI.


Documents Defects
1) when user sends invalid mobile number in user api Status code is giving 200 
 Expected:- it should be 400 Bad request


