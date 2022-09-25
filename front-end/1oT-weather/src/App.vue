<template>
  <div v-if="isLoaded">
  <nav class="navigation-bar">
    <div class="day-night-toggle">
      <span class="day-toggle">
        <label
          ><input
            type="radio"
            name="day-night"
            @change="dayOrNight = false"
            checked
          />️🌙</label
        >
      </span>
      <span class="divider-line"></span>
      <span class="night-toggle">
        <label
          ><input
            type="radio"
            name="day-night"
            @change="dayOrNight = true"
          />☀️</label
        >
      </span>
    </div>
    <span>Forecast App</span>
  </nav>
  <div class="container">
    <div class="today">
      <div v-if="dayOrNight" class="day">
        <div class="table-container"><table>
          <thead>
          <tr>
            <th>Date</th>
            <th>{{ todayDate }}</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>Phenomenon</td>
            <td>{{ todayDay?.phenomenon }}</td>
          </tr>
          <tr v-if="todayDay?.tempmin !== null">
            <td>Minimum temperature</td>
            <td>{{ todayDay?.tempmin }}</td>
          </tr>
          <tr v-if="todayDay?.tempmax !== null">
            <td>Maximum temperature</td>
            <td>{{ todayDay?.tempmax }}</td>
          </tr>
          </tbody>
        </table></div>
        <hr/>
        <div class="table-container"><table>
          <thead>
          <tr>
            <th>City</th>
            <th>Maximum temperature</th>
            <th>Phenomenon</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(place, i) in todayDay?.place" :key="i">
            <td>{{ place?.name }}</td>
            <td v-if="place.tempmax !== null">{{ place?.tempmax }}</td>
            <td v-if="place.tempmin !== null">{{ place?.tempmin }}</td>
            <td v-if="place.phenomenon !== null">{{ place?.phenomenon }}</td>
          </tr>
          </tbody>
        </table></div>
        <hr/>
        <div class="table-container"><table>
          <thead>
          <tr>
            <th>Name</th>
            <th>Direction</th>
            <th>Maximum speed</th>
            <th>Minimum speed</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(wind, i) in todayDay?.wind" :key="i">
            <td>{{ wind.name }}</td>
            <td v-if="wind.direction !== null">{{ wind.direction }}</td>
            <td v-if="wind.speedmax !== null">{{ wind.speedmax }}</td>
            <td v-if="wind.speedmin !== null">{{ wind.speedmin }}</td>
          </tr>
          </tbody>
        </table></div>
        <hr/>
        <div class="sea-peipsi">
          <div v-if="todayDay?.sea === ''">No info on sea for this day</div>
          <div v-else>Sea: {{ todayDay?.sea }}</div>
        </div>
        <hr/>
        <div class="sea-peipsi">
          <div v-if="todayDay?.peipsi === ''">
            No info on Peipsi for this day
          </div>
          <div v-else>Peipsi: {{ todayDay?.peipsi }}</div>
        </div>
      </div>
      <div v-else class="night">
        <div class="table-container">
          <table>
            <thead>
            <tr>
              <th>Date</th>
              <th>{{ todayDate }}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>Phenomenon</td>
              <td>{{ todayNight?.phenomenon }}</td>
            </tr>
            <tr v-if="todayNight?.tempmin !== null">
              <td>Minimum temperature</td>
              <td>{{ todayNight?.tempmin }}</td>
            </tr>
            <tr v-if="todayNight?.tempmax !== null">
              <td>Maximum temperature</td>
              <td>{{ todayNight?.tempmax }}</td>
            </tr>
            </tbody>
          </table>
        </div>
        <hr/>
        <div class="table-container">
          <table>
            <thead>
            <tr>
              <th>City</th>
              <th v-if="todayNight?.tempmax !== null">Minimum temperate</th>
              <th>Phenomenon</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(place, i) in todayNight?.place" :key="i">
              <td>{{ place?.name }}</td>
              <td v-if="place.tempmax !== null">{{ place?.tempmax }}</td>
              <td v-if="place.tempmin !== null">{{ place?.tempmin }}</td>
              <td v-if="place.phenomenon !== null">
                {{ place?.phenomenon }}
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <hr/>
        <div class="table-container">
          <table>
            <thead>
            <tr>
              <th>Name</th>
              <th>Direction</th>
              <th>Maximum speed</th>
              <th>Minimum speed</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(wind, i) in todayNight?.wind" :key="i">
              <td>{{ wind.name }}</td>
              <td v-if="wind.direction !== null">{{ wind.direction }}</td>
              <td v-if="wind.speedmax !== null">{{ wind.speedmax }}</td>
              <td v-if="wind.speedmin !== null">{{ wind.speedmin }}</td>
            </tr>
            </tbody>
          </table>
        </div>
        <hr/>
        <div class="sea-peipsi">
          <div v-if="todayNight?.sea === ''">
            No info on the sea for this night.
          </div>
          <div v-else>
            Sea:
            {{ todayNight?.sea }}
          </div>
        </div>
        <hr/>
        <div class="sea-peipsi">
          <div v-if="todayNight?.peipsi === ''">
            No info on Peipsi for this night.
          </div>
          <div v-else>Peipsi:
            {{ todayNight?.peipsi }}</div>
        </div>
      </div>
    </div>
    <div class="otherDays">
      <div v-if="dayOrNight">
        <div v-for="(otherDay, i) in otherDays" :key="i" :class="`day-${i}`">
          <table>
            <thead>
            <tr>
              <th>Date</th>
              <th>{{ otherDay.date }}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>Phenomenon</td>
              <td>{{ otherDay.phenomenon }}</td>
            </tr>
            <tr v-if="otherDay.tempmin !== null">
              <td>Minimum temperature</td>
              <td>{{ otherDay.tempmin }}</td>
            </tr>
            <tr v-if="otherDay.tempmax !== null">
              <td>Maximum temperature</td>
              <td>{{ otherDay.tempmax }}</td>
            </tr>
            <tr>
              <td>Additional info</td>
              <td class="info-text">{{ otherDay.text }}</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div v-else>
        <div
            v-for="(otherNight, i) in otherNights"
            :key="i"
            :class="`night-${i}`"
        >
          <table>
            <thead>
            <tr>
              <th>Date</th>
              <th>{{ otherNight.date }}</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>Phenomenon</td>
              <td>{{ otherNight.phenomenon }}</td>
            </tr>
            <tr v-if="otherNight.tempmin !== null">
              <td>Minimum temperature</td>
              <td>{{ otherNight.tempmin }}</td>
            </tr>
            <tr v-if="otherNight.tempmax !== null">
              <td>Maximum temperature</td>
              <td>{{ otherNight.tempmax }}</td>
            </tr>
            <tr>
              <td>Additional info</td>
              <td class="info-text">{{ otherNight.text }}</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  </div>
  <div v-else class="loading">
    Loading...
  </div>
