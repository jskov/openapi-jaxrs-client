package dk.mada.jaxrs.model;

import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

/**
 * API 
 * @see https://swagger.io/specification/#infoObject
 */
@Immutable
public abstract class Info {
	public abstract String title();
	public abstract String version();
	
	@Default
	public String description() {
		return "";
	};
	
	@Default
	public String termsOfService() {
		return "";
	}
	
	@Default
	public Contact contact() {
		return ImmutableContact.builder().build();
	}
	
	@Immutable
	public static abstract class Contact {
		@Default
		public String name() {
			return "";
		}

		@Default
		public String url() {
			return "";
		}

		@Default
		public String email() {
			return "";
		}
	}
}
