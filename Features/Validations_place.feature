Feature: Validating Place API's

  Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload with "<name>"  "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    Then The api call got success with status code 200
    And "status" in responsebody is "OK"

    Examples: 
      | name    | language | address            |
      | AAhouse | English  | World cross center |
      | BBhouse | Spanish  | Sea cross center   |
      | CBhouse | Franch   | Linton cross road  |
