package com.LeagueSocial.Config;

import com.LeagueSocial.Services.MockEmailService;
import com.LeagueSocial.Services.Profile.EmailProfileService;
import com.LeagueSocial.Services.Test.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired private DBService dbService;

    @Bean
    public boolean InstantiateDatabase() throws ParseException {
        dbService.InstantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailProfileService emailService(){
        return new MockEmailService();
    }
}
