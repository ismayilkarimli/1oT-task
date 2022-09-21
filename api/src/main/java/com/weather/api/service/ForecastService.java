package com.weather.api.service;

import com.weather.api.model.Forecasts;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ForecastService {

    public Forecasts getForecast(LocalDate date) {
        throw new UnsupportedOperationException("unimplemented");
    }

}
