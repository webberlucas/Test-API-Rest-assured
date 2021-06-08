package util;

public class BaseLocalHost {

    private String URI = "http://localhost";
    private int porta = 8080;
    private String path = "/api";

    public String getURI() {
        return URI;
    }
    public int getPorta() {
        return porta;
    }
    public String getPath() {
        return path;
    }


}
