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

    public abstract String title();
    public abstract String version();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract String termsOfService();

    @Default
    public Contact contact() {
        return Contact.builder().build();
    }

    @Immutable
    public abstract static class Contact {
        public static ImmutableContact.Builder builder() {
            return ImmutableContact.builder();
        }

        @Nullable
        @Default
        public String name() {
            return null;
        }

        @Nullable
        @Default
        public String url() {
            return null;
        }

        @Nullable
        @Default
        public String email() {
            return null;
        }
    }
}
