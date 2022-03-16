<h1 align="center"> TicketAdvisor </h1>

<p align="center">
  <img src="https://user-images.githubusercontent.com/91560500/158594779-6c675e9d-6ef6-4a41-98b3-f1b09ee1b8d8.png" width="400px" height="350px"/></p>
 
<a name="back-to-index"></a>
## Index
* [Description](#description)
* [Route](#route)
* [Examples](#examples)
* [UML](#uml)
* [Credits](#credits)
* [Authors](#authors)


## **Description**
TicketAdvisor aims to monitor events in all countries around the world. Monitoring takes place through the return of all events in JSON format to be used to create statistics. 

## **Route**
> This application use only the `GET` request

Route | Type | Parameter | Description
---- | ---- | ---- | ---- 
/allEvents | ` GET ` | --- | Returns the total events of the world
/countryEvents | ` GET ` | countryCode | Returns the total events of the country
/stateEvents | ` GET ` | stateCode | Returns the total events of the state
/cityEvents | ` GET ` | city | Returns the total events by city
/AllStats | ` GET ` | --- | Returns statistics for the whole world 
/CountryStats | ` GET ` | countryCode | Returns statistics relating to a specific country
/StateStats | ` GET ` | stateCode | Returns statistics relating to a specific state of Canada
/CityStats | ` GET ` | city | Returns statistics relating to a specific city

To use these paths you need to use the [Postman application](https://www.postman.com/) that allows you to enter the correct path using the address:
```
http://localhost:8080
```

After that it is necessary to insert the routes shown in the table with the respective parameters.

⚠️ Be sure to select **GET** as the request type on [Postman](https://www.postman.com/)

## **Examples**
1.   **/allEvents**
2.   **/countryEvents**
3.   **/stateEvents**
4.   **/cityEvents**
5.   **/AllStats**
6.   **/CountryStats**
7.   **/StateStats**
8.   **/CityStats**

## **UML**

## **Credits**
All this was possible through the use of an **API** provided by the US company Ticket Master, through the **Spring Boot** framework and the **Postman** simulation platform.

##
:white_check_mark: [Api_Ticket Master](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2)
:white_check_mark: [Spring Boot](https://start.spring.io/)
:white_check_mark: [Postman application](https://www.postman.com/)

## **Authors**
Surname | Name | Github | E-mail
--- | --- | --- | ---
Inverni | Roberto | [R0b1n404](https://github.com/R0b1n404?tab=repositories) | robertoinverni2002@gmail.com
Tridici | Daniel | [Dan13L01](https://github.com/Dan13L01?tab=repositories) | daniel.tridici@hotmail.com

📑 [Back to index](#back-to-index)
