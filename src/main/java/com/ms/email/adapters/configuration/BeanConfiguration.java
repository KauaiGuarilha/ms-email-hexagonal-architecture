package com.ms.email.adapters.configuration;

import com.ms.email.EmailApplication;
import com.ms.email.application.port.EmailRepositoryPort;
import com.ms.email.application.port.SendEmailServicePort;
import com.ms.email.application.service.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = EmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
