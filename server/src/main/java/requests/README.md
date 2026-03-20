# Api requests

This directory contains the functions that allow the application to make API calls.

## Function calls

### GET

#### Parameters

- url (String)
  - The URL or IP address including the port number and name of the API call of the server to which the API call is being made to.

#### Description

Sends a GET request to the specified API returning the contents of the returned request and an error if unsuccessful.

#### Example

```java
String ClientIP = "localhost:5000";
requests.GET(ClientIP + "/api/info/hardware/ram");
```

### POST

#### Parameters

- url (String)
  - The URL or IP address including the port number and name of the API call of the server to which the API call is being made to.

- args (HashMap<String, String>)
  - Any additional arguments that the API call needs.

#### Description

Sends a POST request to the specified API returning the contents of the returned request and an error if unsuccessful.

#### Example

```java
String ClientIP = "localhost:5000";
HashMap<String,String> ApiInput = new HashMap<String,String>();
ApiInput.put("username", "DemoUsername");
ApiInput.put("duration", "1");
requests.POST(ClientIP + "/api/info/hardware/ram", ApiInput);
```
