
# MTG Market App

Magic the Gathering price checker for Japanese card shop websites. Scrapes websites for card listing data and presents to user in an easy to compare format.

## Run Instructions
**Frontend:** In the `/app` directory, run `npm install`, then run `npm run start`
This will run the UI at `localhost:3000`

**Backend:** `./mvnw dependency:resolve` then `./mvnw clean package` then `./mvnw spring-boot:run`

## Tech Stack

**Client:** React

**Server:** Java 17, Springboot, Redis, SQL database, JSoup


## Screenshots

**Regular widescreen view**
![wide-page](https://raw.githubusercontent.com/MLcraft/mtgmarket/refs/heads/main/screenshots/wide-page.png)

**Two wide page view**
![two-row](https://raw.githubusercontent.com/MLcraft/mtgmarket/refs/heads/main/screenshots/two-row.png)

**Long page view**
![long-page](https://raw.githubusercontent.com/MLcraft/mtgmarket/refs/heads/main/screenshots/long-page.png)
