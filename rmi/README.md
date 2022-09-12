Remote Method Invocation:

	It is a API available in java to facilitate the connection between server and client
	to perform method invocation from Client-Side to the object that is present in Server-Side
	(which can be present in the same machine or remote machine).
	
	To create implement this,
	1) Create the remote interface by extending Remote interface.
		Every methods inside that remote interface must throw remote exception.
	2) Create the class that implements the remote interface and extends the UnicastRemoteObject
		Implement all the methods from interface
	3) Create the Server application
		create the new imlpemented_remote object
		use Naming.rebind() to give the new name to the object by passing the name and object itself.
	4) Create the client application
		create the get the object from server by using Naming.lookup() and pass in the name, and
		cast into the remote interface type. 
		then you can access all the remote object methods from the client side.
		
	5)Create Stub object of the implemented_remote class
		rmic Implemented_remote_className
		
	6) start the rmiregistry
		execute rmiregistry <port_number>
		
	7) start the server application
		java ServerClassName
	8) start the Client application
		java ClientClassName
		
				
