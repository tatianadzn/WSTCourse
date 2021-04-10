<h2>Web Services Technology Course
Lab 2</h2>
<p> SOAP standalone service to search people through postgres database (lab1 extension). </p>
<h4>Interactions with the client</h4>
Input placed in the file (change your input file path in WebServiceClient class code). 
Input file should contain list of suitable commands with args (e.g. show null null null null null True).
<br>
Output to the standard output, better to reassign it to file (.. >> ..file.txt on Linux).<br>
<br><br>
Client creates 5 threads with shared BufferedReader from input file and shared service connection.
