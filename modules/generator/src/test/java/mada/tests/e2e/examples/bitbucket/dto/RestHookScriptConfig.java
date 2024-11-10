/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RestHookScriptConfig
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestHookScriptConfig {
    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    private RestHookScriptConfigScope scope;

    public static final String JSON_PROPERTY_SCRIPT = "script";
    @JsonbProperty(JSON_PROPERTY_SCRIPT)
    private RestHookScriptConfigScript script;

    public static final String JSON_PROPERTY_TRIGGER_IDS = "triggerIds";
    @JsonbProperty(JSON_PROPERTY_TRIGGER_IDS)
    private Set<String> triggerIds;

    public RestHookScriptConfig scope(RestHookScriptConfigScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     **/
    @Valid public RestHookScriptConfigScope getScope() {
        return scope;
    }

    public void setScope(RestHookScriptConfigScope scope) {
        this.scope = scope;
    }

    public RestHookScriptConfig script(RestHookScriptConfigScript script) {
        this.script = script;
        return this;
    }

    /**
     * Get script
     *
     * @return script
     **/
    @Valid public RestHookScriptConfigScript getScript() {
        return script;
    }

    public void setScript(RestHookScriptConfigScript script) {
        this.script = script;
    }

    public RestHookScriptConfig triggerIds(Set<String> triggerIds) {
        this.triggerIds = triggerIds;
        return this;
    }

    public RestHookScriptConfig addTriggerIdsItem(String triggerIdsItem) {
        if (this.triggerIds == null) {
            this.triggerIds = new LinkedHashSet<>();
        }
        this.triggerIds.add(triggerIdsItem);
        return this;
    }

    /**
     * Get triggerIds
     *
     * @return triggerIds
     **/
    public Set<String> getTriggerIds() {
        return triggerIds;
    }

    public void setTriggerIds(Set<String> triggerIds) {
        this.triggerIds = triggerIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestHookScriptConfig)) {
            return false;
        }
        RestHookScriptConfig other = (RestHookScriptConfig) o;
        return Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.script, other.script) &&
                Objects.equals(this.triggerIds, other.triggerIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, script, triggerIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestHookScriptConfig {");
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    script: ").append(toIndentedString(script));
        sb.append("\n    triggerIds: ").append(toIndentedString(triggerIds));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
