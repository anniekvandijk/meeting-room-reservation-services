Feature: Rooms require a location and capacity. Optional they have a name and facilities.

  Scenario: Room can be found by location
    Given a room with name "Berlin", location "1.12" and capacity 12
    And which has facility "whiteboard"
    When searching for room with location "1.12"
    Then the room with name "Berlin" should be returned

  Scenario: find all meeting rooms
    Given The applications has 20 rooms
    When I look for a meeting room with no specific argument
    Then I will find 20 rooms

  Scenario: find all meetingrooms with capacity 10 or more
    Given The application has 2 rooms for 10 persons
    And The application has 4 rooms for more than 10 persons
    When I look for a meeting room for 10 persons
    Then I will find  2 rooms for 10 persons
    And I will find 10 rooms for more than 10 persons

  Scenario: Error when capacity is to much
  Given The applications max room capacity is 50
  When I lool for a meeting room for 51 persons
  Then I get an error message

  Scenario: Find all meetingrooms with a specific name
    Given The application has 1 room with the name "Meetingroom 1"
    And The application has 1 room with the name "Meetingroom 1 hoog"
    When I look for a meeting room with name "Meetingroom 1"
    Then I will find 1 room with name "Meetingroom 1 hoog"
    And I will find 1 room with the name "eetingroom"

  Scenario: Find all meetingrooms with a specific location
    Given The application has 1 room with the location "1511"
    And The application has 1 room with the location "Z1511"
    When I look for a meeting room with location "1511"
    Then I will find 1 room with location "1511"
    And  I will find 1 room with location "Z1511"

  Scenario: Find all meetingrooms with a facility
    Given The application has 2 rooms with the facility "Beamer"
    When I look for a meetingroom with the facility "Beamer"
    Then I will find 2 rooms with the facility "Beamer"

  Scenario: Find all meetingrooms with all facilities
    Given The application has 1 room with the facilities "Beamer" and "Computer"
    When I look for a meetingroom with the facilities "Beamer" and "Computer"
    Then  I will find 2 rooms with the facility "Beamer" and "Computer"

  Scenario: Find all meetingrooms with all facilities, but not the ones I don't want
    Given The application has 1 room with the facilities "Beamer" and "Computer"
    And The application has 1 room with the facilities "Telephone" and "Computer"
    When I look for a meetingroom with the facility "Computer", but not the facility "Telephone"
    Then I will find 1 room with the facilities "Beamer" and "Computer"
