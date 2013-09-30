package org.springframework.social.tumblr.api;

import java.util.List;

public class Post extends BaseEntity {

    private long id;
    private String blogName;
    private PostType type;
    private String postUrl;
    private long timestamp;
    private String gmtDateString;
    private String format;
    private String reblogKey;
    private List<String> tags;
    private int noteCount;
    private boolean createdViaBookmarklet;
    private boolean createdViaMobile;
    private String sourceUrl;
    private String sourceTitle;
    private boolean liked;
    private PostState state;

    // text type, link type, chat type
    private String title;
    // text type, chat type
    private String body;

    // photo type, audio type, video type
    private String caption;
    // photo type
    private int width;
    // photo type
    private int height;

    // photo type, photoset
    private List<Photo> photos;

    // quote type
    private String text;
    // quote type
    private String source;

    // link type
    private String url;
    // link type
    private String description;

    // chat type
    private List<ChatMessage> dialogue;

    // audio type
    private String audioPlayer;
    // audio type
    private int plays;
    // audio type
    private String albumArt;
    // audio type
    private String artist;
    // audio type
    private String album;
    // audio type
    private String trackName;
    // audio type
    private int trackNumber;
    // audio type
    private int year;

    // video type
    private List<VideoPostPlayer> videoPlayers;

    // answer type (?)
    private String askingName;
    private String askingUrl;
    private String question;
    private String answer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getGmtDateString() {
        return gmtDateString;
    }

    public void setGmtDateString(String gmtDateString) {
        this.gmtDateString = gmtDateString;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReblogKey() {
        return reblogKey;
    }

    public void setReblogKey(String reblogKey) {
        this.reblogKey = reblogKey;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public boolean isCreatedViaBookmarklet() {
        return createdViaBookmarklet;
    }

    public void setCreatedViaBookmarklet(boolean createdViaBookmarklet) {
        this.createdViaBookmarklet = createdViaBookmarklet;
    }

    public boolean isCreatedViaMobile() {
        return createdViaMobile;
    }

    public void setCreatedViaMobile(boolean createdViaMobile) {
        this.createdViaMobile = createdViaMobile;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceTitle() {
        return sourceTitle;
    }

    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public PostState getState() {
        return state;
    }

    public void setState(PostState state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChatMessage> getDialogue() {
        return dialogue;
    }

    public void setDialogue(List<ChatMessage> dialogue) {
        this.dialogue = dialogue;
    }

    public String getAudioPlayer() {
        return audioPlayer;
    }

    public void setAudioPlayer(String audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<VideoPostPlayer> getVideoPlayers() {
        return videoPlayers;
    }

    public void setVideoPlayers(List<VideoPostPlayer> videoPlayers) {
        this.videoPlayers = videoPlayers;
    }

    public String getAskingName() {
        return askingName;
    }

    public void setAskingName(String askingName) {
        this.askingName = askingName;
    }

    public String getAskingUrl() {
        return askingUrl;
    }

    public void setAskingUrl(String askingUrl) {
        this.askingUrl = askingUrl;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", blogName='" + blogName + '\'' +
                ", type=" + type +
                ", postUrl='" + postUrl + '\'' +
                ", timestamp=" + timestamp +
                ", gmtDateString='" + gmtDateString + '\'' +
                ", format='" + format + '\'' +
                ", reblogKey='" + reblogKey + '\'' +
                ", tags=" + tags +
                ", noteCount=" + noteCount +
                ", createdViaBookmarklet=" + createdViaBookmarklet +
                ", createdViaMobile=" + createdViaMobile +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", sourceTitle='" + sourceTitle + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", caption='" + caption + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", photos=" + photos +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", dialogue=" + dialogue +
                ", audioPlayer='" + audioPlayer + '\'' +
                ", plays=" + plays +
                ", albumArt='" + albumArt + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", trackName='" + trackName + '\'' +
                ", trackNumber=" + trackNumber +
                ", year=" + year +
                ", videoPlayers=" + videoPlayers +
                ", askingName='" + askingName + '\'' +
                ", askingUrl='" + askingUrl + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                "} " + super.toString();
    }
}
