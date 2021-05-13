<h2>Web Services Technology Course
Lab 5</h2>
<p> REST standalone service to search people through postgres database (lab4 extension). </p>
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
run lab5/ClientL5/src/main/java/App.main();<br>
input: show null null null null null True Ctrl-D<br>
output:<br>
models.services.Person{first name=Альберт, last name=Бартов, age=23, state id=43, is recommended=true} <br>
models.services.Person{first name=Петр, last name=Иванов, age=40, state id=32, is recommended=false} <br>
models.services.Person{first name=Петр, last name=Иванов, age=19, state id=46, is recommended=true} <br>
models.services.Person{first name=Анна, last name=Горячко, age=23, state id=12, is recommended=true} <br>
... <br>
models.services.Person{first name=Абдула, last name=Абдулаев, age=24, state id=34, is recommended=true} <br>
models.services.Person{first name=Евгения, last name=Дин, age=46, state id=3, is recommended=false}<br>