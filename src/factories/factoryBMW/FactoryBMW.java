package factories.factoryBMW;

import models.*;
import models.BMW.enumBMW.*;
import models.BMW.CarBMW;
import factories.Factory;
import factories.Storage;
import models.enumAllModels.OptionsAllModels;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import models.interfaces.Color;
import models.interfaces.Engine;
import models.interfaces.Model;
import models.interfaces.WheelSize;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class FactoryBMW<
        M extends ModelBMW,
        E extends EngineBMW,
        C extends ColorBMW,
        WS extends WheelSizeBMW,
        T extends TransmissionAllModels,
        WD extends WheelDriveAllModels,
        O extends OptionsAllModels>
        extends Factory<M, E, C, WS, T, WD, O> {
    private static final int YEAR = 2022;
    private final Storage storage;

    public FactoryBMW(ColorBMW[] color,
                      ModelBMW[] model,
                      WheelSizeBMW[] wheelSize,
                      EngineBMW[] engine,
                      TransmissionAllModels[] transmission,
                      WheelDriveAllModels[] wheelDrive) {
        super(color, model, wheelSize, engine, transmission, wheelDrive);
        this.storage = new Storage();
        fillStorageWithCars();
    }

    @Override
    public Car createCar(Model model,
                         Engine engine,
                         Color color,
                         WheelSize wheelSize,
                         Set<OptionsAllModels> options,
                         TransmissionAllModels transmission,
                         WheelDriveAllModels wheelDrive) {
        CarBMW carBmw = (CarBMW) storage.getCarFromStorage(model, engine, color, wheelSize, options, transmission, wheelDrive);
        if (carBmw != null) {
            if (carBmw.getColor() != color) {
                carBmw.setColor(color);
            }
            if (carBmw.getWheelSize() != wheelSize) {
                carBmw.setWheelSize(wheelSize);
            }
            if (!carBmw.getOption().equals(options)) {
                carBmw.setOption(options);
            }
             System.out.println("BMW сar taken from the Storage");
            return carBmw;
        }
        return new CarBMW(
                YEAR, model, engine, color, wheelSize, options, transmission, wheelDrive);
    }
    public String getConfigurations() {
        return format(
                "factoryBMW can produce: " +
                        "\n colors: %s, " +
                        "\n models: %s, " +
                        "\n wheelSizes: %s, " +
                        "\n engines: %s, " +
                        "\n transmissions: %s, " +
                        "\n wheelDrives: %s" +
                        "\n ",
                Arrays.toString(ColorBMW.values()),
                Arrays.toString(ModelBMW.values()),
                Arrays.toString(WheelSizeBMW.values()),
                Arrays.toString(EngineBMW.values()),
                Arrays.toString(TransmissionAllModels.values()),
                Arrays.toString(WheelDriveAllModels.values())
        );
    }

    public void fillStorageWithCars() {
        CarBMW carBmw = new CarBMW(
                YEAR,
                ModelBMW.X5,
                EngineBMW.GASOLINE_R6_V2500,
                ColorBMW.BLUE_SKY,
                WheelSizeBMW.R15,
                new HashSet<>(List.of(OptionsAllModels.LED_HEADLIGHTS)),
                TransmissionAllModels.ROBOT,
                WheelDriveAllModels.ALL);
        this.storage.addCarToStorage(carBmw);

        Set<OptionsAllModels> optionsAllModels = new HashSet<>();
        optionsAllModels.add(OptionsAllModels.PANORAMIC_SUNROOF);
        optionsAllModels.add(OptionsAllModels.HEATED_WINDSCREEN);

        carBmw = new CarBMW(
                YEAR,
                models.BMW.enumBMW.ModelBMW.X5,
                EngineBMW.GASOLINE_R6_V2500,
                ColorBMW.BLACK,
                WheelSizeBMW.R18,
                optionsAllModels,
                TransmissionAllModels.ROBOT,
                WheelDriveAllModels.ALL);
        this.storage.addCarToStorage(carBmw);
    }
}
