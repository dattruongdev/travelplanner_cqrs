package com.d1nn.travelplanner.config;

import com.d1nn.travelplanner.cqrs.DispatchableProcessor;
import com.d1nn.travelplanner.cqrs.abstraction.DispatchableHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    DispatchableHandler dispatchableHandler(ApplicationContext context) {
        return new DispatchableProcessor(context);
    }
}
