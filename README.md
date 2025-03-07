# RBS Informatik LF12 Projekt

## Technologien

- Java
- Springboot
  - JPA
  - Thymeleaf
  - Spring Security
  - Java Mail Sender
  - Quartz Scheduler
  - Spring MVC
- Docker
- MySQL

### Java

Die Haupt-Programmiersprache der Software

### Springboot

#### JPA
Datenbank-Schnittstelle von Java zu MySQL

#### Thymeleaf
HTML Templating Engine
Zum vereinfachten erstellen der UI

#### Spring Security
Zum Anmelden mit Benutzer

#### Java Mail Sender
Zum E-Mail versenden

#### Quartz Scheduler
Um bestimmte Events zum einem bestimmeten zeitpunkt auszuführen

#### Spring MVC
Zum erstellen der Web-Anwendung

### Docker
Zum bauen der anwendung und hosten von MySQL

### MySQL
Zum persestieren der Daten
persestierte Daten:
User
Todos
Events
Event-Typen

## Aufbau UI

### Kopfzeile
Menu Auswahl:
Home
Users
Todos
Calendar

Aktueller User Schaltfläche:
User anzeigen und bearbeiten
Einstellungen(mail einstellungen)
Logout

### Home
Überischts Seite mit kurzen infos zu:
Angemeldeter Nutzer
Todos(heute, morgen, ohne Termin)
Calendar(heute, morgen)
Wetter
### Users
Nutzer verwaltung
ansicht aller benutzer und alegen von neuen
### Todos
ansicht aller todos und anlegen neuer
### Calendar
ansicht aller Events und anlegen neuer
und anlegen neuer Event-Typen(Geburstag, Schule ...)