package com.englishtown.newhouse.school.beanandenum.bean;
/**
 * Nikol 2019 Student security data to access school
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StudentSecurityDetails {

    private static final Logger logger = LoggerFactory.getLogger(StudentSecurityDetails.class);

    private String businessUnit;
    private String schoolId;
    private String bearerUuid;
    private String xefAccess;
    private String studentId;
    private String userId;  // this is ef id 

    @Override
    public String toString() {
        return "StudentSecurityDetails{" +
                "businessUnit='" + businessUnit + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", bearerUuid='" + bearerUuid + '\'' +
                ", xefAccess='" + xefAccess + '\'' +
                ", studentId='" + studentId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public StudentSecurityDetails(String businessUnit, String schoolId, String bearerUuid, String xefAccess, String studentId, String userId) {
        this.businessUnit = businessUnit;
        this.schoolId = schoolId;
        this.bearerUuid = bearerUuid;
        this.xefAccess = xefAccess;
        this.studentId = studentId;
        this.userId = userId;
    }

    public StudentSecurityDetails(String bearerUuid, String xefAccess) {
        this.bearerUuid = bearerUuid;
        this.xefAccess = xefAccess;
    }

    public StudentSecurityDetails() {

    }



    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getBearerUuid() {
        return bearerUuid;
    }

    public void setBearerUuid(String bearerUuid) {
        this.bearerUuid = bearerUuid;
    }

    public String getXefAccess() {
        return xefAccess;
    }

    public void setXefAccess(String xefAccess) {
        this.xefAccess = xefAccess;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
