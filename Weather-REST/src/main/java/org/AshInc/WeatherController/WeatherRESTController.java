package org.AshInc.WeatherController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class WeatherRESTController {
    @GetMapping("/")
    public void getWeather() throws MalformedURLException {
        URL url;
        url = new URL("https://api.weather.yandex.ru/v2/forecast?lat=53.893009&lon=27.567444");
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("X-Yandex-API-Key","ff127441-1421-4fc9-a030-ae8be2bb55c0");
            httpURLConnection.setRequestProperty("Accept","application/json");
            httpURLConnection.connect();

            int response = httpURLConnection.getResponseCode();
            System.out.println("STATUS "+response);

            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String inputLine;
            StringBuilder response1 = new StringBuilder();

            while (true) {
                if ((inputLine = in.readLine()) != null){
                    response1.append(inputLine);
                }
                break;
            }

            in.close();
            System.out.println("Response Body: " + response1);

            try (FileWriter fileWriter = new FileWriter("C:\\Users\\gk\\Documents\\SpringbootBasic\\Weather-REST\\src\\main\\resources\\response.JSON")){
                fileWriter.write(response1.toString());
            }

            String jsonString = response1.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // Преобразование строки JSON в JsonNode
                JsonNode rootNode = objectMapper.readTree(jsonString);
                JsonNode forecasts = rootNode.path("forecasts");

                // Перебор прогнозов для получения температуры на 15:00
                int i = 0;
                for (JsonNode forecast : forecasts) {
                    JsonNode hours = forecast.path("hours");

                    for (JsonNode hour : hours) {
                        String hourValue = hour.path("hour").asText();
                        if (Integer.toString(i).equals(hourValue)) {
                            int temperature = hour.path("temp").asInt();
                            if (i<24)
                                WeatherNow.temperatures[i++] = temperature;
                            System.out.printf("Hour: %d Temperature: %d%n", hour.path("hour").asInt(), temperature);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(WeatherNow.temperatures));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
