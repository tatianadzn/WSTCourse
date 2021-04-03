<h2>Web Services Technology Course
Lab 2</h2>
<p> SOAP standalone service to search people through postgres database (lab1 extension). </p>
<h4>Interactions with the client</h4>
Client shows all available operations and then waits for user input:<br>
---------welcome message-----------<br>
Available operations:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; show < arg1 > .. < arg6 ><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; create < arg1 > .. < arg5 ><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; update < id > < arg1 > .. < arg5 ><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; delete < id ><br>
------end of welcome message-------<br>

User input must be finished by EOF (e.g. Ctrl-D on Linux). <br>
<br><br>
<p><strong>Example</strong> of passing args to input in order to view all people who are recommended for getting a loan:</p>
run standalone service;<br>
run lab2/ClientL2/src/main/java/WebServiceClient.main();<br>
input: show null null null null null True Ctrl-D<br>
output:<br>
ID: 1, name: Петр, surname: Петров, age: 25, state ID: 23, is recommended: true<br>
ID: 2, name: Арсений, surname: Петухов, age: 35, state ID: 43, is recommended: true<br>
...<br>
ID: 15, name: Федор, surname: Авдотьев, age: 21, state ID: 47, is recommended: true<br>
ID: 17, name: Инна, surname: Соловьева, age: 31, state ID: 42, is recommended: true<br>
Total persons: 11
<br>