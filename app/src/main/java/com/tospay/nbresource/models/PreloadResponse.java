package com.tospay.nbresource.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PreloadResponse implements Serializable {

    @SerializedName("stations")
    @Expose
    private List<Station> stations = null;
    @SerializedName("trainTypes")
    @Expose
    private List<TrainType> trainTypes = null;

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<TrainType> getTrainTypes() {
        return trainTypes;
    }

    public void setTrainTypes(List<TrainType> trainTypes) {
        this.trainTypes = trainTypes;
    }

    @Override
    public String toString() {
        return "Data{" +
                "stations=" + stations +
                ", trainTypes=" + trainTypes +
                '}';
    }
}
