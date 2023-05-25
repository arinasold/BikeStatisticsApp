# BikeStatisticsApp
This is the server-side application for the Helsinki City Bike pre-assigment. It provides an API for managing and retrieving bike journey data. 
You can take a look of web application [here](https://helsinki-city-bike-web.herokuapp.com/) and see the code  [here](https://github.com/arinasold/BikeStatisticsFrontEnd)
## Technologies Used
- Server-side: Java, Spring Boot, MySQL
- Client-side: React, Ag-Grid, Material-UI
- Applications deployed on Heroku
- Database hosted by Heroku ClearDB

## Journeys and stations views

- View a list of bike journeys and stations 
- In journey view there are departure and return stations, covered distance in kilometers and duration in minutes
- Sort journeys and stations by various criteria
- Paginated with a customizable page size.
## Single station view
- Station name
- Total number of journeys starting from the station
- Total number of journeys ending at the station
- The average distance of a journey starting from the station
- The average distance of a journey ending at the station
- Top 5 most popular return stations for journeys starting from the station
- Top 5 most popular departure stations for journeys ending at the station

# API Endpoints
## Journey
- **GET /api/journeys:** Retrieves a paginated list of bike journeys.
- **Query Parameters:**
  - **page:** The page number (default: 0).
  - **pageSize:** The number of items per page (default: 25).
  - **sort (optional):** The sort field and direction (default: departureDate,desc).
## Station
- **GET /api/stations:** Retrieves a paginated list of stations.
- **GET /api/stations/{id}:** Retrieves a specific station by ID.
- **Query Parameters:**
  - **page:** The page number (default: 0).
  - **pageSize:** The number of items per page (default: 10).
  - **sort (optional):** The sort field and direction (default: id,asc).
# Database Schema
For the exercise I am using only one dataset of journey data from given CSV files.
The server uses a MySQL database with the following schema
## Journey
| Name                  | Type      |  Relations  |
| -------------         | ----------|-------------|
| id                    | bigint    | PRIMARY KEY |
| departure_date        | datetime  |             |
| return_date           | datetime  |             |
| distance              | int       |             |
| duration              | int       |             |
| departure_station_id  | bigint    |   FOREIGN KEY (`return_station_id`) REFERENCES `station` (`id`)          |
| return_station_id     | bigint    |   FOREIGN KEY (`departure_station_id`) REFERENCES `station` (`id`)          |
## Station
| Name                  | Type      |  Relations  |
| -------------         | ----------|-------------|
| id                    | bigint    | PRIMARY KEY |
| name        | varchar  |             |
| departure_journeys_count              | int       |             |
|return_journeys_count              | int       |             |

