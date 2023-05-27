Some server path parameters may be @Encoded on the server (meaning that they can contain /).

This can be expressed in the OpenApi document with allowReserved=true.

Unfortunately, smallrye openapi does not expose the information from resources in applications - at least
not in Quarkus 2. Maybe in newer MP version, as I see it mentioned in the repo.

This test is just a marker to remember the issue. It should generate methods looking like:

  String encodedEncodedGet(@PathParam("encoded") @Encoded @NotNull String encoded);

  String encodedEncodedRawRawGet(@PathParam("encoded") @Encoded @NotNull String encoded, @PathParam("raw") @NotNull String raw, @QueryParam("query") String query, @HeaderParam("item") List<String> item, String dto);
