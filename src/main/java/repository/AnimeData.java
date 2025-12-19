package repository;

import java.util.HashMap;

public class AnimeData {
    private String title;
    private float averageScore;
    private int totalEpisodeNumber;
    private int currentEpisode;

    private HashMap<Integer, AnimeCommentData> comments;

    public AnimeData(String title, float averageScore, int totalEpisodeNumber, int currentEpisode, HashMap<Integer, AnimeCommentData> comments) {
        this.title = title;
        this.averageScore = averageScore;
        this.totalEpisodeNumber = totalEpisodeNumber;
        this.currentEpisode = currentEpisode;
        this.comments = comments;
    }

    public AnimeData() {
    }

    public String getTitle() {
        return title;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public int getTotalEpisodeNumber() {
        return totalEpisodeNumber;
    }

    public int getCurrentEpisode() {
        return currentEpisode;
    }

    public HashMap<Integer, AnimeCommentData> getComments() {
        return comments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public void setTotalEpisodeNumber(int totalEpisodeNumber) {
        this.totalEpisodeNumber = totalEpisodeNumber;
    }

    public void setCurrentEpisode(int currentEpisode) {
        this.currentEpisode = currentEpisode;
    }

    public void setComments(HashMap<Integer, AnimeCommentData> comments) {
        this.comments = comments;
    }
}
