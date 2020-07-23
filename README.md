# Counting words

The solution is built and tested against OpenJDK 8. Installed Maven is a prerequisite.
You can check the solution out locally and run using the following commands (all from the project root):

`mvn package`

This will build the solution and execute the unit tests.
Next run the openliberty server in the dev mode. This will allow running integration tests 
(those really invoking the rest endpoint, doing the full roundtrip):

`mvn liberty:dev`

When the server is up and running, you can press Enter in the console and the server will run the integration tests.

While it is still running in the dev mode, you can manually invoke the endpoint by clicking the following urls:

* http://localhost:9080/wordfreq/calculateHighestFrequency?text=The%20sun%20shines%20over%20the%20lake
* http://localhost:9080/wordfreq/calculateFrequencyForWord?text=The%20sun%20shines%20over%20the%20lake&word=lake
* http://localhost:9080/wordfreq/calculateMostFrequentNWords?text=The%20sun%20shines%20over%20the%20lake&n=10

For the sake of easiness of manual testing in the browser I chose to use the GET requests, in a real application
those should be POSTs because of the potentially large payloads.

The core logic implementation is in `com.ordina.wordfreq.services.WordFrequencyAnalyzerImpl`, covered by unit tests.
JakartaEE implementation is in `com.ordina.wordfreq.rest.WordFrequencyService`, covered by an integration test.

