/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(anyOf = { SubA.class, SubB.class })
public interface SubA_SubB {
}