</template>

<script>
import {Day, DayShort, Night, NightShort, Weather} from "@/types";

export default {
  name: "WeatherInfo",
  data() {
    return {
      weathers: null,
      dayOrNight: false,
      todayDate: null,
      todayDay: null,
      todayNight: null,
      otherDays: [],
      otherNights: [],
      isLoaded: false,
    };
  },
  mounted() {
    fetch("http://localhost:8080")
        .then(async (response) => await response.json())
        .then((data) => this.displayData(data.forecast))
        .finally(() => this.isLoaded = true);
  },
  methods: {
    displayData(forecast) {
      let weathers = [];
      for (const weather of forecast) {
        let w = new Weather(weather.date, weather.day, weather.night);
        weathers.push(w);
      }
      this.weathers = weathers;
      this.fillTodayData(weathers[0]);
      this.fillOtherDays(weathers.slice(1));
      this.fillOtherNights(weathers.slice(1));
    },
    fillTodayData(weatherToday) {
      let todayDay = weatherToday.day;
      let tonight = weatherToday.night;
      this.todayDay = new Day(
          todayDay.phenomenon,
          todayDay.tempmin,
          todayDay.tempmax,
          todayDay.text,
          todayDay.place,
          todayDay.wind,
          todayDay.sea,
          todayDay.peipsi
      );
      // console.log(todayDay);
      this.todayNight = new Night(
          tonight.phenomenon,
          tonight.tempmin,
          tonight.tempmax,
          tonight.text,
          tonight.place,
          tonight.wind,
          tonight.sea,
          tonight.peipsi
      );
      this.todayDate = weatherToday.date;
    },
    fillOtherDays(days) {
      for (const day of days) {
        let d = day.day;
        let dayShort = new DayShort(
            day.date,
            d.phenomenon,
            d.tempmin,
            d.tempmax,
            d.text
        );
        this.otherDays.push(dayShort);
      }
      // console.log(this.otherDays);
    },
    fillOtherNights(nights) {
      for (const night of nights) {
        let n = night.night;
        let nightShort = new NightShort(
            night.date,
            n.phenomenon,
            n.tempmin,
            n.tempmax,
            n.text
        );
        this.otherNights.push(nightShort);
      }
    },
    onSwitched: (dayOrNight) => !dayOrNight,
  },
};
</script>

<style scoped>
/* css reset */
html {
  box-sizing: border-box;
}

*,
*::before,
*::after {
  box-sizing: inherit;
}

body {
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
}

div {
  /*border: red 2px solid;*/
}

.container {
  display: grid;
  grid-template-columns: 60% 40%;
  width: 90vw;
  height: 90vh;
  min-height: min-content;
}

.table-container {
  display: flex;
  justify-content: center;
}

td,
th {
  text-align: center;
}

.info-text {
  text-align: justify;
}

.today {
  border-radius: 10px;
  border: 1px #2f3d47 solid;
  box-shadow: 1px 1px 6px black;
}

.heading {
  text-align: center;
}

.sea-peipsi {
  padding: 10px;
}

thead {
  background: #2c3e50;
  color: white;
  font-weight: bold;
}

.today {
  margin: 5px;
}

div[class*="day-"],
div[class*="night-"] {
  border-radius: 10px;
  border: 1px #2f3d47 solid;
  margin: 5px;
  padding: 10px;
  box-shadow: 1px 1px 6px black;
}

.otherDays {
  display: flex;
  flex-direction: column;
}

.navigation-bar > span {
  font-size: 24px;
}

.navigation-bar {
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.day-night-toggle {
  display: flex;
  justify-content: space-between;
  background: linear-gradient(#000, #000) no-repeat center/2px 100%;
  font-size: 24px;
  width: 120px;
}

input[type="radio"] {
  cursor: pointer;
}

.loading {
  width: 90vw;
  height: 90vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
