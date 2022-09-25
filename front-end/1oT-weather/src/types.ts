export class Weather {
  date: string;
  day: [Day];
  night: [Night];
  constructor(date: string, day: [Day], night: [Night]) {
    this.date = date;
    this.day = day;
    this.night = night;
  }
}

export class Day {
  phenomenon: string;
  tempmin: number;
  tempmax: number;
  text: string;
  place: [Place];
  wind: [Wind];
  sea: string;
  peipsi: string;
  constructor(
    phenomenon: string,
    tempmin: number,
    tempmax: number,
    text: string,
    place: [Place],
    wind: [Wind],
    sea: string,
    peipsi: string
  ) {
    this.phenomenon = phenomenon;
    this.tempmin = tempmin;
    this.tempmax = tempmax;
    this.text = text;
    this.place = place;
    this.wind = wind;
    this.sea = sea;
    this.peipsi = peipsi;
  }
}

export class Night {
  phenomenon: string;
  tempmin: number;
  tempmax: number;
  text: string;
  place: [Place];
  wind: [Wind];
  sea: string;
  peipsi: string;
  constructor(
    phenomenon: string,
    tempmin: number,
    tempmax: number,
    text: string,
    place: [Place],
    wind: [Wind],
    sea: string,
    peipsi: string
  ) {
    this.phenomenon = phenomenon;
    this.tempmin = tempmin;
    this.tempmax = tempmax;
    this.text = text;
    this.place = place;
    this.wind = wind;
    this.sea = sea;
    this.peipsi = peipsi;
  }
}

export class DayShort {
  date: string;
  phenomenon: string;
  tempmin: number;
  tempmax: number;
  text: string;
  constructor(
    date: string,
    phenomenon: string,
    tempmin: number,
    tempmax: number,
    text: string
  ) {
    this.date = date;
    this.phenomenon = phenomenon;
    this.tempmin = tempmin;
    this.tempmax = tempmax;
    this.text = text;
  }
}

export class NightShort {
  date: string;
  phenomenon: string;
  tempmin: number;
  tempmax: number;
  text: string;
  constructor(
    date: string,
    phenomenon: string,
    tempmin: number,
    tempmax: number,
    text: string
  ) {
    this.date = date;
    this.phenomenon = phenomenon;
    this.tempmin = tempmin;
    this.tempmax = tempmax;
    this.text = text;
  }
}

type Place = {
  name: string;
  phenomenon: string;
  tempmin: string;
  tempmax: string;
};

type Wind = {
  name: string;
  direction: string;
  speedmin: number;
  speedmax: number;
};
