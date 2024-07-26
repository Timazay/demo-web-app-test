package com.example.demowebapp.services;

import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.HTMLTableBuilder;
import com.example.demowebapp.utils.MailUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class CurrenciesSenderService {

    public static void sendCurrencies(final Set<User> users){
        HTMLTableBuilder currencies = new HTMLTableBuilder("Currencies", true,
                3, 3, 10, 10, 10);
        currencies.addTableHeader("#", "ID", "Rate");
        currencies.addRowValues("1", "USD", XMLCurrencyParser.getCurrency("840"));
        currencies.addRowValues("2", "EUR", XMLCurrencyParser.getCurrency("978"));
        currencies.addRowValues("3", "RUB (100)", XMLCurrencyParser.getCurrency("643"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String date = simpleDateFormat.format(new Date());

        users.forEach(user -> {
            MailUtils.sendHtmlMail(user.getEmail(),"Today's currencies Date: " + date, currencies.build(), null, null);
        });

    }
}
