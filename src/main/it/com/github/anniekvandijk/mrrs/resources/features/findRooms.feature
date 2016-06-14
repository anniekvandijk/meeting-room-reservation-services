Feature: Find meetingrooms

  Background:
    Given I am on a meeting room application

  Scenario: find all meeting rooms
    When I want to find all meeting rooms
    Then I see all meeting rooms available

  Scenario: find all meetingrooms with capacity 10 or more
    When I look for a meeting room for 10 persons
    Then I see all meeting rooms for 10 persons
    And I see all meeeting rooms with more capacity

  Scenario: Error when capacity is to much
  When I lool for a meeting room with more capacity than available
  Then I get an error message

  Scenario: Find all meetingrooms with a specific name
    When I look for a meeting room with name "name"
    Then I see all meeting rooms with name "name"
    And I see all meeetingrooms where "name" is part of the name

  Scenario: Find all meetingrooms with a specific location
    When I look for a meeting room with location "location"
    Then I see all meeting rooms with location "location"
    And I see all meeetingrooms where "location" is part of the locationname

  Scenario: Find all meetingrooms with a facility
    When I look for a meetingroom with the facility "facility"
    Then I see all meeting rooms with the facility "facility"

  Scenario: Find all meetingrooms with all facilities
    When I look for a meetingroom with the facilities "facilities"
    Then I see all meeting rooms with the facilities "facilities"

  Scenario: Find all meetingrooms with all facilities, but not the ones I don't want
    When I look for a meetingroom with the facility "facility", but not the facility "facility"
    Then I see all meeting rooms with the facility "facility", but not the facility "facility"
