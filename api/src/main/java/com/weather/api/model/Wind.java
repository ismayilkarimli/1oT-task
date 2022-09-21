package com.weather.api.model;

public record Wind(String name, String direction, Integer speedmin, Integer speedmax, String gust) { }
