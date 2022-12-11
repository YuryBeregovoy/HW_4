package services;

import models.Car;
import models.interfaces.WheelSize;
import models.Audi.enumAudi.WheelSizeAudi;
import models.BMW.enumBMW.WheelSizeBMW;
import models.Ford.enumFord.WheelSizeFord;
import exeptions.WrongWheelSizeException;

import java.util.Arrays;

public class ServiceWheels implements Service {

    public void changeWheels(Car car, WheelSize wheelSize) {
        try {
            if (car != null && wheelSize != null && !wheelSize.equals(car.getWheelSize())) {
                if (Arrays.toString(WheelSizeBMW.values()).contains(wheelSize.toString()) &&
                        Arrays.toString(WheelSizeBMW.values()).contains(car.getWheelSize().toString())) {
                    car.setWheelSize(wheelSize);
                } else if (Arrays.toString(WheelSizeAudi.values()).contains(wheelSize.toString()) &&
                        Arrays.toString(WheelSizeAudi.values()).contains(car.getWheelSize().toString())) {
                    car.setWheelSize(wheelSize);
                } else if (Arrays.toString(WheelSizeFord.values()).contains(wheelSize.toString()) &&
                        Arrays.toString(WheelSizeFord.values()).contains(car.getWheelSize().toString())) {
                    car.setWheelSize(wheelSize);
                } else {
                    throw new WrongWheelSizeException("There are no wheels of this size in the factory!");
                }
            }
        } catch (WrongWheelSizeException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}