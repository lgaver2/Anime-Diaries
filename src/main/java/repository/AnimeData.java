package repository;

import java.util.HashMap;

/**
 * AnimeData
 * the main class for this application to store critical data as
 * - title, score, number of episodes
 * - the list of each comments for one anime
 * Just for one anime
 */
public class AnimeData {
    private String title;
    private float averageScore;
    private int totalEpisodeNumber;
    private int currentEpisode;
    // list of comments indexed by the episode
    private HashMap<Integer, AnimeCommentData> comments;

    public AnimeData(String title, float averageScore, int totalEpisodeNumber, int currentEpisode, HashMap<Integer, AnimeCommentData> comments) {
        this.title = title;
        this.averageScore = averageScore;
        this.totalEpisodeNumber = totalEpisodeNumber;
        this.currentEpisode = currentEpisode;
        this.comments = comments;
    }
    // for Jakson which use a void constructor
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
