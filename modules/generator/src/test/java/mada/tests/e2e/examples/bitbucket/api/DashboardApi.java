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

package mada.tests.e2e.examples.bitbucket.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDashboardPullRequestSuggestions;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDashboardPullRequestSuggestions_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDashboardPullRequestSuggestions_401;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDashboardPullRequests;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDashboardPullRequests_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDashboardPullRequests_401;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/latest/dashboard")
public interface DashboardApi {

    /**
     * Get pull request suggestions.
     *
     * Retrieves a page of suggestions for pull requests that the currently authenticated user may wish to raise. Such
     * suggestions are based on ref changes occurring and so contain the ref change that prompted the suggestion plus
     * the time the change event occurred. Changes will be returned in descending order based on the time the change
     * that prompted the suggestion occurred.
     * Note that although the response is a page object, the interface does not support paging, however a limit can be
     * applied to the size of the returned page.
     *
     * @param changesSince restrict pull request suggestions to be based on events that occurred since some timein the past. This is expressed in seconds since "now". So to return suggestionsbased only on activity within the past 48 hours, pass a value of 172800. (optional)
     * @param limit        restricts the result set to return at most this many suggestions. (optional)
     * @return _ResponseApiLatestDashboardPullRequestSuggestions
     */
    @GET
    @Path("/pull-request-suggestions")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of pull requests that match the search criteria.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDashboardPullRequestSuggestions.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDashboardPullRequestSuggestions_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The current user is not authenticated",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDashboardPullRequestSuggestions_401.class)))
    })
    @Operation(summary = "Get pull request suggestions")
    _ResponseApiLatestDashboardPullRequestSuggestions getPullRequestSuggestions(@QueryParam("changesSince") String changesSince, @QueryParam("limit") String limit);

    /**
     * Get pull requests for a user.
     *
     * Retrieve a page of pull requests where a user is involved as either a reviewer, author or a participant. The
     * request may be filtered by pull request state, role or participant status.
     *
     * @param closedSince       (optional, defaults to returning pull requests regardless of closed since date). Permits returning only pull requests with a closed timestamp set more recently that (now - closedSince). Units are in seconds. So for example if closed since 86400 is set only pull requests closed in the previous 24 hours will be returned. (optional)
     * @param role              (optional, defaults to returning pull requests for any role). If a role is supplied only pull requests where the authenticated user is a participant in the given role will be returned. Either <strong>REVIEWER</strong>, <strong>AUTHOR</strong> or <strong>PARTICIPANT</strong>. (optional)
     * @param participantStatus (optional, defaults to returning pull requests with any participant status). A comma separated list of participant status. That is, one or more of <strong>UNAPPROVED</strong>, <strong>NEEDS_WORK</strong>, or <strong>APPROVED</strong>. (optional)
     * @param state             (optional, defaults to returning pull requests in any state). If a state is supplied only pull requests in the specified state will be returned. Either <strong>OPEN</strong>, <strong>DECLINED</strong> or <strong>MERGED</strong>. Omit this parameter to return pull request in any state. (optional)
     * @param user              The name of the involved user, defaults to the current user. (optional)
     * @param order             (optional, defaults to <strong>NEWEST</strong>) the order/(s) to return pull requests in; can choose from <strong>OLDEST</strong> (as in: "oldest first"), <strong>NEWEST</strong>, <strong>DRAFT_STATUS</strong>, <strong>PARTICIPANT_STATUS</strong>, and/or <strong>CLOSED_DATE</strong>. Where <strong>CLOSED_DATE</strong> is specified and the result set includes pull requests that are not in the closed state, these pull requests will appear first in the result set, followed by most recently closed pull requests. (optional)
     * @param start             Start number for the page (inclusive). If not passed, first page is assumed. (optional)
     * @param limit             Number of items to return. If not passed, a page size of 25 is used. (optional)
     * @return _ResponseApiLatestDashboardPullRequests
     */
    @GET
    @Path("/pull-requests")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "A page of pull requests that match the search criteria.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDashboardPullRequests.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The request was malformed.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDashboardPullRequests_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The current user is not authenticated",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDashboardPullRequests_401.class)))
    })
    @Operation(summary = "Get pull requests for a user")
    _ResponseApiLatestDashboardPullRequests getPullRequests_1(@QueryParam("closedSince") String closedSince, @QueryParam("role") String role, @QueryParam("participantStatus") String participantStatus, @QueryParam("state") String state, @QueryParam("user") String user, @QueryParam("order") String order, @QueryParam("start") BigDecimal start, @QueryParam("limit") BigDecimal limit);
}
