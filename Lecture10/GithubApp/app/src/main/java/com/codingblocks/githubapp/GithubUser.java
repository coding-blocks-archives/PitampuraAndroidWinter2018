package com.codingblocks.githubapp;

public class GithubUser {

    private String login, profileUrl, score, imageUrl;

    public GithubUser(String login, String profileUrl, String score, String imageUrl) {
        this.login = login;
        this.profileUrl = profileUrl;
        this.score = score;
        this.imageUrl = imageUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getScore() {
        return score;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
