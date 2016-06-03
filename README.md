# Room reservation application

## The First Design
Stel een eerste versie op de van de Behavious Driven Development (BDD) Scenario's

## Requirements
* Voor een vergadering van een aantal mensen wil ik een vergaderzaal kunnen plannen.
* In het gebouw zijn vergaderzalen met faciliteiten, zoals computer met klein scherm of groot scherm.
* Er zijn verschillende vergader zalen met uit eenlopende capaciteit qua aantal mensen.

# Requirment iets aangepast zodat de opdracht wat kleiner blijft

## Requirements
* Voor een vergadering van een aantal mensen wil ik een vergaderzaal inzien.
* In het gebouw zijn vergaderzalen met faciliteiten, zoals computer met klein scherm of groot scherm.
* Er zijn verschillende vergader zalen met uit eenlopende capaciteit qua aantal mensen.

##Zaal
- Capaciteit
- Naam
- Locatie
- Faciliteiten

##Faciliteiten
- Beschrijving

Scenario: zoeken op alle vergaderzalen
Stel ik ben op 'een vergaderzaal applicatie'
Als ik zoek op alle vergaderzalen
Dan zie ik alle vergaderzalen

+++

Scenario: toon alle vergaderzalen met dezelfde of meer capaciteit
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek voor 10 personen
Dan zie ik alleen alle vergaderzalen voor 10 personen of meer

Scenario: Bij meer personen dan capaciteit een foutmelding
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek voor meer personen dan de grootste capaciteit
Dan krijg ik een betekenisvolle foutmelding

of

Scenario: toon alle vergaderzalen met dezelfde of meer capaciteit
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek voor 10 personen via een selectiemogelijkheid
Dan zie ik alleen alle vergaderzalen voor 10 personen of meer

+++

Scenario: toon alle vergaderzalen die aan dezelfde naam voldoen of deel daarvan
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek met de naam 'naam'
Dan zie ik de vergaderzalen met de naam 'naam'
En alle vergaderzalen waarbij het zoekwoord voor komt in de naam 'naam'

+++

Scenario: toon alle vergaderzalen die aan dezelfde naam voldoen of deel daarvan
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek met de locatie 'locatie'
Dan zie ik de vergaderzalen met de locatie 'locatie'
En alle vergaderzalen waarbij het zoekwoord voor komt in de locatie 'locatie' .

+++

Scenario: toon alle vergaderzalen die een computer hebben
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek met een computer
Dan zie ik alleen de vergaderzalen met een computer

Scenario: toon alle vergaderzalen die een computer en telefoon hebben
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek met een computer en telefoon
Dan zie ik alleen de vergaderzalen met een computer en telefoon

Scenario: toon alle vergaderzalen die een computer hebben, maar geen whiteboard
Stel ik ben op 'een vergaderzaal applicatie'
Als ik een vergaderzaal zoek met een computer, maar zonder telefoon
Dan zie ik alleen de vergaderzalen met een computer en zonder telefoon

+++




