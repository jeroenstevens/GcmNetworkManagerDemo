# GcmNetworkManagerDemo
Example of data syncing without SyncAdapter

pre-21 (21 needs JobScheduler)

##Stub webserver
http://search.maven.org/remotecontent?filepath=by/stub/stubby4j/3.1.3/stubby4j-3.1.3.jar

```
#stubby.yaml

-  request:
     url: ^/phones$
   response:
     status: 200
     headers:
       content-type: application/json
     body: >
       {
         "phones": [
           {
             "id": 1,
             "model": "Samsumg Galaxy s4",
             "brand": "Samsung"
           },
           {
             "id": 2,
             "model": "Nexus 5",
             "brand": "Google"
           }
         ]
       }

```

```
java -jar stubby4j-3.1.3.jar --data stubby.yaml 
```

localhost:8882/phones

On phone (Same wifi):
http://10.0.2.2:8882/phones

## Run app on phone

## Should update every 10-30 seconds
