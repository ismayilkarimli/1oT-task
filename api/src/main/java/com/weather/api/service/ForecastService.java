package com.weather.api.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.weather.api.model.Forecasts;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ForecastService {

    private final WebClient client;

    public ForecastService(@Value("${external.api.endpoint}") String externalApiEndpoint) {
        this.client = WebClient.create(externalApiEndpoint);
    }

    @SneakyThrows
    public Forecasts getForecast() {
        var xmlData = client.get().accept(MediaType.TEXT_XML).retrieve().bodyToMono(String.class).block();
        return new XmlMapper().readValue(xmlData, Forecasts.class);
    }

}
