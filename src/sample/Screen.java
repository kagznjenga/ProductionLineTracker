package sample;

public class Screen implements ScreenSpec {
    private String resolution;
    private int refreshrate;
    private int responsetime;

    public Screen(String resolution, int refreshrate, int responsetime) {
        this.resolution = resolution;
        this.refreshrate = refreshrate;
        this.responsetime = responsetime;
    }

    public String getResolution() {
        return resolution;
    }

    public int getRefreshRate() {
        return refreshrate;
    }

    public int getResponseTime() {
        return responsetime;
    }

    public String toString() {
        String myString = String.format("\nResolution: %s\nRefresh Rate: %s\nResponse Time: %s", resolution, refreshrate, responsetime);
        return myString;
    }
}
