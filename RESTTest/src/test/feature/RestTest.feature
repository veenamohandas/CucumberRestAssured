Feature: REST API Testing
  As a QA
  I should be able to verify 
  View,Create,Update,Delete,List functionalities

  @apiSuite @GET
  Scenario: To verify the Get request response.
    Given I am calling GetUser request.
    When I am calling request with url parameter "1"
    Then I fire the get request.
    Then I should be able to see the get response userId="1"
    Then I should be able to see the get response Id="1"
    Then I should be able to see the get response title as a valid string
    Then I should be able to see the get response body as a valid string

  @apiSuite
  Scenario: To verify the Get request response code.
    Given I am calling GetUser request.
    When I am calling request with url parameter "1"
    Then I fire the get request.
    Then I should be able to see the response code as "200" Ok.

  @apiSuite
  Scenario: To verify the Get request response time.
    Given I am calling GetUser request.
    When I am calling request with url parameter "1"
    Then I fire the get request.
    Then I should be able to get the response in "5000" milliSeconds.

  @apiSuite
  Scenario: To verify the Post request response.
    Given I am calling PostUser request.
    Then I set title body and userId
    Then I fire the post request.
    Then I should be able to see the post response userId="1"
    Then I should be able to see the post response Id="101"
    Then I should be able to see the post response title="foo"
    Then I should be able to see the post response body="bar"

  @apiSuite
  Scenario: To verify the Post request response code.
    Given I am calling PostUser request.
    Then I set title body and userId
    Then I fire the post request.
    Then I should be able to see the response code as "201" Ok.

  @apiSuite
  Scenario: To verify the Put request response.
    Given I am calling PutUser request.
    When I am calling request with url parameter "2"
    Then I set title,body,id and userId for put request
    Then I fire the put request.
    Then I should be able to see the post response userId="1"
    Then I should be able to see the post response Id="2"
    Then I should be able to see the post response title="foo"
    Then I should be able to see the post response body="bar"

  @apiSuite
  Scenario: To verify the Put request response code.
    Given I am calling PutUser request.
    When I am calling request with url parameter "2"
    Then I set title,body,id and userId for put request
    Then I fire the put request.
    Then I should be able to see the response code as "200" Ok.

  @apiSuite
  Scenario: To verify the Patch request response
    Given I am calling PatchUser request.
    When I am calling request with url parameter "2"
    Then I set title: "foo" for put request
    Then I fire patch request
    Then I should be able to see the post response userId="1"
    Then I should be able to see the post response Id="2"
    Then I should be able to see the post response title="foo"
    Then I should be able to see the get response body as a valid string

  @apiSuite
  Scenario: To verify the Patch request response code.
    Given I am calling PatchUser request.
    When I am calling request with url parameter "2"
    Then I set title: "foo" for put request
    Then I fire patch request
    Then I should be able to see the response code as "200" Ok.

  @apiSuite
  Scenario: To verify the Delete request response
    Given I am calling DeleteUser request
    When I am calling request with url parameter "2"
    Then I fire the Delete request
    Then I should be able to see the response code as "200" Ok.

  @apiSuite
  Scenario: To verify the List request response
    Given I am calling GetUser request.
    Then I fire the get request.
    Then I should be able to see the response code as "200" Ok.
