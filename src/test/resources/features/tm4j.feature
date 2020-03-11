# language: en
Feature: Jira TM4J test Rooms require a location and capacity. Optional they have a name and facilities.

  Background: Testdata

    Given the following rooms are available
      | name      | location | capacity | facilities         |
      | Berlin    | 1.12     | 12       | whiteboard         |
      | Paris     | 1.13     | 40       | beamer, computer   |
      | Amsterdam | 1.14     | 6        | whiteboard, beamer |

  Scenario: Meeting room name can be found by location
    When I look for a meeting room with location "1.12"
    Then I will find 1 room
    And the room with name "Berlin" should be returned

  Scenario: Find meeting room with a specific name
    When I look for a meeting room with name "Paris"
    Then I will find 1 room
    And the room with location "1.13" should be returned

  Scenario: Find all meeting rooms with capacity 10 or more
    When I look for a meeting room for at least 11 persons
    Then I will find 2 rooms
    And the room with name "Berlin" should be returned
    And the room with name "Paris" should be returned

  Scenario: Find all meeting rooms with a facility
    When I look for a room with the facility "beamer"
    Then I will find 2 rooms
    And the room with name "Paris" should be returned
    And the room with name "Amsterdam" should be returned

  Scenario: Failing test
    When I look for a room with the facility "beamer"
    Then I will find 1 room

  Scenario: Extra testcase
    When I look for a room with the facility "beamer"
    Then I will find 1 room


