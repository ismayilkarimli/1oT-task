package com.weather.api.controller;

import com.weather.api.model.Forecast;
import com.weather.api.model.Forecasts;
import com.weather.api.service.ForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping("/")
    public Forecasts getForecast(@RequestParam(required = false) LocalDate date) {
        return forecastService.getForecast(date);
    }
}
