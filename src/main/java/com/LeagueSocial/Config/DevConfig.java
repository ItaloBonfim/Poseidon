package com.LeagueSocial.Config;

import com.LeagueSocial.Services.Profile.EmailProfileService;
import com.LeagueSocial.Services.SmtpEmailService;
import com.LeagueSocial.Services.Test.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired private DBService dbDevService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean InstantiateDatabase() throws ParseException {

        if(!"create".equals(this.strategy)){
            return false;
        }
        dbDevService.InstantiateTestDatabase();
        return true;
    }
    @Bean
    public EmailProfileService emailService(){
        return new SmtpEmailService();
    }

}
