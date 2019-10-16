package sample;

public class AudioPlayer extends Product implements MultimediaControl {
    private String audioSpecification;
    private String mediaType;

    public AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
        super(name, manufacturer, "AUDIO");
        this.audioSpecification = audioSpecification;
        this.mediaType = mediaType;
    }

    public void play() {
        System.out.println("Playing");
    }

    public void stop() {
        System.out.println("Stopping");
    }

    public void previous() {
        System.out.println("Previous");
    }

    public void next() {
        System.out.println("Next");
    }

    public String toString() {
        String myString = String.format("%s\nSupported Audio Formats: %s\nSupported Playlist Formats: %s", super.toString(), audioSpecification, mediaType);
        return myString;
    }
}
