import java.io.IOException;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) throws IOException {

        API api = new API();
        Storage storage = new Storage();
        String fullAPI = api.comeback();
        api.separate(fullAPI, "Russia");
        api.directCatch();
        api.print();
    }
}

