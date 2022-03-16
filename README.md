<h1 align="center"> TicketAdvisor </h1>

<p align="center">
  <img src="https://user-images.githubusercontent.com/91560500/158594779-6c675e9d-6ef6-4a41-98b3-f1b09ee1b8d8.png" width="400px" height="350px"/></p>
 
<a name="back-to-index"></a>
## Index
* [Description](#description)
* [Route](#route)
* [Examples](#examples)
* [GUI](#gui)
* [UML](#uml)
* [Credits](#credits)
* [Authors](#authors)


## **Description**
TicketAdvisor aims to monitor events in all countries around the world. Monitoring takes place through the return of all events in JSON format to be used to create statistics. 

## **Route**
> This application use only the `GET` request

Route | Type | Parameter | Description
---- | ---- | ---- | ---- 
[/allEvents](#1) | ` GET ` | --- | Returns the total events of the world
[/countryEvents](#2) | ` GET ` | countryCode | Returns the total events of the country
[/stateEvents](#3) | ` GET ` | stateCode | Returns the total events of the state
[/cityEvents](#4) | ` GET ` | city | Returns the total events by city
[/AllStats](#5) | ` GET ` | --- | Returns statistics for the whole world 
[/CountryStats](#6) | ` GET ` | countryCode | Returns statistics relating to a specific country
[/StateStats](#7) | ` GET ` | stateCode | Returns statistics relating to a specific state of Canada
[/CityStats](#8) | ` GET ` | city | Returns statistics relating to a specific city

To use these paths you need to use the [Postman application](https://www.postman.com/) that allows you to enter the correct path using the address:
```
http://localhost:8080
```

After that it is necessary to insert the routes shown in the table with the respective parameters.

⚠️ Be sure to select **GET** as the request type on [Postman](https://www.postman.com/)

## **Examples**
<a name="1"></a>
1.   **/allEvents**
<a name="2"></a>
2.   **/countryEvents**
<a name="3"></a>
3.   **/stateEvents**
<a name="4"></a>
4.   **/cityEvents**
<a name="5"></a>
5.   **/AllStats**
<a name="6"></a>
6.   **/CountryStats**
<a name="7"></a>
7.   **/StateStats**
<a name="8"></a>
8.   **/CityStats**

## **GUI**
The GUI is the Graphical User Interface with which users interact with computers and computer programs. In this program we have included one to have a graphic feedback that facilitates the use of TicketAdvisor

⚠️ **ATTENTION!!!** - The GUI does not entirely replace the functioning of Postman, as it only takes care of printing the statistics of the events on the screen. Therefore to get the JSONObject of the events it is necessary to use [Postman](https://www.postman.com/).


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
