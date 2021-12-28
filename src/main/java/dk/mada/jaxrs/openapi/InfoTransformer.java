package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.ImmutableContact;
import dk.mada.jaxrs.model.ImmutableInfo;
import dk.mada.jaxrs.model.Info;
import io.swagger.v3.oas.models.OpenAPI;

/**
 * Transforms OpenApi info to local model objects.
 */
public class InfoTransformer {
	public Info transform(OpenAPI specification) {
		io.swagger.v3.oas.models.info.Info info = specification.getInfo();

		String title = orEmpty(info.getTitle());
		String version = orEmpty(info.getVersion());
		String description = orEmpty(info.getDescription());
		String tos = orEmpty(info.getTermsOfService());

		String email = null;
		String name = null;
		String url = null;
		io.swagger.v3.oas.models.info.Contact contact = info.getContact();
		if (contact != null) {
			email = contact.getEmail();
			name = contact.getName();
			url = contact.getUrl();
		}
		
		return ImmutableInfo.builder()
				.title(title)
				.version(version)
				.description(description)
				.termsOfService(tos)
				.contact(ImmutableContact.builder()
						.email(email)
						.name(name)
						.url(url)
						.build())
				.build();
	}
	
	private String orEmpty(String str) {
		return str == null ? "" : str;
	}

}
