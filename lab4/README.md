<h2> Web Services Technology Course Lab 4 </h2>
<p> REST standalone and j2ee services to search people through postgres database. </p>
 <strong>API:</strong><br>
"/persons" GET (returns all persons suitable for request param)

<p>To interact with client you need to pass arg1 arg2 arg3 arg4 arg5 arg6 to input of running client app where arg1 is id, arg2 is first name, arg3 is last name, arg4 is age, arg5 is US state id and arg6 is boolean for if person is recommended for getting a loan.</p>
<br>
<p><strong>Example</strong> of passing args to input in order to view all people who are recommended for getting a loan:</p>
run standalone service or deploy j2ee;<br>
run lab4/ClientL4/src/main/java/App.main();<br>
input: null null null null null True <br>
output:<br>
ID: 1, name: Петр, surname: Петров, age: 25, state ID: 23, is recommended: true<br>
ID: 2, name: Арсений, surname: Петухов, age: 35, state ID: 43, is recommended: true<br>
...<br>
ID: 15, name: Федор, surname: Авдотьев, age: 21, state ID: 47, is recommended: true<br>
ID: 17, name: Инна, surname: Соловьева, age: 31, state ID: 42, is recommended: true<br>
<br>
_______________________________________________________________________________
<p>J2EE deploying configurations: <br>
  Eclipse Glassfish 5.1 + add jdbc driver postgresql-9.0-802.jdbc4.jar or any other suitable to path_to/glassfish5/glassfish/domains/domain1/lib/ + to path_to/glassfish5/glassfish/config/asenv.cong add AS_JAVA="intellij idea Project Structure -> SDKs -> path to your java" <br>
</p>
