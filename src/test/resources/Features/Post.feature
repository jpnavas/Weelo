#--------------------------------------------------------------------------------
##                     TEST WEELO POST
##--------------------------------------------------------------------------------
#       			Authors:
#		jpablo-na993@hotmail.com
# language: en

  Feature: As user i want to see the name, email and phone of candidate


    @SeeInformation
    Scenario: validate the information of candidate
      When send a request
      Then validate status code 200 and the information


    @UrlFail
    Scenario: Validate code error with request fail
      When send a fail request
      Then Validate code error