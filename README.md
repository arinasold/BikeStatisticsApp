# BikeStatisticsApp
This is the server-side application for the Helsinki City Bike pre-assigment. It provides an API for managing and retrieving bike journey data. 


## Technologies Used
- Server-side: Java, Spring Boot, MySQL
- Client-side: React, Ag-Grid, Material-UI

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
- **GET /api/journeys:** Retrieves a paginated list of bike journeys.
- **Query Parameters:**
  - **page:** The page number (default: 0).
  - **pageSize:** The number of items per page (default: 10).
  - **sort (optional):** The sort field and direction (e.g., departureDate,asc or distance,desc).
- **GET /api/journeys/{id}:** Retrieves a specific bike journey by ID.

# Database Schema
The server uses a MySQL database with the following schema

