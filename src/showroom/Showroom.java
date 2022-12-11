package showroom;

import models.*;
import models.Audi.enumAudi.*;
import models.BMW.enumBMW.*;
import models.Ford.enumFord.*;
import factories.factoryAudi.FactoryAudi;
import factories.factoryBMW.FactoryBMW;
import factories.factoryFord.FactoryFord;
import models.enumAllModels.OptionsAllModels;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import models.interfaces.Color;
import models.interfaces.WheelSize;
import services.ServiceColor;
import services.ServiceOption;
import services.ServiceWheels;

import java.util.Set;

public class Showroom {

    private final ServiceColor serviceColor;
    private final ServiceWheels serviceWheels;
    private final ServiceOption serviceOption;
    private final FactoryAudi factoryAudi;
    private final FactoryBMW factoryBMW;
    private final FactoryFord factoryFord;

    public Showroom(ServiceColor serviceColor,
                    ServiceWheels serviceWheels,
                    ServiceOption serviceOption,
                    FactoryAudi factoryAudi,
                    FactoryBMW factoryBMW,
                    FactoryFord factoryFord) {
        this.serviceColor = serviceColor;
        this.serviceWheels = serviceWheels;
        this.serviceOption = serviceOption;
        this.factoryFord = factoryFord;
        this.factoryAudi = factoryAudi;
        this.factoryBMW = factoryBMW;
    }

    public Car orderAudi(
            ModelAudi model,
            EngineAudi engineVolume,
            ColorAudi color,
            WheelSizeAudi wheelSize,
            Set<OptionsAllModels> options,
            TransmissionAllModels transmission,
            WheelDriveAllModels wheelDrive) {
        return factoryAudi.createCar(
                model,
                engineVolume,
                color,
                wheelSize,
                options,
                transmission,
                wheelDrive);
    }
    public Car orderBMW(
            ModelBMW model,
            EngineBMW engineVolume,
            ColorBMW color,
            WheelSizeBMW wheelSize,
            Set<OptionsAllModels> options,
            TransmissionAllModels transmission,
            WheelDriveAllModels wheelDrive) {
        return factoryBMW.createCar(
                model,
                engineVolume,
                color,
                wheelSize,
                options,
                transmission,
                wheelDrive);
    }
    public Car Ford(
            ModelFord model,
            EngineFord engineVolume,
            ColorFord color,
            WheelSizeFord wheelSize,
            Set<OptionsAllModels> options,
            TransmissionAllModels transmission,
            WheelDriveAllModels wheelDrive) {
        return factoryFord.createCar(
                model,
                engineVolume,
                color,
                wheelSize,
                options,
                transmission,
                wheelDrive);
    }
    public void changeColor(Car car, Color color) {
        serviceColor.changeColor(car, color);
    }
    public void changeWheels(Car car, WheelSize wheelSize) {
        serviceWheels.changeWheels(car, wheelSize);
    }
    public void addOption(Car car, OptionsAllModels optionsAllModels) {
        serviceOption.addOption(car, optionsAllModels);
    }
    public void deleteOption(Car car, OptionsAllModels optionsAllModels) {
        serviceOption.deleteOption(car, optionsAllModels);
    }
    public void printFactoryBMWSettings() {
        System.out.println(factoryBMW.getConfigurations());
    }
    public void printFactoryAudiSettings() {
        System.out.println(factoryAudi.getConfigurations());
    }
    public void printFactoryMercedesSettings() {
        System.out.println(factoryFord.getConfigurations());
    }
}