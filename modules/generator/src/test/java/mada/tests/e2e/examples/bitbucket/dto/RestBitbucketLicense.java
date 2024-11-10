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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestBitbucketLicense
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBitbucketLicense {
    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    @JsonbProperty(JSON_PROPERTY_CREATION_DATE)
    @Schema(readOnly = true, example = "1331038800000")
    private Long creationDate;

    public static final String JSON_PROPERTY_DAYS_BEFORE_EXPIRY = "daysBeforeExpiry";
    @JsonbProperty(JSON_PROPERTY_DAYS_BEFORE_EXPIRY)
    @Schema(readOnly = true)
    private Integer daysBeforeExpiry;

    public static final String JSON_PROPERTY_EXPIRY_DATE = "expiryDate";
    @JsonbProperty(JSON_PROPERTY_EXPIRY_DATE)
    @Schema(readOnly = true, example = "1372493732817")
    private Long expiryDate;

    public static final String JSON_PROPERTY_GRACE_PERIOD_END_DATE = "gracePeriodEndDate";
    @JsonbProperty(JSON_PROPERTY_GRACE_PERIOD_END_DATE)
    @Schema(readOnly = true, example = "1372493732817")
    private Long gracePeriodEndDate;

    public static final String JSON_PROPERTY_LICENSE = "license";
    @JsonbProperty(JSON_PROPERTY_LICENSE)
    @Schema(example = "<encoded license text>")
    private String license;

    public static final String JSON_PROPERTY_MAINTENANCE_EXPIRY_DATE = "maintenanceExpiryDate";
    @JsonbProperty(JSON_PROPERTY_MAINTENANCE_EXPIRY_DATE)
    @Schema(readOnly = true, example = "1372493732817")
    private Long maintenanceExpiryDate;

    public static final String JSON_PROPERTY_MAXIMUM_NUMBER_OF_USERS = "maximumNumberOfUsers";
    @JsonbProperty(JSON_PROPERTY_MAXIMUM_NUMBER_OF_USERS)
    @Schema(readOnly = true, example = "12")
    private Integer maximumNumberOfUsers;

    public static final String JSON_PROPERTY_NUMBER_OF_DAYS_BEFORE_EXPIRY = "numberOfDaysBeforeExpiry";
    @JsonbProperty(JSON_PROPERTY_NUMBER_OF_DAYS_BEFORE_EXPIRY)
    @Schema(readOnly = true)
    private Integer numberOfDaysBeforeExpiry;

    public static final String JSON_PROPERTY_NUMBER_OF_DAYS_BEFORE_GRACE_PERIOD_EXPIRY = "numberOfDaysBeforeGracePeriodExpiry";
    @JsonbProperty(JSON_PROPERTY_NUMBER_OF_DAYS_BEFORE_GRACE_PERIOD_EXPIRY)
    @Schema(readOnly = true)
    private Integer numberOfDaysBeforeGracePeriodExpiry;

    public static final String JSON_PROPERTY_NUMBER_OF_DAYS_BEFORE_MAINTENANCE_EXPIRY = "numberOfDaysBeforeMaintenanceExpiry";
    @JsonbProperty(JSON_PROPERTY_NUMBER_OF_DAYS_BEFORE_MAINTENANCE_EXPIRY)
    @Schema(readOnly = true)
    private Integer numberOfDaysBeforeMaintenanceExpiry;

    public static final String JSON_PROPERTY_PURCHASE_DATE = "purchaseDate";
    @JsonbProperty(JSON_PROPERTY_PURCHASE_DATE)
    @Schema(readOnly = true, example = "1331038800000")
    private Long purchaseDate;

    public static final String JSON_PROPERTY_SERVER_ID = "serverId";
    @JsonbProperty(JSON_PROPERTY_SERVER_ID)
    @Schema(readOnly = true, example = "<server ID embedded in license>")
    private String serverId;

    public static final String JSON_PROPERTY_STATUS = "status";
    @JsonbProperty(JSON_PROPERTY_STATUS)
    @Schema(readOnly = true)
    private RestBitbucketLicenseStatus status;

    public static final String JSON_PROPERTY_SUPPORT_ENTITLEMENT_NUMBER = "supportEntitlementNumber";
    @JsonbProperty(JSON_PROPERTY_SUPPORT_ENTITLEMENT_NUMBER)
    @Schema(readOnly = true, example = "<support entitlement number embedded in license>")
    private String supportEntitlementNumber;

    public static final String JSON_PROPERTY_UNLIMITED_NUMBER_OF_USERS = "unlimitedNumberOfUsers";
    @JsonbProperty(JSON_PROPERTY_UNLIMITED_NUMBER_OF_USERS)
    @Schema(readOnly = true)
    private Boolean unlimitedNumberOfUsers;

    public RestBitbucketLicense creationDate(Long creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * Get creationDate
     *
     * @return creationDate
     **/
    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public RestBitbucketLicense daysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
        return this;
    }

    /**
     * Get daysBeforeExpiry
     *
     * @return daysBeforeExpiry
     **/
    public Integer getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public RestBitbucketLicense expiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    /**
     * Get expiryDate
     *
     * @return expiryDate
     **/
    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public RestBitbucketLicense gracePeriodEndDate(Long gracePeriodEndDate) {
        this.gracePeriodEndDate = gracePeriodEndDate;
        return this;
    }

    /**
     * Get gracePeriodEndDate
     *
     * @return gracePeriodEndDate
     **/
    public Long getGracePeriodEndDate() {
        return gracePeriodEndDate;
    }

    public void setGracePeriodEndDate(Long gracePeriodEndDate) {
        this.gracePeriodEndDate = gracePeriodEndDate;
    }

    public RestBitbucketLicense license(String license) {
        this.license = license;
        return this;
    }

    /**
     * Get license
     *
     * @return license
     **/
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public RestBitbucketLicense maintenanceExpiryDate(Long maintenanceExpiryDate) {
        this.maintenanceExpiryDate = maintenanceExpiryDate;
        return this;
    }

    /**
     * Get maintenanceExpiryDate
     *
     * @return maintenanceExpiryDate
     **/
    public Long getMaintenanceExpiryDate() {
        return maintenanceExpiryDate;
    }

    public void setMaintenanceExpiryDate(Long maintenanceExpiryDate) {
        this.maintenanceExpiryDate = maintenanceExpiryDate;
    }

    public RestBitbucketLicense maximumNumberOfUsers(Integer maximumNumberOfUsers) {
        this.maximumNumberOfUsers = maximumNumberOfUsers;
        return this;
    }

    /**
     * Get maximumNumberOfUsers
     *
     * @return maximumNumberOfUsers
     **/
    public Integer getMaximumNumberOfUsers() {
        return maximumNumberOfUsers;
    }

    public void setMaximumNumberOfUsers(Integer maximumNumberOfUsers) {
        this.maximumNumberOfUsers = maximumNumberOfUsers;
    }

    public RestBitbucketLicense numberOfDaysBeforeExpiry(Integer numberOfDaysBeforeExpiry) {
        this.numberOfDaysBeforeExpiry = numberOfDaysBeforeExpiry;
        return this;
    }

    /**
     * Get numberOfDaysBeforeExpiry
     *
     * @return numberOfDaysBeforeExpiry
     **/
    public Integer getNumberOfDaysBeforeExpiry() {
        return numberOfDaysBeforeExpiry;
    }

    public void setNumberOfDaysBeforeExpiry(Integer numberOfDaysBeforeExpiry) {
        this.numberOfDaysBeforeExpiry = numberOfDaysBeforeExpiry;
    }

    public RestBitbucketLicense numberOfDaysBeforeGracePeriodExpiry(Integer numberOfDaysBeforeGracePeriodExpiry) {
        this.numberOfDaysBeforeGracePeriodExpiry = numberOfDaysBeforeGracePeriodExpiry;
        return this;
    }

    /**
     * Get numberOfDaysBeforeGracePeriodExpiry
     *
     * @return numberOfDaysBeforeGracePeriodExpiry
     **/
    public Integer getNumberOfDaysBeforeGracePeriodExpiry() {
        return numberOfDaysBeforeGracePeriodExpiry;
    }

    public void setNumberOfDaysBeforeGracePeriodExpiry(Integer numberOfDaysBeforeGracePeriodExpiry) {
        this.numberOfDaysBeforeGracePeriodExpiry = numberOfDaysBeforeGracePeriodExpiry;
    }

    public RestBitbucketLicense numberOfDaysBeforeMaintenanceExpiry(Integer numberOfDaysBeforeMaintenanceExpiry) {
        this.numberOfDaysBeforeMaintenanceExpiry = numberOfDaysBeforeMaintenanceExpiry;
        return this;
    }

    /**
     * Get numberOfDaysBeforeMaintenanceExpiry
     *
     * @return numberOfDaysBeforeMaintenanceExpiry
     **/
    public Integer getNumberOfDaysBeforeMaintenanceExpiry() {
        return numberOfDaysBeforeMaintenanceExpiry;
    }

    public void setNumberOfDaysBeforeMaintenanceExpiry(Integer numberOfDaysBeforeMaintenanceExpiry) {
        this.numberOfDaysBeforeMaintenanceExpiry = numberOfDaysBeforeMaintenanceExpiry;
    }

    public RestBitbucketLicense purchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    /**
     * Get purchaseDate
     *
     * @return purchaseDate
     **/
    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public RestBitbucketLicense serverId(String serverId) {
        this.serverId = serverId;
        return this;
    }

    /**
     * Get serverId
     *
     * @return serverId
     **/
    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public RestBitbucketLicense status(RestBitbucketLicenseStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    public @Valid RestBitbucketLicenseStatus getStatus() {
        return status;
    }

    public void setStatus(RestBitbucketLicenseStatus status) {
        this.status = status;
    }

    public RestBitbucketLicense supportEntitlementNumber(String supportEntitlementNumber) {
        this.supportEntitlementNumber = supportEntitlementNumber;
        return this;
    }

    /**
     * Get supportEntitlementNumber
     *
     * @return supportEntitlementNumber
     **/
    public String getSupportEntitlementNumber() {
        return supportEntitlementNumber;
    }

    public void setSupportEntitlementNumber(String supportEntitlementNumber) {
        this.supportEntitlementNumber = supportEntitlementNumber;
    }

    public RestBitbucketLicense unlimitedNumberOfUsers(Boolean unlimitedNumberOfUsers) {
        this.unlimitedNumberOfUsers = unlimitedNumberOfUsers;
        return this;
    }

    /**
     * Get unlimitedNumberOfUsers
     *
     * @return unlimitedNumberOfUsers
     **/
    public Boolean isUnlimitedNumberOfUsers() {
        return unlimitedNumberOfUsers;
    }

    public void setUnlimitedNumberOfUsers(Boolean unlimitedNumberOfUsers) {
        this.unlimitedNumberOfUsers = unlimitedNumberOfUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBitbucketLicense)) {
            return false;
        }
        RestBitbucketLicense other = (RestBitbucketLicense) o;
        return Objects.equals(this.creationDate, other.creationDate) &&
                Objects.equals(this.daysBeforeExpiry, other.daysBeforeExpiry) &&
                Objects.equals(this.expiryDate, other.expiryDate) &&
                Objects.equals(this.gracePeriodEndDate, other.gracePeriodEndDate) &&
                Objects.equals(this.license, other.license) &&
                Objects.equals(this.maintenanceExpiryDate, other.maintenanceExpiryDate) &&
                Objects.equals(this.maximumNumberOfUsers, other.maximumNumberOfUsers) &&
                Objects.equals(this.numberOfDaysBeforeExpiry, other.numberOfDaysBeforeExpiry) &&
                Objects.equals(this.numberOfDaysBeforeGracePeriodExpiry, other.numberOfDaysBeforeGracePeriodExpiry) &&
                Objects.equals(this.numberOfDaysBeforeMaintenanceExpiry, other.numberOfDaysBeforeMaintenanceExpiry) &&
                Objects.equals(this.purchaseDate, other.purchaseDate) &&
                Objects.equals(this.serverId, other.serverId) &&
                Objects.equals(this.status, other.status) &&
                Objects.equals(this.supportEntitlementNumber, other.supportEntitlementNumber) &&
                Objects.equals(this.unlimitedNumberOfUsers, other.unlimitedNumberOfUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, daysBeforeExpiry, expiryDate, gracePeriodEndDate, license, maintenanceExpiryDate, maximumNumberOfUsers, numberOfDaysBeforeExpiry, numberOfDaysBeforeGracePeriodExpiry, numberOfDaysBeforeMaintenanceExpiry, purchaseDate, serverId, status, supportEntitlementNumber, unlimitedNumberOfUsers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBitbucketLicense {");
        sb.append("\n    creationDate: ").append(toIndentedString(creationDate));
        sb.append("\n    daysBeforeExpiry: ").append(toIndentedString(daysBeforeExpiry));
        sb.append("\n    expiryDate: ").append(toIndentedString(expiryDate));
        sb.append("\n    gracePeriodEndDate: ").append(toIndentedString(gracePeriodEndDate));
        sb.append("\n    license: ").append(toIndentedString(license));
        sb.append("\n    maintenanceExpiryDate: ").append(toIndentedString(maintenanceExpiryDate));
        sb.append("\n    maximumNumberOfUsers: ").append(toIndentedString(maximumNumberOfUsers));
        sb.append("\n    numberOfDaysBeforeExpiry: ").append(toIndentedString(numberOfDaysBeforeExpiry));
        sb.append("\n    numberOfDaysBeforeGracePeriodExpiry: ").append(toIndentedString(numberOfDaysBeforeGracePeriodExpiry));
        sb.append("\n    numberOfDaysBeforeMaintenanceExpiry: ").append(toIndentedString(numberOfDaysBeforeMaintenanceExpiry));
        sb.append("\n    purchaseDate: ").append(toIndentedString(purchaseDate));
        sb.append("\n    serverId: ").append(toIndentedString(serverId));
        sb.append("\n    status: ").append(toIndentedString(status));
        sb.append("\n    supportEntitlementNumber: ").append(toIndentedString(supportEntitlementNumber));
        sb.append("\n    unlimitedNumberOfUsers: ").append(toIndentedString(unlimitedNumberOfUsers));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
