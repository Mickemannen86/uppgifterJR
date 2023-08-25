package com.mickenator.uppgiftery2.uppgifter.services;




import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mickenator.uppgiftery2.uppgifter.models.Forcast;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ForecastService {

    private static List<Forcast> forecasts = new ArrayList<>();

    public ForecastService() {
        try {
            forecasts = readFromFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Forcast> getForecasts(){
        return forecasts;
    }
    public void add(Forcast forecast) throws IOException {
        forecasts.add(forecast);
        writeAllToFile(forecasts);
    }

    public Forcast getByIndex(int i) {
        return forecasts.get(i);
    }

    public void update(Forcast forecast) throws IOException {
        writeAllToFile(forecasts);
    }

    // del 2
    private List<Forcast> readFromFile() throws IOException {
        if(!Files.exists(Path.of("predictions.json"))) return new ArrayList<Forcast>();
        ObjectMapper objectMapper = getObjectMapper();
        var jsonStr = Files.readString(Path.of("predictions.json"));
        return  new ArrayList(Arrays.asList(objectMapper.readValue(jsonStr, Forcast[].class ) ));
    }


    private void writeAllToFile(List<Forcast> weatherPredictions) throws IOException {
        ObjectMapper objectMapper = getObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);


        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, weatherPredictions);

        Files.writeString(Path.of("predictions.json"), stringWriter.toString());

    }


    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.registerModule(new JavaTimeModule());
    /*
    <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-jsr310</artifactId>
    </dependency>
    */
        return mapper;
    }

}


// Kaoset


/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ForecastService {
    /*
    private static List<Forcast> allForcasts;

    public ForecastService() {
        if (allForcasts == null) {
            try {
                allForcasts = readFromFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public List<Forcast> getAll() {return allForcasts;}
    /*
    private List<Forcast> readFromFile() throws IOException {
        if (!Files.exists(Path.of("forecasts.xml"))) return new ArrayList<Forcast>();
        ObjectMapper objectMapper = getObjectMapper();
        var jsonStr = Files.readString(Path.of("forecasts.xml"));
        return new ArrayList(Arrays.asList(objectMapper.readValue(jsonStr, Forcast[].class)));
    }
    /*
    private void writeAllToFile(List<Forcast> forecasts) throws IOException {
        ObjectMapper objectMapper = getObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, forecasts);

        Files.writeString(Path.of("forecasts.xml"), stringWriter.toString());
    }
    */
    /*
    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }


private static List<Forcast> forecasts = new ArrayList<>();

    public List<Forcast> getForecasts(){
        return forecasts;
    }

    public void add(Forcast forecast) throws IOException {
        forecasts.add(forecast);
        //allForcasts.add(forecast);
        this.writeAllToFile(allForcasts);
    }
    */
    /*
    public void update(Forcast t) throws IOException {
        var existing = allForcasts.stream().filter(c->c.getId().equals(t.getId())).findFirst().orElseThrow();
        existing.setTemperature(t.getTemperature());
        existing.setDate(t.getDate());
        existing.setHour(t.getHour());
        this.writeAllToFile(allForcasts);
    }

}
 */


















