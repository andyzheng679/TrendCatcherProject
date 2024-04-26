package com.example.trendCatcherProject.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class StockService {

    @Value("${apiKey}")
    private String apiKey;
    private final String alphaVantageURL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
    private final RestTemplate restTemplate;

    @Autowired
    public StockService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    //inject RestTemplate obj when StockService is created
    //configured and a bean

    public List<StockData> getHistoricData(String stockSymbol){
        String url = alphaVantageURL + stockSymbol + "&outputsize=full&apikey=" + apiKey;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        //used to make an HTTP GET call to the url nad expect a String result back

        String responseBody = response.getBody();
        //this retrieves and stores the content of the HTTP response body returned by the GET call.

        List<StockData> stockDataList = new ArrayList<>();
        //will contain information for each day

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            //serialize java obj to JSON and deserialize JSON to java obj
            JsonNode rootNode = objectMapper.readTree(responseBody);
            //JsonNode is tree structure, readTree parse JSON String into tree structure

            JsonNode timeSeriesNode = rootNode.get("Time Series (Daily)");
            //gets info from Time Series (Daily) key that contains all info

            if (timeSeriesNode != null && timeSeriesNode.isObject()) {
                Iterator<Map.Entry<String, JsonNode>> fields = timeSeriesNode.fields();
                //looping through a map like structure, key values

                LocalDate fiveYearsAgo = LocalDate.now().minusYears(1); //change back to 5 years
                //date 5 year from today

                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    LocalDate entryDate = LocalDate.parse(entry.getKey());
                    //converting date string from JSON to LocalDate obj

                    if (!entryDate.isBefore(fiveYearsAgo)) {
                        //if date is not before 5 years ago
                        JsonNode dataNode = entry.getValue();
                        StockData stockData = new StockData(
                                entry.getKey(),
                                dataNode.get("1. open").asDouble(),
                                dataNode.get("2. high").asDouble(),
                                dataNode.get("3. low").asDouble(),
                                dataNode.get("4. close").asDouble()
                        );
                        stockDataList.add(stockData);
                    }
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        updateTwoDayMove(stockDataList);
        updateFiveDayMove(stockDataList);
        updateTenDayMove(stockDataList);

        return  stockDataList;
    }

    public void updateTwoDayMove(List<StockData> stockDataList){
        for(int i = stockDataList.size()-1; i >= 0; i--){
            StockData startDay = stockDataList.get(i);
            //set to ith object
            if(i - 2 >= 0){
                StockData futureTwoDays = stockDataList.get(i - 2);
                //get 2 days ahead of startDay

                double twoDayPercentageMove = calculatePercentageMove(startDay.getOpen(), futureTwoDays.getClose());
                startDay.setTwoDayPercentageMove(twoDayPercentageMove);
            }else{
                startDay.setTwoDayPercentageMove(100.00);
                //if future days don't exist, set to 100.00
            }
        }
    }

    public void updateFiveDayMove(List<StockData> stockDataList){
        for(int i = stockDataList.size()-1; i >= 0; i--){
            StockData startDay = stockDataList.get(i);
            //set to ith object
            if(i - 5 >= 0){
                StockData futureFiveDays = stockDataList.get(i - 5);
                //get 5 days ahead of startDay

                double fiveDayPercentageMove = calculatePercentageMove(startDay.getOpen(), futureFiveDays.getClose());
                startDay.setFiveDayPercentageMove(fiveDayPercentageMove);
            }else{
                startDay.setFiveDayPercentageMove(100.00);
                //if future days don't exist, set to 100.00
            }
        }
    }

    public void updateTenDayMove(List<StockData> stockDataList){
        for(int i = stockDataList.size()-1; i >= 0; i--){
            StockData startDay = stockDataList.get(i);
            //set to ith object
            if(i - 10 >= 0){
                StockData futureTenDays = stockDataList.get(i - 10);
                //get 10 days ahead of startDay

                double tenDayPercentageMove = calculatePercentageMove(startDay.getOpen(), futureTenDays.getClose());
                startDay.setTenDayPercentageMove(tenDayPercentageMove);
            }else{
                startDay.setTenDayPercentageMove(100.00);
                //if future days don't exist, set to 100.00
            }
        }
    }

    public double calculatePercentageMove(double start, double end) {
        double result =  ((end - start) / start) * 100;
        return Math.ceil(result * 100)/100;
    }

    public double averageDayMove(List<StockData> stockDataList){
        //finding avg 2 day move
    }



}
