package com.springcaching.inbuildimplementation.Example2;

public interface ProfileAccessRepository {

    Profile getUserProfileById(String userId);

    void deleteProfileById(String userId);

    Profile addNewUserProfile(String userId);
}
