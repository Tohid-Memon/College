# Maharashtra Tourism Planner

A simple college mini-project built with Java 21, Spring Boot, Maven, Spring Data JPA, H2, HTML, CSS and vanilla JavaScript. It helps users explore Maharashtra destinations, see sample attractions and hotel suggestions, estimate trip costs, and create a basic itinerary.

> **Important demo-data note:** Hotel suggestions and their prices are illustrative sample data, not live listings. Prices, entry fees, access rules, timings and transport costs can change. Confirm details with official/local sources before travelling. This app does not book hotels or transport.

## Features

- Search 50 seeded Maharashtra destinations with case-insensitive partial search and suggestions.
- View destination details and relevant attractions for selected destinations.
- View sample budget, standard and premium hotel suggestions for selected destinations.
- Calculate accommodation, food, transportation and miscellaneous costs in INR.
- Generate a simple 1–3 day itinerary from stored attractions.
- Friendly unknown destination and error states.
- Responsive interface; frontend served by Spring Boot from the same origin.
- Persistent local H2 database, with sample data seeded only when the database is empty.

## Technology

- Java 21
- Spring Boot 3.5.6
- Maven
- Spring Web, Spring Data JPA, Bean Validation
- H2 file database
- HTML5, CSS3, JavaScript
- JUnit 5 / Spring Boot Test

## Prerequisites

- JDK 21 installed and available on `PATH` (`java -version` should show 21).
- Maven 3.9+ installed and available on `PATH`.
- Internet access on the first build so Maven can download dependencies.

A Maven Wrapper is not included because it could not be generated and verified in the build environment used to prepare this project. Install Maven, or generate a wrapper locally with `mvn wrapper:wrapper` if your Maven installation supports it.

## Run in IntelliJ IDEA

1. Install a JDK 21 distribution (for example, Microsoft OpenJDK 21 or Temurin 21). JDK 17 is not sufficient for this project.
2. Extract the ZIP and open the `Maharashtra-Tourism-Planner` folder — the folder containing `pom.xml` — in IntelliJ IDEA.
3. Go to **File → Project Structure → Project** and set **SDK** to JDK 21. If it is missing, choose **Add SDK → JDK** and select the JDK 21 installation directory.
4. In **File → Project Structure → Modules**, select `tourism-planner` and set **Module SDK** to **Project SDK (21)** or directly select JDK 21. Do not leave it assigned to Microsoft OpenJDK 17.
5. Go to **Settings → Build, Execution, Deployment → Build Tools → Maven → Runner** and set **JRE** to the project JDK (21). Check Maven importing uses the project JDK as well.
6. In the Maven tool window, click **Reload All Maven Projects**.
7. Run `java -version` in the IntelliJ terminal and confirm it reports version 21. Then run `TourismPlannerApplication.java` or use the terminal command below.
8. Open **http://localhost:8080**.

The Maven configuration explicitly targets Java 21 through `java.version`, `maven.compiler.release`, and the compiler plugin's `release` setting. These settings do not install JDK 21 or override an IntelliJ module that is still assigned to JDK 17; configure the IDE SDK as described above.

## Run from terminal

From the folder containing `pom.xml`:

```bash
mvn spring-boot:run
```

Build a runnable JAR:

```bash
mvn clean package
java -jar target/tourism-planner-1.0.0.jar
```

Run automated tests:

```bash
mvn test
```

## H2 console

- URL: **http://localhost:8080/h2-console**
- JDBC URL: `jdbc:h2:file:./data/tourismdb`
The database uses a local file-based H2 URL. Do not add `AUTO_SERVER=TRUE` alongside `DB_CLOSE_ON_EXIT=FALSE` for the bundled H2 version, because that option combination is unsupported.
- User: `sa`
- Password: leave blank

The database files are created under the `data` directory relative to the working directory. Stop the app before moving or deleting those files. To reset demo data, stop the app and delete the local `data` directory; it will be recreated at startup.

## API examples

- `GET /api/destinations` — list all seeded destinations.
- `GET /api/destinations/search?query=math` — partial, case-insensitive search; no matches returns `[]`.
- `GET /api/destinations/by-name?name=Matheran` — look up a destination by exact name, case-insensitively; unknown name returns 404.
- `GET /api/destinations/3` — get destination by ID (IDs depend on local database state).
- `GET /api/destinations/3/attractions` — attraction list.
- `GET /api/destinations/3/hotels` — sample hotel list.
- `GET /api/destinations/3/itinerary?days=2` — simple itinerary.
- `POST /api/budget/calculate` — calculate budget.

Budget request example:

```json
{
  "travellers": 2,
  "days": 2,
  "hotelCategory": "standard",
  "rooms": 1,
  "transportation": 1500,
  "dailyFoodPerPerson": 500,
  "miscellaneous": 500
}
```

For this example, accommodation is ₹2,500, food is ₹2,000, transport is ₹1,500, miscellaneous is ₹500, and the estimated total is ₹6,500 (₹3,250 per person). One-day trips use zero hotel nights.

## Project structure

```text
src/main/java/com/maharashtra/tourism/
  config/       Sample data initialization
  controller/   REST API endpoints
  dto/          Budget request and response models
  entity/       Destination, Attraction and Hotel JPA entities
  exception/    Central API error handling
  repository/   Spring Data JPA repositories
  service/      Search, itinerary and budget logic
src/main/resources/
  application.properties
  static/       index.html, styles.css, app.js
src/test/java/  Spring Boot tests
```

## Notes and limitations

- The app intentionally does not call external map, booking, weather or hotel APIs. It works without API keys.
- Attraction and hotel data is more detailed for a subset of destinations; other destinations display a clear empty-data message.
- Hotel rates used in the budget calculator are demo category averages, not quotes from individual live hotels.
- The itinerary arranges stored attractions in a simple sequence and is not geographically optimized.
- H2 console is enabled for local development only. Do not expose this demo console to a public network.
- The app has no authentication, payments, reservations or external services by design.
