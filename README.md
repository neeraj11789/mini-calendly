# Mini Calendly - Repo similar to [Calendly](https://calendly.com/) 
Build a Calendar Slot Booking service, similar to that of Calendly, which allows people
to define their available slots on a day and other people to book them.

### Requirements - 
* You would need to create the backend APIs for this application.
* Create a basic user registration and authentication system.
* Create APIs using which a user can define their available slots for a particular day. Assume that each slot is a fixed hourly slot. For example, 12:00-13:00, 13:00-14:00, etc.
* Create APIs using which a user can book an available slot.
* Show an error response when an unauthenticated user is trying to access the APIs.

### Notes related to the application
* UserId and UserName are synonymous. We are using full_name to save the User name. It is assumed that every user will have different userid
* When same user is registered again, the information is updated and no error is thrown
* We are assuming that there exists only one session for user. When the user tries to authenticate for multiple times, the existing session information is returned
* 

### To Do -
- [ ]  Add DB Schema and limitations in the DOC
- [ ]  Fix - Hash Issue with Password

### Known Issues/ Constraints
- [ ] For Comparing the User Objects, only UserId and Password are used as for now we are not using email and mobile fields.
- [ ] Using simple Hash function for create hash for password as the other one was not working. Need to check
