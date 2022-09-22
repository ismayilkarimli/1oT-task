package com.weather.api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public record Forecasts(@JacksonXmlElementWrapper(useWrapping = false) List<Forecast> forecast) {
}
