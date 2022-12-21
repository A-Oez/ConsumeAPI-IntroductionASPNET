# ConsumeAPI-IntroductionASPNET

The project consumes the created web service in the repository ASP.NET-WebAPI-Introduction. 

![image](https://user-images.githubusercontent.com/60219737/208996684-ba4f79c4-1c2f-473a-94ec-df3a56e5ead8.png)

Calls:
- the endpoints are called and the response is passed to the handlers

Handler:
- the records are manipulated for console output. The classes enter into a contract with the IHandler interface

Factory:
- this is where the instances of the handlers are created. These can now be called in the Manager class via the interface

Manager:
- defines the logic for the console control
