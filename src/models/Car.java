package models;

import models.enumAllModels.OptionsAllModels;
import models.interfaces.*;

import java.util.Set;

public abstract class Car {

    private final int year;
    private final Model model;
    private final Engine engine;
    private final Transmission transmission;
    private final WheelDrive wheelDrive;
    private Color color;
    private WheelSize wheelSize;
    private Set<OptionsAllModels> optionsAllModels;


    public Car(int year, Model model, Engine engine, Color color,
               WheelSize wheelSize, Set<OptionsAllModels> optionsAllModels, Transmission transmission, WheelDrive wheelDrive) {
        this.year = year;
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.wheelSize = wheelSize;
        this.optionsAllModels = optionsAllModels;
        this.transmission = transmission;
        this.wheelDrive = wheelDrive;
    }
    public Color getColor() {
        return color;
    }
    public Model getModel() {
        return model;
    }
    public WheelSize getWheelSize() {
        return wheelSize;
    }
    public Engine getEngineVolume() {
        return engine;
    }
    public Set<OptionsAllModels> getOption() {
        return optionsAllModels;
    }
    public Transmission getTransmission() {
        return transmission;
    }
    public WheelDrive getWheelDrive() {
        return wheelDrive;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }
    public void setOption(Set<OptionsAllModels> optionsAllModels) {
        this.optionsAllModels = optionsAllModels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", model=" + model +
                ", engineVolume=" + engine +
                ", color=" + color +
                ", wheelSize=" + wheelSize +
                ", option=" + optionsAllModels +
                ", transmission=" + transmission +
                ", wheelDrive=" + wheelDrive;
    }

}
