package org.webserve.carservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// TODO
// maybe remove

@Configuration
@EnableWebMvc // move to another config class before deleting if at all
public class SpringWebConfig {
    @Bean
    public static ModelMapper modelMapper(){return new ModelMapper();}
}
