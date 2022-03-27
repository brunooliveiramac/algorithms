import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {

    public boolean classPhotos(
            List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        boolean isRedFirstRow = false;

        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        for (int i = 0; i < redShirtHeights.size(); i++) {

            int classmateRed = redShirtHeights.get(i);
            int classmateBlue = blueShirtHeights.get(i);

            if (i == 0) {
                if (classmateRed < classmateBlue) {
                    isRedFirstRow = true;
                }
            }

            if (isRedFirstRow) {
                if (classmateRed >= classmateBlue) {
                    return false;
                }
            } else {
                if (classmateBlue >= classmateRed) {
                    return false;
                }
            }
        }
        return true;
    }
}


