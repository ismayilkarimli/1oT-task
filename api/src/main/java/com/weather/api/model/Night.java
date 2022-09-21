package com.weather.api.model;

import java.util.List;

public record Night(String phenomenon, Integer tempmin, String tempmax, String text, List<Place> places, List<Wind> winds, String sea, String peipsi) {
}
