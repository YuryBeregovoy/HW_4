package services;

import models.Car;
import models.interfaces.Color;
import models.Audi.enumAudi.ColorAudi;
import models.BMW.enumBMW.ColorBMW;
import models.Ford.enumFord.ColorFord;
import exeptions.WrongColorException;

import java.util.Arrays;

public class ServiceColor implements Service {

    public void changeColor(Car car, Color color) {
        try {
            if (car != null && color != null && !color.equals(car.getColor())) {
                if (Arrays.toString(ColorBMW.values()).contains(color.toString()) &&
                        Arrays.toString(ColorBMW.values()).contains(car.getColor().toString())) {
                    car.setColor(color);
                } else if (Arrays.toString(ColorAudi.values()).contains(color.toString()) &&
                        Arrays.toString(ColorAudi.values()).contains(car.getColor().toString())) {
                    car.setColor(color);
                } else if (Arrays.toString(ColorFord.values()).contains(color.toString()) &&
                        Arrays.toString(ColorFord.values()).contains(car.getColor().toString())) {
                    car.setColor(color);
                } else {
                    throw new WrongColorException("The factory does not paint in this color!");
                }
            }
        } catch (WrongColorException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }

}