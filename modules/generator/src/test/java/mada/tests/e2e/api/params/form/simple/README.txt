Hand made example with data from #463 (eaptemplate)

According to the examples in https://docs.jboss.org/resteasy/docs/6.2.5.Final/userguide/html/ch26.html#multipart_formData_group
the individual arguments should be possible to list with @FormParam.

But this does not work with Quarkus (https://github.com/quarkusio/quarkus/issues/12286)

So a workaround is provided by wrapping the arguments in a @MultipartForm DTO.

