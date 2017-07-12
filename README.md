# SpringBootElasticSearch

SpringBootElasticSearch application is a search web application developed using Spring boot and Elastic search.

Run the project

1. Clone the project.

2. In the command prompt, go to the project directory. Run the command:

mvn clean package -Dmaven.test.skip=true

This command builds the jar file in the target folder.

3. Execute the following command to start the server on port 8080 with embedded elastic search.

java -jar target/enron_indexer.jar -input tuda.json

4. Go to the resource folder in the project structure. Open the index.html in the browser.

5. Type text and press Search button to test the search function.


