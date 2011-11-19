package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.node.ArrayNode;
import org.springframework.social.tumblr.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 * @version $Id$
 */
@JsonDeserialize(using = PostMixin.PostDeserializer.class)
class PostMixin {

    static class PostDeserializer extends JsonDeserializer<Post> {

        @Override
        public Post deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode root = jp.readValueAsTree();

            Post post = new Post();

            post.setId(root.get("id").getLongValue());
            post.setBlogName(root.get("blog_name").getTextValue());
            post.setType(PostType.getByType(root.get("type").getTextValue()));
            post.setPostUrl(root.get("post_url").getTextValue());
            post.setTimestamp(root.get("timestamp").getLongValue());
            post.setGmtDateString(root.get("date").getTextValue());
            post.setFormat(root.get("format").getTextValue());
            post.setReblogKey(root.get("reblog_key").getTextValue());
            List<String> tags = new ArrayList<String>();
            JsonNode tagsNode = root.get("tags");
            if (tagsNode != null && tagsNode.isArray()) {
                ArrayNode tagsArray = (ArrayNode) tagsNode;
                for (int i = 0; i < tagsArray.size(); i++) {
                    tags.add(tagsArray.get(i).getTextValue());
                }
            }
            post.setTags(tags);
            if (root.get("note_count") != null) {
                post.setNoteCount(root.get("note_count").getIntValue());
            }
            post.setCreatedViaBookmarklet(root.get("bookmarklet") != null);
            post.setCreatedViaMobile(root.get("mobile") != null);
            if (root.get("source_url") != null) {
                post.setSourceUrl(root.get("source_url").getTextValue());
            }
            if (root.get("source_title") != null) {
                post.setSourceTitle(root.get("source_title").getTextValue());
            }

            switch (post.getType()) {
                case TEXT:
                    if (root.get("title") != null) {
                        post.setTitle(root.get("title").getTextValue());
                    }
                    post.setTitle(root.get("body").getTextValue());
                    break;
                case PHOTO:
                    if (root.get("caption") != null) {
                        post.setCaption(root.get("caption").getTextValue());
                    }
                    if (root.get("width") != null) {
                        post.setWidth(root.get("width").getIntValue());
                    }
                    if (root.get("height") != null) {
                        post.setHeight(root.get("height").getIntValue());
                    }
                    List<Photo> photos = new ArrayList<Photo>();
                    JsonNode photosNode = root.get("photos");
                    if (photosNode != null && photosNode.isArray()) {
                        ArrayNode photosArray = (ArrayNode) photosNode;
                        for (int i = 0; i < photosArray.size(); i++) {
                            Photo photo = new Photo();
                            JsonNode photoNode = photosArray.get(i);
                            photo.setCaption(photoNode.get("caption").getTextValue());
                            ArrayNode sizesArray = (ArrayNode) photoNode.get("alt_sizes");
                            List<PhotoSize> sizes = new ArrayList<PhotoSize>();
                            for (int j = 0; j < sizesArray.size(); j++) {
                                PhotoSize size = new PhotoSize();
                                JsonNode sizeNode = sizesArray.get(j);
                                size.setUrl(sizeNode.get("url").getTextValue());
                                size.setWidth(sizeNode.get("width").getIntValue());
                                size.setHeight(sizeNode.get("height").getIntValue());
                                sizes.add(size);
                            }
                            photo.setSizes(sizes);
                            photos.add(photo);
                        }
                        post.setPhotos(photos);
                    }
                    break;
                case QUOTE:
                    post.setText(root.get("text").getTextValue());
                    if (root.get("source") != null) {
                        post.setSource(root.get("source").getTextValue());
                    }
                    break;
                case LINK:
                    post.setUrl(root.get("url").getTextValue());
                    if (root.get("title") != null) {
                        post.setTitle(root.get("title").getTextValue());
                    }
                    if (root.get("description") != null) {
                        post.setDescription(root.get("description").getTextValue());
                    }
                    break;
                case CHAT:
                    if (root.get("title") != null) {
                        post.setTitle(root.get("title").getTextValue());
                    }
                    if (root.get("body") != null) {
                        post.setTitle(root.get("body").getTextValue());
                    }
                    JsonNode dialogueNode = root.get("dialogue");
                    if (dialogueNode != null && dialogueNode.isArray()) {
                        ArrayNode dialogueArray = (ArrayNode) dialogueNode;
                        List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();
                        for (int i = 0; i < dialogueArray.size(); i++) {
                            JsonNode messageNode = dialogueArray.get(i);
                            ChatMessage message = new ChatMessage();
                            message.setLabel(messageNode.get("label").getTextValue());
                            message.setName(messageNode.get("name").getTextValue());
                            message.setPhrase(messageNode.get("phrase").getTextValue());
                            chatMessages.add(message);
                        }
                        
                        post.setDialogue(chatMessages);
                    }
                    break;
                case AUDIO:
                    if (root.get("caption") != null) {
                        post.setCaption(root.get("caption").getTextValue());
                    }
                    if (root.get("player") != null) {
                        post.setAudioPlayer(root.get("player").getTextValue());
                    }
                    if (root.get("plays") != null) {
                        post.setPlays(root.get("plays").getIntValue());
                    }
                    if (root.get("album_art") != null) {
                        post.setAlbumArt(root.get("album_art").getTextValue());
                    }
                    if (root.get("artist") != null) {
                        post.setArtist(root.get("artist").getTextValue());
                    }
                    if (root.get("album") != null) {
                        post.setAlbum(root.get("album").getTextValue());
                    }
                    if (root.get("track_name") != null) {
                        post.setTrackName(root.get("track_name").getTextValue());
                    }
                    if (root.get("track_number") != null) {
                        post.setTrackNumber(root.get("track_number").getIntValue());
                    }
                    if (root.get("year") != null) {
                        post.setYear(root.get("year").getIntValue());
                    }
                    break;
                case VIDEO:
                    if (root.get("caption") != null) {
                        post.setCaption(root.get("caption").getTextValue());
                    }
                    JsonNode playersNode = root.get("player");
                    if (playersNode != null && playersNode.isArray()) {
                        ArrayNode playerArray = (ArrayNode) playersNode;
                        List<VideoPostPlayer> players = new ArrayList<VideoPostPlayer>();
                        for (int i = 0; i < playerArray.size(); i++) {
                            JsonNode playerNode = playerArray.get(i);
                            VideoPostPlayer player = new VideoPostPlayer();
                            player.setEmbedCode(playerNode.get("embed_code").getTextValue());
                            player.setWidth(playerNode.get("width").getIntValue());
                            players.add(player);
                        }
                        post.setVideoPlayers(players);
                    }
                    break;
                case ANSWER:
                    if (root.get("asking_name") != null) {
                        post.setAskingName(root.get("asking_name").getTextValue());
                    }
                    if (root.get("asking_url") != null) {
                        post.setAskingUrl(root.get("asking_url").getTextValue());
                    }
                    if (root.get("question") != null) {
                        post.setQuestion(root.get("question").getTextValue());
                    }
                    if (root.get("answer") != null) {
                        post.setAnswer(root.get("answer").getTextValue());
                    }
                    break;
                default:
                    break;
            }

            return post;
        }
    }
}
