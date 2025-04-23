
Prepare and publish a new GitHub release with a new tag.

## Maven Central

Tags matching "0.*" are built and published to [Maven Central](https://central.sonatype.com/) via the [publish-mavencentral action](https://github.com/jskov/openapi-jaxrs-client/blob/main/.github/workflows/publish-mavencentral.yaml).

To test the Maven Artifacts first (whenever something build-relates changes), change the `target_action` to `keep`.
And then create an alpha tag.

This will upload the release artifacts but not release them.  
You must clean up tag + uploaded artifacts manually!

Note that it sometimes take a long time (hours) before the new artifacts are indexed on MavenCentral.

## Gradle Plugins

Tags matching "gradle/0.*" are built and published to [Gradle Plugins](https://plugins.gradle.org) via the [publish-gradle-plugin action](https://github.com/jskov/openapi-jaxrs-client/blob/main/.github/workflows/publish-gradle-plugin.yaml)

A published release can be deleted for 14 days, should that become necessary.
