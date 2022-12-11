package factories.factoryFord;

import models.*;
import models.Ford.CarFord;
import models.Ford.enumFord.*;
import factories.Factory;
import factories.Storage;
import models.enumAllModels.OptionsAllModels;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import models.interfaces.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class FactoryFord<
        M extends ModelFord,
        E extends EngineFord,
        C extends ColorFord,
        WS extends WheelSizeFord,
        T extends TransmissionAllModels,
        WD extends WheelDriveAllModels,
        O extends OptionsAllModels>
        extends Factory<M, E, C, WS, T, WD, O> {

    private static final int YEAR = 2022;
//    private WheelDrive[] wheelDrive;
    private final Storage storage;

    public FactoryFord(ColorFord[] color,
                       ModelFord[] model,
                       WheelSizeFord[] wheelSize,
                       EngineFord[] engine,
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
        CarFord carFord = (CarFord) storage.getCarFromStorage(model, engine, color, wheelSize,
                options, transmission, wheelDrive);
        if (carFord != null) {
            if (carFord.getColor() != color) {
                carFord.setColor(color);
            }
            if (carFord.getWheelSize() != wheelSize) {
                carFord.setWheelSize(wheelSize);
            }
            if (!carFord.getOption().equals(options)) {
                carFord.setOption(options);
            }
            System.out.println("Ford сar taken from the Storage");
            return carFord;
        }
        return new CarFord(
                YEAR, model, engine, color, wheelSize, options, transmission, wheelDrive);
    }
    public String getConfigurations() {
        return format(
                "factoryFord can produce: " +
                        "\n colors: %s, " +
                        "\n models: %s, " +
                        "\n wheelSizes: %s, " +
                        "\n engines: %s, " +
                        "\n transmissions: %s, " +
                        "\n wheelDrives: %s" +
                        "\n ",
                Arrays.toString(ColorFord.values()),
                Arrays.toString(ModelFord.values()),
                Arrays.toString(WheelSizeFord.values()),
                Arrays.toString(EngineFord.values()),
                Arrays.toString(TransmissionAllModels.values()),
                Arrays.toString(WheelDriveAllModels.values())
        );
    }

    public void fillStorageWithCars() {
        CarFord carFord = new CarFord(
                YEAR,
                ModelFord.FIESTA,
                EngineFord.GASOLINE_DURATEC_V1600,
                ColorFord.PEARL_BLUE,
                WheelSizeFord.R13,
                new HashSet<>(),
                TransmissionAllModels.AUTOMATIC,
                WheelDriveAllModels.FRONT);
        this.storage.addCarToStorage(carFord);

        Set<OptionsAllModels> optionsAllModels = new HashSet<>();
        optionsAllModels.add(OptionsAllModels.CRUISE_CONTROL);
        optionsAllModels.add(OptionsAllModels.HEATED_SEATS);
        carFord = new CarFord(
                YEAR,
                ModelFord.MONDEO,
                EngineFord.GASOLINE_ZETEC_V3000,
                ColorFord.FROZEN_WHITE,
                WheelSizeFord.R13,
                optionsAllModels,
                TransmissionAllModels.MANUAL,
                WheelDriveAllModels.ALL);
        this.storage.addCarToStorage(carFord);

    }
}
