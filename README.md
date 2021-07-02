# SpringBoot2CrudPostgrese
CrudExample with Swagger ,logger,exception,transaction,JPQL,ITEXT,APACHEPOI



# Create User

# POST call
  http://localhost:8080/crudapp/saveuser
  
  request body  in postman raw JSON
  
 # {"id":2345, "username":"mahesh"} 
 
 Reponse Sucess
 
 -----------------------------------------
 # GetUsers. GET Call 
 
 http://localhost:8080/crudapp/getusers
 
 Reponse 
 # [
    {
        "id": 123,
        "username": "rakesh"
    },
    {
        "id": 2345,
        "username": "mahesh"
    },
    {
        "id": 2,
        "username": "prajna Singh"
    }
# ] 

------------------------------------------------------

# PUT call to update User

url http://localhost:8080/crudapp/updateuser

 
  request body  in postman raw JSON
  
 # {"id":2345, "username":"mahesh"} 
 
 -------------------------------------------------
 
 # delete call delete user by id
 
url  http://localhost:8080/crudapp/delete/1


Reponse deleted

----------------------------------------

# Get Call For get user by id
url http://localhost:8080/crudapp/getuser/123

Response. 
{
    "id": 123,
    "username": "rakesh"
}

 
