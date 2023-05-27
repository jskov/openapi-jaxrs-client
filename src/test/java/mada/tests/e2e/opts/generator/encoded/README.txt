Some server path parameters may be @Encoded on the server (meaning that they can contain /).

This can be expressed in the OpenApi document with allowReserved=true.

Only on in and query params, though. So the specific example here (path) is not covered - although it works with jaxrs.

This test is just a marker to remember the issue. It should generate methods looking like:

  String encodedEncodedGet(@PathParam("encoded") @Encoded @NotNull String encoded);

  String encodedEncodedRawRawGet(@PathParam("encoded") @Encoded @NotNull String encoded, @PathParam("raw") @NotNull String raw, @QueryParam("query") String query, @HeaderParam("item") List<String> item, String dto);

See https://github.com/jskov/openapi-jaxrs-client/issues/288
