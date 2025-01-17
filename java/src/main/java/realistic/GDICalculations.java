package realistic;

import java.util.logging.Logger;

public class GDICalculations {

    public long calculateNewMaxGDI(BigHairyClass cg, long initialMaxGDI) {
        long updatedMaxGDI = initialMaxGDI;
        GDI maxGDI = new GDI();

        if (cg.getProperty("MaxReportGDI", ReportSettings.VT_I4, maxGDI)) {
            String s;
            if (maxGDI.value >= 9000) {
                s = "Max. GDI Object 9000. Used default (500)";
                getTrace().info(s);
                updatedMaxGDI = 500;
            }
            else {
                if (maxGDI.value != 0) {
                    s = String.format("Max. GDI Object set to:%d", updatedMaxGDI); // No ITX
                    getTrace().info(s);
                    updatedMaxGDI = maxGDI.value;
                } else {
                    updatedMaxGDI = 500;
                }
            }
        }
        else {
            updatedMaxGDI = initialMaxGDI + 10;
        }
        return updatedMaxGDI;
    }

    public Logger getTrace() {
        return Logger.getGlobal();
    }
}

