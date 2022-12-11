import models.Audi.enumAudi.*;
import models.Audi.CarAudi;
import models.BMW.CarBMW;
import models.Ford.CarFord;
import models.enumAllModels.OptionsAllModels;
import models.BMW.enumBMW.*;
import models.Ford.enumFord.*;
import factories.factoryAudi.FactoryAudi;
import factories.factoryBMW.FactoryBMW;
import factories.factoryFord.FactoryFord;
import models.enumAllModels.TransmissionAllModels;
import models.enumAllModels.WheelDriveAllModels;
import services.ServiceColor;
import services.ServiceOption;
import services.ServiceWheels;
import showroom.Showroom;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ServiceColor serviceColor = new ServiceColor();
        ServiceWheels serviceWheels = new ServiceWheels();
        ServiceOption serviceOption = new ServiceOption();

        FactoryBMW factoryBMW = new FactoryBMW(
                ColorBMW.values(),
                ModelBMW.values(),
                WheelSizeBMW.values(),
                EngineBMW.values(),
                TransmissionAllModels.values(),
                WheelDriveAllModels.values()
        );

        FactoryAudi factoryAudi = new FactoryAudi(
                ColorAudi.values(),
                ModelAudi.values(),
                WheelSizeAudi.values(),
                EngineAudi.values(),
                TransmissionAllModels.values(),
                WheelDriveAllModels.values()
        );

        FactoryFord factoryFord = new FactoryFord(
                ColorFord.values(),
                ModelFord.values(),
                WheelSizeFord.values(),
                EngineFord.values(),
                TransmissionAllModels.values(),
                WheelDriveAllModels.values()
        );

        Showroom showRoom = new Showroom(serviceColor, serviceWheels, serviceOption, factoryAudi, factoryBMW, factoryFord);

        showRoom.printFactoryBMWSettings();
        showRoom.printFactoryAudiSettings();
        showRoom.printFactoryMercedesSettings();

        System.out.println();
        CarBMW carBmw = (CarBMW) showRoom.orderBMW(
                ModelBMW.X5,
                EngineBMW.GASOLINE_R6_V2500,
                ColorBMW.BLUE_SKY,
                WheelSizeBMW.R15,
                new HashSet<>(List.of(OptionsAllModels.LED_HEADLIGHTS)),
                TransmissionAllModels.ROBOT,
                WheelDriveAllModels.ALL);
        System.out.println();

        CarAudi carAudi = (CarAudi) showRoom.orderAudi(
                ModelAudi.R8,
                EngineAudi.GASOLINE_MPI_V3600,
                ColorAudi.BRIGHT_RED,
                WheelSizeAudi.R21,
                new HashSet<>(),
                TransmissionAllModels.AUTOMATIC,
                WheelDriveAllModels.REAR);
        System.out.println();

        CarFord carFord = (CarFord) showRoom.Ford(
                ModelFord.MONDEO,
                EngineFord.GASOLINE_ZETEC_V3000,
                ColorFord.FROZEN_WHITE,
                WheelSizeFord.R13,
                new HashSet<>(),
                TransmissionAllModels.AUTOMATIC,
                WheelDriveAllModels.FRONT);

        showRoom.changeColor(carBmw, ColorBMW.DEEP_RED);
        showRoom.changeWheels(carAudi, WheelSizeAudi.R16);
        showRoom.addOption(carBmw, OptionsAllModels.PARKING_CAMERA);
        showRoom.addOption(carBmw, OptionsAllModels.CRUISE_CONTROL);
        showRoom.deleteOption(carFord, OptionsAllModels.CRUISE_CONTROL);
        showRoom.deleteOption(carFord, OptionsAllModels.HEATED_SEATS);

        System.out.println("\nReceived BMW car: \n" + carBmw.toString());
        System.out.println("\nReceived Audi car: \n" + carAudi.toString());
        System.out.println("\nReceived Ford car: \n" + carFord.toString());

    }
}