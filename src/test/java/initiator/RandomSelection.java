package initiator;

import java.util.Random;

public class RandomSelection {

    public String random(String[] s) {
        Random r = new Random();
        return s[r.nextInt(s.length)];
    }
}
