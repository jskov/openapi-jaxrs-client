package dk.mada.jaxrs.model;

import javax.annotation.Nullable;

import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

/**
 * API
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

    /** {@return the description of the API, or null} */
    @Nullable
    public abstract String description();

    /** {@return the TOS of the API, or null} */
    @Nullable
    public abstract String termsOfService();

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

        /** {@return the name of the contact, or null} */
        @Nullable
        @Default
        public String name() {
            return null;
        }

        /** {@return the URL of the contact, or null} */
        @Nullable
        @Default
        public String url() {
            return null;
        }

        /** {@return the email of the contact, or null} */
        @Nullable
        @Default
        public String email() {
            return null;
        }
    }
}
