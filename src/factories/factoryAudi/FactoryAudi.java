package factories.factoryAudi;

import models.*;
import models.Audi.enumAudi.*;
import models.Audi.CarAudi;
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
import java.util.Set;

import static java.lang.String.format;

public class FactoryAudi<
        M extends ModelAudi,
        E extends EngineAudi,
        C extends ColorAudi,
        WS extends WheelSizeAudi,
        T extends TransmissionAllModels,
        WD extends WheelDriveAllModels,
        O extends OptionsAllModels>
        extends Factory<M, E, C, WS, T, WD, O> {

    private static final int YEAR = 2022;

    private final Storage storage;

    public FactoryAudi(ColorAudi[] color,
                       ModelAudi[] model,
                       WheelSizeAudi[] wheelSize,
                       EngineAudi[] engine,
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
        CarAudi carAudi = (CarAudi) storage.getCarFromStorage(model, engine, color, wheelSize,
                options, transmission, wheelDrive);
        if (carAudi != null) {
            if (carAudi.getColor() != color) {
                carAudi.setColor(color);
            }
            if (carAudi.getWheelSize() != wheelSize) {
                carAudi.setWheelSize(wheelSize);
            }
            if (!carAudi.getOption().equals(options)) {
                carAudi.setOption(options);
            }
            System.out.println("Audi сar taken from the Storage");
            return carAudi;
        }
        return new CarAudi(
                YEAR, model, engine, color, wheelSize, options, transmission, wheelDrive);
    }

    public String getConfigurations() {
        return format(
                "factoryAudi can produce:" +
                        "\n colors: %s, " +
                        "\n models: %s, " +
                        "\n wheelSizes: %s, " +
                        "\n engines: %s, " +
                        "\n transmissions: %s, " +
                        "\n wheelDrives: %s" +
                        "\n ",
                Arrays.toString(ColorAudi.values()),
                Arrays.toString(models.Audi.enumAudi.ModelAudi.values()),
                Arrays.toString(WheelSizeAudi.values()),
                Arrays.toString(EngineAudi.values()),
                Arrays.toString(TransmissionAllModels.values()),
                Arrays.toString(WheelDriveAllModels.values())
        );
    }

    public void fillStorageWithCars() {
        CarAudi carAudi = new CarAudi(
                YEAR,
                        ModelAudi.A8,
                        EngineAudi.GASOLINE_MPI_V3600,
                        ColorAudi.BRIGHT_RED,
                        WheelSizeAudi.R21,
                        new HashSet<>(),
                        TransmissionAllModels.AUTOMATIC,
                        WheelDriveAllModels.REAR);
        this.storage.addCarToStorage(carAudi);

        Set<OptionsAllModels> optionsAllModels = new HashSet<>();
        optionsAllModels.add(OptionsAllModels.LED_HEADLIGHTS);
        optionsAllModels.add(OptionsAllModels.PARKING_CAMERA);
        carAudi = new CarAudi(
                YEAR,
                ModelAudi.A8,
                EngineAudi.GASOLINE_FSI_V1600,
                ColorAudi.BLUE,
                WheelSizeAudi.R17,
                optionsAllModels,
                TransmissionAllModels.MANUAL,
                WheelDriveAllModels.REAR);
        this.storage.addCarToStorage(carAudi);
    }
}