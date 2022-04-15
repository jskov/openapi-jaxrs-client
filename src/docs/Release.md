# Releasing

## GitHub Release

Make and push a tag. This will cause the `build` workflow to create artifacts for release.

Download the `files-n.n.n.zip` archive from the completed Action page and unpack it.

Prepare a new GitHub release from the new tag.
Upload the `ojc-n.n.n-cli.jar` file and its signature file (`ojc-n.n.n-cli.jar.asc`) as release artifacts.
Publish the release.

## Maven Central

The `release-bundle-n.n.n.jar` file is for upload to [Maven Central](https://s01.oss.sonatype.org/).

Log in, and click `Staging Upload`. Select the `Artifact Bundle` option, and upload the `release-bundle` file.

Wait for a bit, and then check out the `Staging Repositories`. If the repository looks OK, click on `Release`.
After 1-4 hours the artifacts should be searchable from Maven Central.
