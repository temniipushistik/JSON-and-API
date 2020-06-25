import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fullAPI;
        API api = new API();
        fullAPI = api.comeback();
        System.out.println(api.separate(fullAPI, "Australia"));




    }
}

