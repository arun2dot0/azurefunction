FROM mcr.microsoft.com/azure-functions/java:4-java17-build AS build-env
WORKDIR /src/java-function-app
COPY . .
RUN mvn clean package

FROM mcr.microsoft.com/azure-functions/java:4-java17
ENV AzureWebJobsScriptRoot=/home/site/wwwroot \
    AzureFunctionsJobHost__Logging__Console__IsEnabled=true

COPY --from=build-env ["/src/java-function-app/target/azure-functions/azure-function-app", "/home/site/wwwroot"]