package com.github.cotrod.bot;

import com.github.cotrod.dao.CityDao;
import com.github.cotrod.model.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:/application.yml")
public class ReslivTouristBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String BOT_TOKEN;
    @Value("${bot.username}")
    private String BOT_USERNAME;
    private final TelegramBotsApi telegramBotsApi;
    private final CityDao cityDao;

    @PostConstruct
    public void init() {
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        CityDto city = cityDao.getCity(update.getMessage().getText());
        String message;
        if (city != null) {
            message = city.getDescription();
        } else {
            message = "Такого города нет в нашей базе";
        }
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public synchronized void sendMsg(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
