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
Below show how calls are made via postman.

Note how to enter the parameters it is necessary to separate the route from the parameter entered by means of a question mark (?).
After typing everything correctly, press the **SEND** button on the right.

<a name="1"></a>
1.   **/allEvents**

![image](https://user-images.githubusercontent.com/91560500/158759301-7b0e4809-fecf-4627-b9d7-76b7d5b52fb7.png)

<a name="2"></a>
2.   **/countryEvents**

![image](https://user-images.githubusercontent.com/91560500/158759515-0c236e23-8b4d-4c2f-afe1-f4a02de24aff.png)

<a name="3"></a>
3.   **/stateEvents**

![image](https://user-images.githubusercontent.com/91560500/158759664-69bc1f82-701d-42df-be4d-7891352ec42a.png)

<a name="4"></a>
4.   **/cityEvents**

![image](https://user-images.githubusercontent.com/91560500/158759758-60c0efcf-c8bc-40b2-861a-76bb020154b1.png)

<a name="5"></a>
5.   **/AllStats**

![image](https://user-images.githubusercontent.com/91560500/158759803-7926ac8b-e0eb-4534-ae19-f3c02868b393.png)

<a name="6"></a>
6.   **/CountryStats**

![image](https://user-images.githubusercontent.com/91560500/158759850-ed319e30-fa1c-4211-a796-7ff23803bcf7.png)

<a name="7"></a>
7.   **/StateStats**

![image](https://user-images.githubusercontent.com/91560500/158759880-9eeedc9d-d413-4390-a2e3-e28a6abe3c7c.png)

<a name="8"></a>
8.   **/CityStats**

![image](https://user-images.githubusercontent.com/91560500/158759917-e1e933ae-e070-4267-aa16-664de61e7754.png)


## **GUI**
The GUI is the Graphical User Interface with which users interact with computers and computer programs. In this program we have included one to have a graphic feedback that facilitates the use of TicketAdvisor

TicketAdvisor was originally supposed to collect events relating to Canada alone. We preferred to extend it to all states, but to respect the initial trace we decided to leave the following default parameters:

:white_check_mark: Events of --> **CANADA** (Country)

:white_check_mark: Events of --> **ONTARIO** (State)

:white_check_mark: Events of --> **Toronto** (City)

Below are some pictures of how the interface looks.

![image](https://user-images.githubusercontent.com/91560500/158747755-3fedf71a-8deb-41b4-85c2-6dbc984adfc3.png)

On the right of the frame we find the buttons that must be pressed to obtain the statistics of what is indicated on the left. In the first case, events all over the world, in the following ones it depends on the compilation we insert in the boxes.
If nothing is entered, the search will be carried out on the country of Canada, state of Ontario, city of Toronto.

It should be noted that **the entries are not random, but respect a precise syntax.** It is no coincidence that for entering the country or state, the GUI requires the identification code (country code, state code) and not the full name.

![image](https://user-images.githubusercontent.com/91560500/158751281-2bc2ddb0-2adf-4b82-a2c5-28a0828d7071.png)

If we omit the input of the parameters, the statistics of canada are made as shown above in the figure. As you can see there are statistics of all kinds: total events, monthly average, month with more events and the number of events for each month.

⚠️ **ATTENTION!!!** - The GUI does not entirely replace the functioning of Postman, as it only takes care of printing the statistics of the events on the screen. Therefore to get the JSONObject of the events it is necessary to use [Postman](https://www.postman.com/).

## **UML**

## **Credits**
All this was possible through the use of an **API** provided by the US company Ticket Master, through the **Spring Boot** framework and the **Postman** simulation platform. The program was developed through the **Eclipse** development environment.

##
:white_check_mark: [Api_Ticket Master](https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2)
:white_check_mark: [Spring Boot](https://start.spring.io/)
:white_check_mark: [Postman application](https://www.postman.com/)
:white_check_mark: [Eclipse](https://www.eclipse.org/downloads/)

## **Authors**
Surname | Name | Github | E-mail
--- | --- | --- | ---
Inverni | Roberto | [R0b1n404](https://github.com/R0b1n404?tab=repositories) | robertoinverni2002@gmail.com
Tridici | Daniel | [Dan13L01](https://github.com/Dan13L01?tab=repositories) | daniel.tridici@hotmail.com

📑 [Back to index](#back-to-index)
