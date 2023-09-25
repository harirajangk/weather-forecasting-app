# weather-forecasting-app
## Getting Started

**Steps for Database**

Execute the below queries in MySql Database

drop database weather_forecast;

create database weather_forecast;

**Steps for Project**

1. Clone this repository
2. Import the code to IDE
3. Provide the username, password, your openweathermap_api_key
4. Build the project 
5. Run the application
6. Open your browser and navigate to `http://localhost:8080`
7. Enter the valid City, Location and search for details.


**Database**
History will be stored in concerned table and it can be viewed by the below query.

select * from weather_forecast.weather_data;

