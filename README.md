# Mini Calendly - Repo similar to [Calendly](https://calendly.com/) 
Build a Calendar Slot Booking service, similar to that of Calendly, which allows people
to define their available slots on a day and other people to book them.

### Requirements - 
* You would need to create the backend APIs for this application.
* Create a basic user registration and authentication system.
* Create APIs using which a user can define their available slots for a particular day. Assume that each slot is a fixed hourly slot. For example, 12:00-13:00, 13:00-14:00, etc.
* Create APIs using which a user can book an available slot.
* Show an error response when an unauthenticated user is trying to access the APIs.

### APIs
The system is designed in such a way that a user needs to register in the system first on the platform. After successful registration
a user can get his secretkey and accesskey in order to interact with the platform. For now, there is no expiry of the keys, once registered,
the key can be used for any amount of time.

A user can define his availablity in the calendar by using an api to create-slots. As mentioned in the requirement, it is can we any 1 hour starting form 100 to 2400.
For now, we are not accepting any request apart from these. Also, a valid slot is defined between any period from today to next 3 months.
Any anonymous user, who knows the userid for the person in system can book a slot with him if it is available. Slot Constraints remain same in this case as well.

Here are the list of APIs and required params -

* /register
API to create new user
```
Sample Request -

{
	"userName": "neeraj34",
	"password": "test@12345",
	"confirmPassword": "test@12345"
}

Sample Response -

{
    "code": "RESOURCE_CREATED",
    "payload": {
        "requestId": "2a04cedf-fd0e-492b-acb9-105a4927130d",
        "message": "User Information Saved Successfully"
    }
}

The username, password and confirmPassword are mandatory parameters. Other params are name and email -

{
	"userName": "trisha16",
	"password": "test@12345",
	"confirmPassword": "test@12345",
	"name": "Triha Shah",
	"email": "trisha3@gmail.com"
}

```
* /auth
API to create get user credentials
```
Sample Request -
{
	"username": "trisha16",
	"password": "test@12345"
}

Sample Response -
{
    "code": "SUCCESS",
    "payload": {
        "requestId": "e75ec139-34d8-4d25-9a45-975cf8df44d9",
        "session": {
            "userId": "trisha16",
            "accessKey": "c01e9846-644c-4155-8ed0-d5694e9497aa",
            "secretKey": "1b5ebe43-928d-4145-ab75-1cf99a888300"
        }
    }
}

```
* /create-slots
API for the user to define his available slots -
```
Sample Request -
{
	"user": "trisha16",
	"date": "2020-04-15",
	"slots":[
		{"startTime":2000, "endTime":1900},
		{"startTime":1400, "endTime":1500},
		{"startTime":2300, "endTime":2400},
		{"startTime":2200, "endTime":2300}
	]
}

Sample Response -
{
    "code": "RESOURCE_CREATED",
    "payload": {
        "requestId": "4585bc03-2a77-4c38-9b93-127e430eabd3",
        "message": "Slots Successfully added to the calendar"
    }
}
```
* /book-slot
API to book slot - can be booked by any anonymous user
```
Sample Request -
{
	"user": "trisha16",
	"date": "2020-04-15",
	"slot": {"startTime":1400, "endTime":1500},
	"requestfromUser": "neeraj"
}

Sample Response -
{
    "code": "SUCCESS",
    "payload": {
        "requestId": "edc1acb1-731a-40ad-a43e-6b7698d92fbc",
        "message": "Slot Successfully booked and updated"
    }
}
```

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
* We are saving all the data in H2 Springboots InMemory DataStore. [It can be found here on Heroku](https://mini-calendly.herokuapp.com/h2-console). For Login - Need to change JDBC:URL to -> jdbc:h2:mem:testdb

### Known Issues/ Limitations
* For Comparing the User Objects, only UserId and Password are used as for now we are not using email and mobile fields.
* Using simple Hash(String hashcode) function for create hash for password as the other one was not working
* Limited fields are used in DB and objects for simplification
