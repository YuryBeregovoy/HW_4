package factories;

import models.*;
import models.enumAllModels.OptionsAllModels;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import models.interfaces.*;
import java.util.Arrays;
import java.util.Set;

import static java.lang.String.format;

public abstract class Factory<
        M extends Model,
        E extends Engine,
        C extends Color,
        WS extends WheelSize,
        T extends TransmissionAllModels,
        WD extends WheelDriveAllModels,
        O extends OptionsAllModels>{

    private final Color[] color;
    private final Model[] model;
    private final WheelSize[] wheelSize;
    private final Engine[] engine;
    private final Transmission[] transmission;
    private final WheelDrive[] wheelDrive;

    public Factory(Color[] color,
                   Model[] model,
                   WheelSize[] wheelSize,
                   Engine[] engine,
                   Transmission[] transmission,
                   WheelDrive[] wheelDrive) {
        this.color = color;
        this.model = model;
        this.wheelSize = wheelSize;
        this.engine = engine;
        this.transmission = transmission;
        this.wheelDrive = wheelDrive;
    }

    public abstract Car createCar(models.interfaces.Model model,
                                  models.interfaces.Engine engineVolume,
                                  Color color,
                                  WheelSize wheelSize,
                                  Set<OptionsAllModels> optionsAllModels,
                                  TransmissionAllModels transmission,
                                  WheelDriveAllModels wheelDrive);

    public String getConfigurations() {
        return format(
                Arrays.toString(color),
                Arrays.toString(model),
                Arrays.toString(wheelSize),
                Arrays.toString(engine),
                Arrays.toString(transmission),
                Arrays.toString(wheelDrive)
        );
    }

    public abstract void fillStorageWithCars();

}
