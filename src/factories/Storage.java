package factories;

import models.*;
import models.enumAllModels.OptionsAllModels;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import models.interfaces.Color;
import models.interfaces.Engine;
import models.interfaces.Model;
import models.interfaces.WheelSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Storage {

    public final List<Car> cars = new ArrayList<>();

    public void addCarToStorage(Car car) {
        cars.add(car);
    }

    public Car getCarFromStorage(
            Model model,
            Engine engine,
            Color color,
            WheelSize wheelSize,
            Set<OptionsAllModels> optionsAllModels,
            TransmissionAllModels transmission,
            WheelDriveAllModels wheelDrive) {
        Iterator<Car> iterator = cars.listIterator();
        List<Car> removed = new ArrayList<>();
        Car car = null;
        while (iterator.hasNext()) {
            Car temp = iterator.next();
            if (verifyModelEngine(temp, model, engine)) {
                if (car == null) {
                    car = temp;
                    iterator.remove();
                    continue;
                }
                if (temp.getColor() == color && car.getColor() != color) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                    continue;
                }
                if (temp.getWheelSize() == wheelSize && car.getWheelSize() != wheelSize) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                    continue;
                }
                if (temp.getOption().equals(optionsAllModels) && !car.getOption().equals(optionsAllModels)) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                }
                if (temp.getTransmission() == transmission && car.getTransmission() != transmission) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                    continue;
                }
                if (temp.getWheelDrive() == wheelDrive && car.getWheelDrive() != wheelDrive) {
                    iterator.remove();
                    removed.add(car);
                    car = temp;
                }
            }
        }
        cars.addAll(removed);
        System.out.println("\nCars in Storage: ");
        for(Car element : cars){
            System.out.println(element);
        }
        return car;
    }

    private boolean verifyModelEngine(Car car, Model model, Engine engine) {
        return car.getModel() == model && car.getEngineVolume() == engine;
    }

}
