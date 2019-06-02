package com.davtsin.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

public class DifferentFieldNames {
    private static Logger logger = LoggerFactory.getLogger(DifferentFieldNames.class);

    public static void main(String[] args) throws IOException {
        DifferentFieldNames obj = new DifferentFieldNames();
        obj.run();
    }

    private void run() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        HeatMap heatMap = createDummyObject();

        // Convert object to JSON string
        String jsonInString = mapper.writeValueAsString(heatMap);
        logger.debug(jsonInString);

        // Convert object to JSON string and pretty print
//        jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(heatMap);
//        logger.debug(jsonInString);

        // Convert JSON string to object
        heatMap = null;
        heatMap = mapper.readValue(jsonInString, HeatMap.class);
        logger.debug("Deserialized object: {}", heatMap);

    }

    private HeatMap createDummyObject() {
        HeatMap heatMap = new HeatMap();
        heatMap.setPopulationSht(new PopulationSht());
        heatMap.setItemsList(Arrays.asList(new HmItem(), new HmItem()));
        return heatMap;

    }
}
