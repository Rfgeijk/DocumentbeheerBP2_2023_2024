# DocumentBeheerSysteem

Het DocumentBeheerSysteem (DBS) is een platform ontworpen voor effectief beheer, opslag en samenwerking rond documenten. Het stelt gebruikers in staat om documenten te uploaden en te downloaden binnen een gestructureerde omgeving.

## Aan de slag

Volg de onderstaande stappen om het DocumentBeheerSysteem op lokaal niveau te installeren en op te starten.

### Vereisten

-   Java Development Kit (JDK) geïnstalleerd
-   XAMPP geïnstalleerd en actief. Start de XAMPP-server en PhpMyAdmin via het controlepaneel door te klikken op "Start" naast de modules Apache en MySQL.
-   [PhpMyAdmin](https://www.phpmyadmin.net/) toegankelijk via de XAMPP-installatie
- 

### Installatie

1.  Kloon de repository van hieronder naar je lokale machine. Je kunt hiervoor GitHub desktop gebruiken, maar ook Sourcetree als je dat makkelijker vindt!
     https://github.com/Rfgeijk/DocumentbeheerBP2_2023_2024.git
    
2.  Open het project in jouw Java IDE (Ik gebruik persoonlijk IntelliJ).
    
3.  Zorg ervoor dat de benodigde Java-bibliotheken en -afhankelijkheden zijn geïnstalleerd zoals bijvoorbeeld de mysql-connector 8.2.0 om toegang te krijgen tot de database.

	Deze connector kun je installeren door in IntelliJ linksbovenin op de streepjes te gaan staan en
	dan te klikken op "File" en daarna "project structure". Hierna ga je naar "modules" en klik je op
	het + knopje en zoek je op mysql-connector. Hierna moet je de versie 8.2.0 pakken en
	installeren. Dan zou je hem moeten hebben!
	
4.	Open Phpmyadmin via xampp (klik op admin naast MySQL in het menu) en maak een nieuwe database aan  noem deze "documentbeheer" en importeer het SQL-file met de gegevens van de database hierin.
    
5.  Configureer de database-verbinding in je JavaFX-applicatie om te verwijzen naar de PhpMyAdmin-database die wordt gehost door XAMPP.
    
6.  Start de JavaFX-applicatie.
    

## Gebruik

1.  Open de JavaFX-applicatie.
    
2.  Meld je aan met de vereiste referenties.
	 Username: SystemGuardian
	 Wachtwoord: Pro2024@Secure!
    
3.  Navigeer naar het dashboard of de benodigde pagina's en begin met het uploaden en downloaden van je documenten.

4. Als je je document hebt geüpload kun je het venster sluiten en hierna op de "Searchpage" (de zoekpagina) zoeken of hij er tussen staat om te controleren of je hem goed hebt geüpload! Op de Searchpage kun je tegelijkertijd ook alle documenten zien die je hebt geüpload, je kunt ze verwijderen, updaten met nieuwe informatie of downloaden. 

5.  Als je het document wil updaten moet je bovenin de titel van het bestand zetten wat je wilt aanpassen, daarna kun je de rest invullen en op de "update" knop klikken. Je kunt je document daarna controleren door opnieuw de searchpage te openen en te kijken of het gelukt is. 
    

## Database Configuratie

Pas de databaseconfiguratie aan in de Java-code om deze aan te passen aan jouw XAMPP/PhpMyAdmin-installatie. De databaseconfiguratie bevindt zich in de klasse `Database`.

Het DBS ondersteunt de volgende database-configuratieopties:

-   Database URL: `jdbc:mysql://localhost:3306/documentbeheer`
-   Gebruikersnaam: `"root"`
-   Wachtwoord: `" "`

Pas de databaseconfiguratie aan in de Java-code om deze aan te passen aan jouw XAMPP/PhpMyAdmin-installatie.

De connectie met mijn database heb ik zelf zo gelegd:
``` private Connection conn;  
  
public Database(){  
    try {  
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/documentbeheer",  
                "root", "");    
    } catch (SQLException e) {  
        System.out.println(e);  
      
  }  
}   
 ```


-   [JavaFX](https://openjfx.io/)
-   XAMPP
-   [PhpMyAdmin](https://www.phpmyadmin.net/)

Neem gerust contact met mij op via [rfg.vaneijk@ad-academie.nl] voor vragen of ondersteuning.
