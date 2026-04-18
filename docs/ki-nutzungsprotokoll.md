# KI-Nutzungsprotokoll zur Studienarbeit

## Angaben zur Arbeit

- Gruppenname: **Mudkip**
- Titel der Studienarbeit:
- KI genutzt: **ja**
- Verwendete KI-Werkzeuge: **OpenAI Codex, ChatGPT**

Wenn keine KI genutzt wurde, reicht hier die Angabe "nein". In diesem Fall müssen die folgenden Abschnitte nicht ausgefüllt werden.

## Kurz-Erklärung

Dieses Protokoll wird als Markdown-Datei im Git-Repository der Gruppe geführt.
Wesentliche KI-Nutzungen werden hier kurz und zeitnah dokumentiert.
Die Nachvollziehbarkeit über Versionen ergibt sich aus der Git-Historie dieser Datei.

Für diese Studienarbeit wurden KI-Werkzeuge als Unterstützung verwendet.
Die wesentlichen Nutzungen sind unten dokumentiert.
Alle übernommenen Inhalte wurden fachlich geprüft, bei Bedarf angepasst und in die Arbeit eigenverantwortlich integriert.

## Übersicht der KI-Nutzung

Tragen Sie hier die wesentlichen Nutzungen ein.
Wenn ähnliche Nutzungen in engem Zusammenhang stehen, können Sie sie zusammenfassen.
Pflegen Sie das Protokoll möglichst zeitnah, damit die Git-Historie die Entwicklung nachvollziehbar macht. Nutzen Sie KI, um Ihren Promtverlauf entsprechnd dieser Vorlage festzuhalten.  

| Datum      | Anwender der KI   | Werkzeug     | Nutzung kurz beschrieben | Übernahme und Anpassung kurz beschrieben |
|------------|-------------------|--------------| --- | --- |
| 2026-04-12 | Eugen Ganscha     | OpenAI Codex | Root-`.gitignore` an uebliche Java/Maven- und IDE-Konventionen angepasst | Vorschlaege geprueft, auf das Repository reduziert und als knappe Ignore-Regeln uebernommen |
| 2026-04-12 | Eugen Ganscha     | OpenAI Codex | Root-`.dockerignore` an uebliche Docker-Konventionen angepasst | Vorschlaege geprueft, auf das Repository reduziert und als knappe Ignore-Regeln uebernommen |
| 2026-04-13 | Nataliia Shcherba | OpenAI Codex | Variablen in `docker compose` und in `application.yaml` von statischen Werten auf Umgebungsvariablen umgestellt sowie eine `.env.example` erstellt | Vorschlaege geprueft, an die Projektstruktur angepasst und fuer die lokale Team-Entwicklung uebernommen |
| 2026-04-18 | Eugen Ganscha     | OpenAI Codex | Das User-ERD in `docs/diagrams/Mira DB ERD.pdf` wurde mit der KI besprochen, um das Verstaendnis der bereits vom Team festgelegten Struktur zu pruefen. Anschliessend wurde auf dieser Grundlage nur der vereinbarte erste Umsetzungsschritt am bestehenden `User`-Modell unterstuetzt: Hinzufuegen der einfachen Felder `emailVerified`, `accountType`, `birthdate` und `accessibilityPreferences` sowie Anlegen trivialer Enums `AccountType` (`CUSTOMER`, `PROVIDER`) und `AccessibilityPreference` (`EASY_LANGUAGE`, `COLOR_BLIND_SUPPORT`) | Technische Umsetzung der zuvor festgelegten einfachen `User`-Erweiterungen und Enums uebernommen; weitergehende Modellierung nicht uebernommen |
|            |                   |              |  |  |
|            |                   |              |  |  |
|            |                   |              |  |  |

## Optionale ergänzende Hinweise

Hier können Sie bei Bedarf kurz ergänzen,

- wie Sie mit fehlerhaften KI-Antworten umgegangen sind,
- welche Vorschläge Sie bewusst verworfen haben,
- in welchen Fällen die KI nur als Sparringspartner diente.

## Eigenständigkeit und Verantwortung

Wir bestätigen, dass die KI-Nutzung in dieser Arbeit vollständig und nach bestem Wissen dokumentiert wurde.
Wir übernehmen die Verantwortung für die fachliche Richtigkeit, die Auswahl der übernommenen Inhalte und die gesamte abgegebene Arbeit.

- Datum:
- Gruppenname:
