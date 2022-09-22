package com.weather.api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public record Night(String phenomenon, Integer tempmin, String tempmax, String text, @JacksonXmlElementWrapper(useWrapping = false) List<Place> place, @JacksonXmlElementWrapper(useWrapping = false) List<Wind> wind, String sea, String peipsi) {
}
