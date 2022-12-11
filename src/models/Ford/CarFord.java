package models.Ford;

import models.Car;
import models.enumAllModels.OptionsAllModels;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import models.interfaces.*;

import java.util.Set;

public class CarFord extends Car {

    public CarFord(
            int year,
            Model model,
            Engine engineVolume,
            Color color,
            WheelSize wheelSize,
            Set<OptionsAllModels> optionsAllModels,
            TransmissionAllModels transmission,
            WheelDriveAllModels wheelDrive) {
        super(year,
              model,
              engineVolume,
              color,
              wheelSize,
              optionsAllModels,
              transmission,
              wheelDrive);
        }

    @Override
    public String toString() {
        return "Ford {" +
                super.toString() +
                '}';
    }

}
