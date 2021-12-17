#--------------------------------------------------------------------------------
##                     TEST WEELO GET
##--------------------------------------------------------------------------------
#       			Authors:
#		jpablo-na993@hotmail.com
# language: en


  Feature: As candidate want  to send two values

    @SeeValue
    Scenario: Validate the correct status code
      When send a get request
      Then validate the url and status 200


    @GetTwoValues
    Scenario: Validate status 200 with two values
      When Send request with two values
      Then Validate status 200 and URL