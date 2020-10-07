package com.springcaching.inbuildimplementation.Example2;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileAccessService implements ProfileAccessRepository{

    private static final List<Profile> userProfiles;

    static
    {
        userProfiles=new ArrayList<>();
        userProfiles.add(new Profile("1","NT",true,"2Years 3Months"));
        userProfiles.add(new Profile("2","NT",true,"2Years 4Months"));
        userProfiles.add(new Profile("3","NT",false,"2Years 5Months"));
        userProfiles.add(new Profile("4","NT",true,"2Years 6Months"));
        userProfiles.add(new Profile("5","NT",false,"2Years 7Months"));
    }


    @Override
    @Cacheable(cacheNames = "profile",key = "#userId")
    public Profile getUserProfileById(String userId) {
        slowDownService();
        return userProfiles.stream().filter(profile -> profile.getUserId().equals(userId)).findFirst().get();
    }

    @Override
    @CacheEvict(cacheNames = "profile",key = "#userId")
    public void deleteProfileById(String userId) {
       userProfiles.remove( userProfiles.stream().filter(profile -> profile.getUserId().equals(userId)).findFirst().get());
        System.out.println("Profile deleted "+userProfiles);
    }

    @Override
    @CachePut(cacheNames = "profile",key = "#userId")
    public Profile addNewUserProfile(String userId) {
        Profile profile=new Profile(userId,"AlluArjun",true,"1Year");
         userProfiles.add(profile);
        System.out.println("New Profile Added");
         return profile;
    }

    private void slowDownService() {
        try {
            long l=4000l;
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
