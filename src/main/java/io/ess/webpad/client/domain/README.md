### Web Pad Domain Package

#### About
Here we'll put all the model objects that will be used in the web pad client

#### Script
How's it going?

One of the first steps I take when building a new project is creating the model or domain objects.  Since our GUIs and controllers will be making use of these objects, this helps lay the foundation for our application.  Creating the model objects first forces you to think about the requirements of the overall project.

For instance:

* Our application will be centered around the **Document** domain object.  It will hold information like the document name, content, date created, modified, etc. 
* We will also have the concept of a user which details will be stored in the **Account** object.  Here we can get the username and access tokens that will allow us to communicate with the REST API.
* Application settings will be stored in an object called **ApplicationSettings**.  I'll show you how to load and store this object to file or load it from the Internet via the REST API.

Are you confused? Don't worry, these are just the building blocks.  I'll put it all in context in the course segments to follow.
