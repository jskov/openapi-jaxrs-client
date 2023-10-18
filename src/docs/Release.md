# Releasing

## GitHub Release

Make and push a tag. This will cause the `build` workflow to create artifacts for release.

Download the `files-n.n.n.zip` archive from the completed Action page and unpack it.

Prepare a new GitHub release from the new tag.
Upload the `ojc-n.n.n-cli.jar` file and its signature file (`ojc-n.n.n-cli.jar.asc`) as release artifacts.
Publish the release.

## Maven Central

Tags matching "0.*" are built and published to [Maven Central](https://s01.oss.sonatype.org/) via [publish-mavencentral action](/.github/workflows/publish-mavencentral.yaml).

To test the Maven Artifacts first (whenever something build-relates changes), use a tag matching "^0[.]0[.]" (prefixed "0.0.").  
This will upload the release artifacts but not release them.  
You must clean up tag + uploaded artifacts manually!

Note that it sometimes take a long time (hours) before the new artifacts are indexed on MavenCentral.
