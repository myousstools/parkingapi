# **Parking REST API**

Spring Boot REST API for processing Parking slots access

## Requirements

* Java 8
* Maven

## Build
   `$ mvn clean package`

## Run

   `$ java -jar target/manager-0.0.1-SNAPSHOT.jar`

## SoapUI Tests

Non regression test cases could be found in  soapui folder.

## API Documentation
This application provides the following APIs: 
### **/slot/assignSlot**
-------- 
#### Method POST
Assign a parking slot if we still hava availability to the given car identified by its car plate number,
if the car has already an active assignment, the same assignment will be returned.
#### input example:
```json
{"carPlateNumber":"AB-1234","slotType":"ELECTRIC_20KW"}
```
#### output example
```json
{
     "success": true,
     "errorCodes": null,
     "errorMessages": null,
     "parkingSoltAssignment": {
         "id": 1,
         "slot": {
             "id": 21,
             "number": "B001",
             "type": "ELECTRIC_20KW"
         },
         "carPlateNumber": "AB-1234",
         "startDateTime": 1566467504209,
         "endDateTime": null
     }
 }
```
#### error codes
| errorCode | Message | description |
| ------    | ------- | ----------- | 
|10001|Missing plate number|| 
|10002|Empty plate number|| 
|10003|Invalid plate number|| 
|10004|Missing Slot type|| 
|20000|Generic Error|Not Handled yet exceptions or runtime exceptions and errors| 
|30001|No more available slot|| 
### **/slot/releaseSlot**
-------- 
#### Method POST
 Release a parking slot, if the car identified by its car platenumber har an active slot.
#### input example:
 ```json
 {"carPlateNumber":"AB-1234"}
#### output example
```json
 {
      "success": true,
      "errorCodes": null,
      "errorMessages": null,
      "slotNumber": "B001",
      "startDateTime": 1566467504209,
      "endDateTime": 1566467670201,
      "amount": 2.1666667,
      "currencyCode": "EUR",
      "billNumber": 3,
      "carPlateNumber": "AB-1234",
      "paymentStatus": "PENDING",
      "prorated": true
  }
```
#### error codes
| errorCode | Message | description |
| ------    | ------- | ----------- | 
|10001|Missing plate number|| 
|10003|Invalid plate number|| 
|20000|Generic Error|Not Handled yet exceptions or runtime exceptions and errors| 
|30002|No active assignment for this car plate number||
-------- 
### **/billing/pay**
-------- 
#### Method POST
Submit the payment information for a released parking slot.
##### input example:

```json
 {"billId":6,"creditCard":{"number":"1111111111111111","ccv":"123", "expirationDate":"01/21","ownerName":"John"}}
```

##### output example
```json
{
      "success": true,
      "errorCodes": null,
      "errorMessages": null,
      "transation": {
          "transactionNumber": 1,
          "status": "SUCCESS",
          "date": 1566467925612
      }
  }
```  
##### error codes
| errorCode | Message | description |
| ------    | ------- | ----------- | 
|20000|Generic Error|Not Handled yet exceptions or runtime exceptions and errors| 
|30008|Missing Credit Card number||
|30009|Invalid Credit Card CCV||
|30010|Invalid expiration date||
|30011|Missing owner name||
|30012|Invalid owner name||
|30014|Missing Credit Card Object||
### Swagger

The API swagger is available here https://app.swaggerhub.com/apis-docs/myousstools/test/1.0.0

Local version could be found here : http://localhost:8585/swagger-ui.html  (Controllers'documentation not working yet)

## TODO
- add security authentication
- add more JUnits
- add https
- fix swagger
- add more details in the swagger 

