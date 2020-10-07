package com.springcaching.inbuildimplementation.Example2;

public class Profile {

    private String userId;
    private String fullName;
    private Boolean isEmailSubscriptionActive;
    private String ageOnThePlatform;

    public Profile(String userId,String fullName, Boolean isEmailSubscriptionActive, String ageOnThePlatform) {
        this.fullName = fullName;
        this.isEmailSubscriptionActive = isEmailSubscriptionActive;
        this.ageOnThePlatform = ageOnThePlatform;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getEmailSubscriptionActive() {
        return isEmailSubscriptionActive;
    }

    public void setEmailSubscriptionActive(Boolean emailSubscriptionActive) {
        isEmailSubscriptionActive = emailSubscriptionActive;
    }

    public String getAgeOnThePlatform() {
        return ageOnThePlatform;
    }

    public void setAgeOnThePlatform(String ageOnThePlatform) {
        this.ageOnThePlatform = ageOnThePlatform;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userId='" + userId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", isEmailSubscriptionActive=" + isEmailSubscriptionActive +
                ", ageOnThePlatform='" + ageOnThePlatform + '\'' +
                '}';
    }
}
