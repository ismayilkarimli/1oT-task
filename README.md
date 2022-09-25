# Estonian Weather Forecast Application

A simple application developed using Vue.js and Spring Boot to display weather forecast on Estonian cities using 3rd party API.

## Installation

Clone the repository:

```bash
git clone https://github.com/ismayilkarimli/1oT-task.git
```

## Usage

Start Spring Boot application:

1. Change directory to `api/` (assuming you're in project's base directory):
```bash
cd ./api/
```
2. Then run the application using gradle:
```bash
./gradlew bootRun
```
or
```bash
gradle bootRun
```
3. Change directory to `./front-end/1oT-weather/` (assuming you're in project's base directory):
```bash
cd ./front-end/1oT-weather/
```
4. Start Vue application:
```bash
npm run dev
```

Both applications use their respective default ports. Vue app on 5173 while Spring Boot application 8080:  

[Vue application](http://127.0.0.1:5173/)  
[Spring Boot application](http://127.0.0.1:8080/)

## Credits
API used for gathering the forecast data: [http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng](http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng)
