package com.azure.example;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;

import java.util.Optional;

public class HttpTriggerFunction {

    @FunctionName("HttpTrigger")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger function processed a request.");

        String name = request.getQueryParameters().get("name");
        if (name == null) {
            return request.createResponseBuilder(HttpStatus.OK).body("Hello, Azure Function !").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name + "!").build();
        }
    }
}