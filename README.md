# Mini Calendly - Repo similar to [Calendly](https://calendly.com/) 
Build a Calendar Slot Booking service, similar to that of Calendly, which allows people
to define their available slots on a day and other people to book them.

### Requirements - 
* You would need to create the backend APIs for this application.
* Create a basic user registration and authentication system.
* Create APIs using which a user can define their available slots for a particular day. Assume that each slot is a fixed hourly slot. For example, 12:00-13:00, 13:00-14:00, etc.
* Create APIs using which a user can book an available slot.
* Show an error response when an unauthenticated user is trying to access the APIs.

### Notes related to the Application
* UserId and UserName are synonymous. We are using full_name to save the User name. It is assumed that every user will have different userid
* When same user is registered again, the information is updated and no error is thrown
* We are assuming that there exists only one session for user. When the user tries to authenticate for multiple times, the existing session information is returned
* For Authentication - a user can get his access-key and secret-key using auth API
* For creating slot/calendar - user needs to be registered in the system and should authenticate his request using accesskey and secretkey
* The access-key and the secret-key has to be passed in the headers
* A Valid Slot would be from current date till next 3 months
* A Valid Slot has to be defined from 100 to 2400 with steps of 100. Other values would be considered as invalid.
* We are restraining the user from defining multiple slots for the same hours. Those requests are just ignored.
* Booking a slot Does Not Require any Authentication. Anyone can book it if knows the userId, date and Available Slot
* We are saving the slot booking with the information of the person who has booked it.
* We are saving all the data in H2(Springboots InMemory DataStore) [https://mini-calendly.herokuapp.com/h2-console](It can be found here on Heroku). For Login - Need to change JDBC:URL to -> jdbc:h2:mem:testdb   

### POSTMAN Collection 
The application is deployed on Heroku and the for major cases, requests are added to the postman collection added below - 
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/77d2af8aedfa969fae94)

### Known Issues/ Limitations
- [ ] For Comparing the User Objects, only UserId and Password are used as for now we are not using email and mobile fields.
- [ ] Using simple Hash function for create hash for password as the other one was not working.
