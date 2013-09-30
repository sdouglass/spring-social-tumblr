package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.social.tumblr.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = PostMixin.PostDeserializer.class)
class PostMixin {

    static class PostDeserializer extends JsonDeserializer<Post> {

        @Override
        public Post deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode root = jp.readValueAsTree();

            Post post = new Post();

            post.setId(root.get("id").longValue());
            post.setBlogName(root.get("blog_name").textValue());
            post.setType(PostType.getByType(root.get("type").textValue()));
            post.setPostUrl(root.get("post_url").textValue());
            post.setTimestamp(root.get("timestamp").longValue());
            post.setGmtDateString(root.get("date").textValue());
            post.setFormat(root.get("format").textValue());
            post.setReblogKey(root.get("reblog_key").textValue());
            List<String> tags = new ArrayList<String>();
            JsonNode tagsNode = root.get("tags");
            if (tagsNode != null && tagsNode.isArray()) {
                ArrayNode tagsArray = (ArrayNode) tagsNode;
                for (int i = 0; i < tagsArray.size(); i++) {
                    tags.add(tagsArray.get(i).textValue());
                }
            }
            post.setTags(tags);
            if (root.get("note_count") != null) {
                post.setNoteCount(root.get("note_count").intValue());
            }
            post.setCreatedViaBookmarklet(root.get("bookmarklet") != null);
            post.setCreatedViaMobile(root.get("mobile") != null);
            if (root.get("source_url") != null) {
                post.setSourceUrl(root.get("source_url").textValue());
            }
            if (root.get("source_title") != null) {
                post.setSourceTitle(root.get("source_title").textValue());
            }

            switch (post.getType()) {
                case TEXT:
                    if (root.get("title") != null) {
                        post.setTitle(root.get("title").textValue());
                    }
                    post.setBody(root.get("body").textValue());
                    break;
                case PHOTO:
                    if (root.get("caption") != null) {
                        post.setCaption(root.get("caption").textValue());
                    }
                    if (root.get("width") != null) {
                        post.setWidth(root.get("width").intValue());
                    }
                    if (root.get("height") != null) {
                        post.setHeight(root.get("height").intValue());
                    }
                    List<Photo> photos = new ArrayList<Photo>();
                    JsonNode photosNode = root.get("photos");
                    if (photosNode != null && photosNode.isArray()) {
                        ArrayNode photosArray = (ArrayNode) photosNode;
                        for (int i = 0; i < photosArray.size(); i++) {
                            Photo photo = new Photo();
                            JsonNode photoNode = photosArray.get(i);
                            photo.setCaption(photoNode.get("caption").textValue());
                            ArrayNode sizesArray = (ArrayNode) photoNode.get("alt_sizes");
                            List<PhotoSize> sizes = new ArrayList<PhotoSize>();
                            for (int j = 0; j < sizesArray.size(); j++) {
                                PhotoSize size = new PhotoSize();
                                JsonNode sizeNode = sizesArray.get(j);
                                size.setUrl(sizeNode.get("url").textValue());
                                size.setWidth(sizeNode.get("width").intValue());
                                size.setHeight(sizeNode.get("height").intValue());
                                sizes.add(size);
                            }
                            photo.setSizes(sizes);
                            photos.add(photo);
                        }
                        post.setPhotos(photos);
                    }
                    break;
                case QUOTE:
                    post.setText(root.get("text").textValue());
                    if (root.get("source") != null) {
                        post.setSource(root.get("source").textValue());
                    }
                    break;
                case LINK:
                    post.setUrl(root.get("url").textValue());
                    if (root.get("title") != null) {
                        post.setTitle(root.get("title").textValue());
                    }
                    if (root.get("description") != null) {
                        post.setDescription(root.get("description").textValue());
                    }
                    break;
                case CHAT:
                    if (root.get("title") != null) {
                        post.setTitle(root.get("title").textValue());
                    }
                    if (root.get("body") != null) {
                        post.setTitle(root.get("body").textValue());
                    }
                    JsonNode dialogueNode = root.get("dialogue");
                    if (dialogueNode != null && dialogueNode.isArray()) {
                        ArrayNode dialogueArray = (ArrayNode) dialogueNode;
                        List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();
                        for (int i = 0; i < dialogueArray.size(); i++) {
                            JsonNode messageNode = dialogueArray.get(i);
                            ChatMessage message = new ChatMessage();
                            message.setLabel(messageNode.get("label").textValue());
                            message.setName(messageNode.get("name").textValue());
                            message.setPhrase(messageNode.get("phrase").textValue());
                            chatMessages.add(message);
                        }
                        
                        post.setDialogue(chatMessages);
                    }
                    break;
                case AUDIO:
                    if (root.get("caption") != null) {
                        post.setCaption(root.get("caption").textValue());
                    }
                    if (root.get("player") != null) {
                        post.setAudioPlayer(root.get("player").textValue());
                    }
                    if (root.get("plays") != null) {
                        post.setPlays(root.get("plays").intValue());
                    }
                    if (root.get("album_art") != null) {
                        post.setAlbumArt(root.get("album_art").textValue());
                    }
                    if (root.get("artist") != null) {
                        post.setArtist(root.get("artist").textValue());
                    }
                    if (root.get("album") != null) {
                        post.setAlbum(root.get("album").textValue());
                    }
                    if (root.get("track_name") != null) {
                        post.setTrackName(root.get("track_name").textValue());
                    }
                    if (root.get("track_number") != null) {
                        post.setTrackNumber(root.get("track_number").intValue());
                    }
                    if (root.get("year") != null) {
                        post.setYear(root.get("year").intValue());
                    }
                    break;
                case VIDEO:
                    if (root.get("caption") != null) {
                        post.setCaption(root.get("caption").textValue());
                    }
                    JsonNode playersNode = root.get("player");
                    if (playersNode != null && playersNode.isArray()) {
                        ArrayNode playerArray = (ArrayNode) playersNode;
                        List<VideoPostPlayer> players = new ArrayList<VideoPostPlayer>();
                        for (int i = 0; i < playerArray.size(); i++) {
                            JsonNode playerNode = playerArray.get(i);
                            VideoPostPlayer player = new VideoPostPlayer();
                            player.setEmbedCode(playerNode.get("embed_code").textValue());
                            player.setWidth(playerNode.get("width").intValue());
                            players.add(player);
                        }
                        post.setVideoPlayers(players);
                    }
                    break;
                case ANSWER:
                    if (root.get("asking_name") != null) {
                        post.setAskingName(root.get("asking_name").textValue());
                    }
                    if (root.get("asking_url") != null) {
                        post.setAskingUrl(root.get("asking_url").textValue());
                    }
                    if (root.get("question") != null) {
                        post.setQuestion(root.get("question").textValue());
                    }
                    if (root.get("answer") != null) {
                        post.setAnswer(root.get("answer").textValue());
                    }
                    break;
                default:
                    break;
            }

            return post;
        }
    }
}
