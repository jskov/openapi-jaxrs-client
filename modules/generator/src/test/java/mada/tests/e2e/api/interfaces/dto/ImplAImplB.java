/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.interfaces.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(anyOf = { ImplA.class, ImplB.class })
public interface ImplAImplB {
}
