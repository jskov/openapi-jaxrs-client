package dk.mada.jaxrs.model;

import java.util.Optional;

import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

/**
 * API
 *
 * @see <a href="https://swagger.io/specification/#infoObject">infoObject</a>
 */
@Immutable
public abstract class Info {
    /** {@return a builder for this type} */
    public static ImmutableInfo.Builder builder() {
        return ImmutableInfo.builder();
    }

    /** {@return the title of the API} */
    public abstract String title();

    /** {@return the version of the API} */
    public abstract String version();

    /** {@return the optional description of the API} */
    public abstract Optional<String> description();

    /** {@return the optional TOS of the API} */
    public abstract Optional<String> termsOfService();

    /** {@return the contact information for the API} */
    @Default
    public Contact contact() {
        return Contact.builder().build();
    }

    /**
     * The contact information for the API.
     */
    @Immutable
    public abstract static class Contact {
        /** {@return a builder for this type} */
        public static ImmutableContact.Builder builder() {
            return ImmutableContact.builder();
        }

        /** {@return the optional name of the contact} */
        public abstract Optional<String> name();

        /** {@return the optional URL of the contact} */
        public abstract Optional<String> url();

        /** {@return the optional email of the contact} */
        public abstract Optional<String> email();
    }
}
