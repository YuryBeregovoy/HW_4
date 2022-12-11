package services;

import models.Car;
import models.enumAllModels.OptionsAllModels;

public class ServiceOption implements Service {

    public void addOption(Car car, OptionsAllModels optionsAllModels) {
        try {
            if (car != null && optionsAllModels != null && car.getOption() != null) {
                car.getOption().add(optionsAllModels);
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void deleteOption(Car car, OptionsAllModels optionsAllModels) {
        try {
            if (car != null && optionsAllModels != null && car.getOption() != null) {
                car.getOption().remove(optionsAllModels);
            }
        } catch (NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
