<h1 align="center"> Ticket Advisor </h1>

## Index
* [Description](#description)
* [Route](#route)
* [Examples](#examples)
* [UML](#uml)
* [Credits](#credits)
* [Authors](#authors)


## **Description**
Ticket Advisor aims to monitor events in all countries around the world. Monitoring takes place through the return of all events in JSON format to be used to create statistics. All this was possible through the use of an API provided by the US company Ticket Master and through the springboot framework
##
:white_check_mark: [Api_Ticket Master](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2)
:white_check_mark: [Spring Boot](https://start.spring.io/)

## **Route**
> This application use only the `GET` request

Route | Type | Parameter | Description
---- | ---- | ---- | ---- 
/events | ` GET ` | --- | Returns the total events of Canada
/cityEvents | ` GET ` | city | Returns the total events by city
/StateStats | ` GET ` | stateCode | Returns statistics relating to a specific state of Canada
/CountryStats | ` GET ` | countryCode | Returns statistics relating to a specific country
/CityStats | ` GET ` | city | Returns statistics relating to a specific city

To use these paths you need to use the [Postman application](https://www.postman.com/) that allows you to enter the correct path using the address:
```
http://localhost:8080
```

After that it is necessary to insert the routes shown in the table with the respective parameters.

⚠️ Be sure to select **GET** as the request type on [Postman](https://www.postman.com/)

## **Examples**
1.   **/events**
