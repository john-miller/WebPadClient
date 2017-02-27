### Web Pad Client Rest Classes

#### About
All the classes that will be used to communicate with the REST API will live here

#### Script
How's it going?

Ok, here's the fun part.  We're going to begin communicating with our back end server.  This is going to allow us to save and retrieve web pad documents from the cloud.  Here's an outline of what we're working with:

* HalRestTemplateBuilder
Spring's Rest Template is a great way to talk to a REST API. It's very configurable and that it exactly what we are taking advantage of.  This class gives us the ability to uniformaly create rest templates for our backend communications.

* AccountRestClientImpl

* DocumentRestClientImpl
This implementation uses a configured rest template via our **HalRestTemplateBuilder** and contains all the relevant methods for working with web pad documents.