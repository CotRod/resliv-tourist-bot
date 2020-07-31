package com.github.cotrod.config;

import com.github.cotrod.dao.CityDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Configuration
public class AppConfiguration {
    @Autowired
    CityDao cityDao;

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi();
    }
}
