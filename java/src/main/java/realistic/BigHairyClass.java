package realistic;

import java.util.Random; /**
 * hard to construct - cannot be used in a unit test
 */
public class BigHairyClass {
   public BigHairyClass() {
       throw new RuntimeException("cannot be constructed in a unit test");
   }

    public boolean getProperty(String maxReportGDI, ReportSettings settings, GDI maxGDI) {
       maxGDI.value = new Random().nextInt(10000);
       return true;
    }
}
