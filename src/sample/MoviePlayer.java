package sample;

public class MoviePlayer extends Product implements MultimediaControl {
    private Screen screen;
    private MonitorType monitorType;

    public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer, "VISUAL");
        this.screen = screen;
        this.monitorType = monitorType;
    }

    public void play() {
        System.out.println("Playing movie");
    }

    public void stop() {
        System.out.println("Stopping movie");
    }

    public void previous() {
        System.out.println("Previous movie");
    }

    public void next() {
        System.out.println("Next movie");
    }

    public String toString() {
        String myString = String.format("%s\nScreen: %s\nMonitorType: %s", super.toString(), screen, monitorType);
        return myString;
    }
}
