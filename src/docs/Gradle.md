# Using the Gradle plugin

See examples in [the openapi-jaxrs-client-examples repository](https://github.com/jskov/openapi-jaxrs-client-examples).

## Activation

Activate the plugin with:

```gradle
plugins {
    id 'dk.mada.jaxrs' version "0.9.2"
}
```

## Tasks

The plugin is configured using DSL (see below).

This results in two tasks being created for each OpenApi source document `NAME` (`NNN` will be a simplified version of the document `NAME`).

**downloadDocumentNNN** downloads the OpenApi document from the specified URL to `src/openapi/NAME.yaml`.

You can comment out the "download()" statement in the client configuration if you are not interested in downloading updates to the document.

If the OpenApi document comes from another medium (or requires credentials), you can manually place it in the `src/openapi` folder with the expected name.


**generateClientNNN** generates the client code from the OpenApi document.

The OpenApi document is expected to be found at `src/openapi/NAME.yaml`. The configuration at `src/openapi/NAME.properties`.

The task will delete anything under `src/main/java-jaxrs/NAME` and create new sources into this folder.

If you use `transientSource()` the folder will be `build/java-jaxrs/NAME` instead.



## General Configuration

The `jaxrs` plugin extension allows a few global configuration entries.

Note in particular that the GAV of the generator is something you need to update to get the latest generator version.  
The use of a generator GAV allows the Gradle plugin to go without too many changes over time (that is the hope/plan, anyway).


```groovy
jaxrs {
    // Specify the generator implementation GAV
    generatorGAV = "dk.mada.jaxrs:openapi-jaxrs-client:0.9.3"

    // Optionally override the folder where OpenApi documents are stored
    //openApiDocDirectory = file("src/openapi")

    // Optionally override the output folder for transient source code
    //buildOutputDirectory = file("build/java-jaxrs")

    // Optionally override the output folder for source code checked into version control
    //srcOutputDirectory = file("src/main/java-jaxrs")

    // The individual client is configured in this section, see below    
    clients {
      ...
    }
}
```

## Client Configurations

Each OpenApi document you want to generate code from get its own entry in the `clients` section.

The section name is used to generate names for files and Gradle tasks.

```groovy
jaxrs {
  ...
  clients {
    endpointA {
        // Tasks created:
        //  downloadDocumentEndpointa (when download() is active)
        //  generateClientEndpointa
      
        // An (optional) URL from where the OpenApi document can be downloaded.
        // When commented out (like below) the `downloadDocumentEndpointa` task will be disabled
        //download("https://raw.githubusercontent.com/OAI/OpenAPI-Specification/main/examples/v3.0/petstore.json")

        // Optional control of the OpenApi document extension. Defaults to ".yaml".
        // The download task and generator does not really care.
        // But your IDE (and your sanity) may prefer the extension to match the document type.
        //documentExtension = ".json"
        
        // Optionally generate the code to the buildOutputDirectory instead of the
        // srcOutputDirectory.
        // This also makes the generator task a dependency for `compileJava` so the
        // code is always generated before it is needed for compilation.
        //transientSource()
    }
    
    // If your document name is not a valid identifier, you can quote it like this:
    'endpoint-b' {
       ...
    }
    # etc
}
```

## What is source? What is checked into version control?

There are (at least) two ways to think about the OpenApi document and the source code generated from it.

I call them `pure` and `pragmatic` - mostly to be able to tell them apart.

I prefer (and advice) use of the `pragmatic` approach, but can see the validity of the `pure` approach.  
Please do not read too much into the names; you are most welcome to use whatever suits you best :)


**Pure**

    The OpenApi document is the source for the generated client java code.
    So the generated code is not "source", and should not be checked into version control.

If you use the `transientSource()` method in the client configuration, the code is generated before each Gradle compilation.  
And the code is generated below `build/java-jaxrs`, so it does not risk ending up in version control.

You have to invoke the generator task, so the source code is available to your IDE.


**Pragmatic**

    Both OpenApi document and generated client java code is checked into version control.

When there are changes to the OpenApi document and/or the generator, you invoke the generate task.  
And can then review the differences, so you know what changed at both levels.

If you have to find a problem using a stack trace, you will have the code for reference in version control.
