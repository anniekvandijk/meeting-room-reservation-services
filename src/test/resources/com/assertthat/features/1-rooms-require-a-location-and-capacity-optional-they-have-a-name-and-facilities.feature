# language: en
Feature: Rooms require a location and capacity. Optional they have a name and facilities.

    Background: Testdata
        
        Given the following rooms are available
          | name      | location | capacity | facilities         |
          | Berlin    | 1.12     | 12       | whiteboard         |
          | Paris     | 1.13     | 40       | beamer, computer   |
          | Amsterdam | 1.14     | 6        | whiteboard, beamer |

    @AUTOMATED @KP1-1 
    Scenario: Find all meeting rooms with a facility
        
        When I look for a room with the facility "beamer"
        Then I will find 2 rooms
        And the room with name "Paris" should be returned
        And the room with name "Amsterdam" should be returned

