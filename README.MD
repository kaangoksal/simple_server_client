This repository includes a simple example of a server and two clients in java and python.
The server replies to http calls and the clients send http requests to the server.

to start the client:
use pycharm and define the project root as the main folder or modify the import statements in the flask_http_server.py 

`from Server.User import User`   
to    
`from User import User`  

then `python3 flask_http_server.py` will do the magic  

you might have to install flask! This is done with `pip3 install flask`

the python client is simple, just navigate to the Python Client folder and do `python3 client.py`. Make sure that the server is online!   


The java client is a bitch, so I included the .idea folder, open it up with intellij and you should point out the json library so it compiles. This can be done with File -> Project Structure -> Libraries - > + Button and select the jar! Then apply.  

After that I believe you can use the run button on intellij!  


