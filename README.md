# M223: Punchclock
Dies ist eine Applikation zur Zeiterfassung der Benutzer kann sich über die Website registrieren und einloggen.
Bei einem erfolgreichen Login erhält der Benutzer ein Authorization key im header zurück.
Damit kann der Benutzer über die Rest Schnittstellen der Applikation
- Einchecksandorte erfassen
- Einträge verwalten
- Benutzer verwalten

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

##Wichtige Links

### Registrierung
-  http://localhost:8081/sign-up.html

### Index
-  http://localhost:8081/index.html

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console