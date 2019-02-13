package za.co.bbd.streams;

public class Task {
    private String summary;
    private int duration;

    public Task(String summary, int duration) {
        this.summary = summary;
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}