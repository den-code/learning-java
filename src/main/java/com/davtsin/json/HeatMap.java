package com.davtsin.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeatMap {
    private PopulationSht populationSht;
    private List<HmItem> itemsList;

    public PopulationSht getPopulationSht() {
        return populationSht;
    }

    public void setPopulationSht(PopulationSht populationSht) {
        this.populationSht = populationSht;
    }

    // different field name
    @JsonProperty("items")
    public List<HmItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<HmItem> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return "HeatMap{" +
                "populationSht=" + populationSht +
                ", itemsList=" + itemsList +
                '}';
    }
}
