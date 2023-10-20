/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.inheritance.jackson_fasterxml.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(anyOf = { SubA.class, SubB.class })
public interface SubASubB {
}
