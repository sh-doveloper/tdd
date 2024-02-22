package com.example.tdd.chap07;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CardNumberValidator {

    public CardValidity validate(String cardNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://external.com/card"))
            .header("Content-Type", "text/plain")
            .POST(BodyPublishers.ofString(cardNumber))
            .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                BodyHandlers.ofString());
            return switch (httpResponse.body()) {
                case "ok" -> CardValidity.VALID;
                case "bad" -> CardValidity.INVALID;
                case "expired" -> CardValidity.EXPIRED;
                case "theft" -> CardValidity.THEFT;
                default -> CardValidity.UNKNOWN;
            };
        } catch (IOException | InterruptedException e) {
            return CardValidity.ERROR;
        }
    }

}
