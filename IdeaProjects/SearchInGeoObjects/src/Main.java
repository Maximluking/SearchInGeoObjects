import Services.CmdLineService;
import Services.impl.VehicleServiceDB;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CmdLineService cmdLineService = new CmdLineService(new VehicleServiceDB());
        cmdLineService.mainMenu();
    }
}
