* Null objects, not existing objects and other kind of errors and exceptions are not handled or implemented 
in this version

Project must implement the following requirements
1) For Customer Controller

1.1 GET	 customer/{id} 	: readOne
1.2 POST  customer   	: create
1.3 GET	 customers 		: readAll
1.4 PUT  customer/{id}  : updateOne
1.5 DELETE 		customer/{id} 	: deleteOne
1.6 DELETE 		customers 	: deleteAll
1.7 GET	 customer/name/{name} 	: readByName
1.8 PUT  customer/inactive/{id}	:deleteSoft
1.9 GET customers/ageFrom/{ageFrom}/ageTo/{ageFrom}	// NOT IMPLEMENTED YET
1.10 GET customers/pageSize/{size}/page/{id}
1.11 GET customers/best/{size} // NOT IMPLEMENTED YET

2) Same endpoints For Product Controller