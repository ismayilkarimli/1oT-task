package com.weather.api.controller;

import com.weather.api.model.Forecasts;
import com.weather.api.service.ForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5173"})
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE )
    public Forecasts getForecast() {
        return forecastService.getForecast();
    }

}
