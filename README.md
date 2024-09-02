### Buidling Azure Function App as Service

Container based example based on Azure Function
to be deployed as Function-as-a-Service available in Azure

Docker build is multistage , You can build it locally for validation
but its not required . 

First stage of Docker build has the artifacts required for the second stage

Build Docker image and push to ACR
```commandline
docker build -t hello-azure-function-app . --progress=plain --no-cache

az login
az acr login --name myacr

docker  build -t myacr.azurecr.io/hello-azure-function-app:1.0 --push .    

```

### Function App Deployment
I want to deploy using az command line , but I ran into issues .So created 
storage and the function using UI 

### Testing

```
curl --location 'https://appurl.eastus.azurecontainerapps.io/api/HttpTrigger' \
--header 'x-functions-key: functionkey' \
--header 'Content-Type: application/json' \
--data '{
  "input": null
}'
```