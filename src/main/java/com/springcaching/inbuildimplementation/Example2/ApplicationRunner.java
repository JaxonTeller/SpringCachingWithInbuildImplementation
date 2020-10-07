package com.springcaching.inbuildimplementation.Example2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final static Logger LOGGER= LoggerFactory.getLogger(ApplicationRunner.class);
    private ProfileAccessRepository profileAccessRepository;
    public ApplicationRunner(ProfileAccessRepository profileAccessRepository)
    {
        this.profileAccessRepository=profileAccessRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("--------Accessing profile-----------");
        LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("1"));
        LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("1"));
        LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("1"));
        LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("2"));
        this.profileAccessRepository.deleteProfileById("2");
        try {
            LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("2"));
        } catch (Exception exception) {
            LOGGER.info("Profile is no longer present");
        }
        LOGGER.info("Profile "+this.profileAccessRepository.addNewUserProfile("3"));
        LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("3"));
        LOGGER.info("Profile "+this.profileAccessRepository.getUserProfileById("3"));

    }
}
