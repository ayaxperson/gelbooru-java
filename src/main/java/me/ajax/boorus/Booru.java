package me.ajax.boorus;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Booru {

    public final String baseURL;

    public Booru(final Boorus booru) {
        this(booru.baseUrl);
    }

    public Booru(final String baseURL) {
        this.baseURL = baseURL;
    }

    public Page getPage(final int page, final String... searchTags) throws IOException, URISyntaxException {
        return getPage(page, 1000, searchTags);
    }

    public Page getPage(final int page, final int limit, final String... searchTags) throws IOException, URISyntaxException {
        final String url = String.format("%s/index.php?page=dapi&s=post&q=index&pid=%d&limit=%d&tags=%s&json=1", baseURL, page, limit, String.join("+", searchTags));
        final String received = NetUtils.read(url);

        if (received.isBlank())
            return new Page(new Post[0]);

        final String[] entries = received.split("\\{|},?");
        final List<Post> posts = new ArrayList<>();

        for (final String entry : entries) {
            if (!entry.contains("\"") || !entry.contains(","))
                continue;

            final HashMap<String, String> parsedData = new HashMap<>();

            final String[] data = entry.split(",\"");

            for (final String dataEntry : data) {
                final String[] split = dataEntry.split("\":");
                final String key = split[0].startsWith("\"") ? split[0].substring(1) : split[0];
                final String value = split[1];
                parsedData.put(key, value);
            }

            String previewURL = null;
            String sampleURL = null;
            String fileURL = null;
            Long directory = null;
            String hash = null;
            Integer width = null;
            Integer height = null;
            Long id = null;
            String image = null;
            Long changed = null;
            String owner = null;
            Long parentID = null;
            String rating = null;
            Boolean sample = null;
            Integer sample_width = null;
            Integer sample_height = null;
            Integer score = null;
            String[] tags = null;
            String source = null;
            String status = null;
            Boolean hasNotes = null;
            Boolean hasComments = null;
            Boolean hasChildren = null;
            Integer commentCount = null;
            Integer preview_width = null;
            Integer preview_height = null;
            Long creatorId = null;
            Long createdAt = null;

            if (parsedData.containsKey("preview_url"))
                previewURL = StringUtils.removeTrailingQuotes(parsedData.get("preview_url"));

            if (parsedData.containsKey("sample_url"))
                sampleURL = StringUtils.removeTrailingQuotes(parsedData.get("sample_url"));

            if (parsedData.containsKey("file_url"))
                fileURL = StringUtils.removeTrailingQuotes(parsedData.get("file_url"));

            if (parsedData.containsKey("directory"))
                directory = ParserUtils.parseLongNullable(parsedData.get("directory"));

            if (parsedData.containsKey("hash"))
                hash = StringUtils.removeTrailingQuotes(parsedData.get("hash"));

            if (parsedData.containsKey("width"))
                width = ParserUtils.parseIntNullable(parsedData.get("width"));

            if (parsedData.containsKey("height"))
                height = ParserUtils.parseIntNullable(parsedData.get("height"));

            if (parsedData.containsKey("id"))
                id = ParserUtils.parseLongNullable(parsedData.get("id"));

            if (parsedData.containsKey("image"))
                image = StringUtils.removeTrailingQuotes(parsedData.get("image"));

            if (parsedData.containsKey("change"))
                changed = ParserUtils.parseLongNullable(parsedData.get("change"));

            if (parsedData.containsKey("owner"))
                owner = StringUtils.removeTrailingQuotes(parsedData.get("owner"));

            if (parsedData.containsKey("parent_id"))
                parentID = ParserUtils.parseLongNullable(parsedData.get("parent_id"));

            if (parsedData.containsKey("rating"))
                rating = StringUtils.removeTrailingQuotes(parsedData.get("rating"));

            if (parsedData.containsKey("sample"))
                sample = ParserUtils.parseBooleanNullable(parsedData.get("sample"));

            if (parsedData.containsKey("sample_width"))
                sample_width = ParserUtils.parseIntNullable(parsedData.get("sample_width"));

            if (parsedData.containsKey("sample_height"))
                sample_height = ParserUtils.parseIntNullable(parsedData.get("sample_height"));

            if (parsedData.containsKey("score"))
                score = ParserUtils.parseIntNullable(parsedData.get("score"));

            if (parsedData.containsKey("tags"))
                tags = StringUtils.removeTrailingQuotes(parsedData.get("tags")).split(" ");

            if (parsedData.containsKey("source"))
                source = StringUtils.removeTrailingQuotes(parsedData.get("source"));

            if (parsedData.containsKey("status"))
                status = StringUtils.removeTrailingQuotes(parsedData.get("status"));

            if (parsedData.containsKey("has_notes"))
                hasNotes = ParserUtils.parseBooleanNullable(parsedData.get("has_notes"));

            if (parsedData.containsKey("has_comments"))
                hasComments = ParserUtils.parseBooleanNullable(parsedData.get("has_comments"));

            if (parsedData.containsKey("has_children"))
                hasChildren = ParserUtils.parseBooleanNullable(parsedData.get("has_children"));

            if (parsedData.containsKey("comment_count"))
                commentCount = ParserUtils.parseIntNullable(parsedData.get("comment_count"));

            if (parsedData.containsKey("preview_width"))
                preview_width = ParserUtils.parseIntNullable(parsedData.get("preview_width"));

            if (parsedData.containsKey("preview_height"))
                preview_height = ParserUtils.parseIntNullable(parsedData.get("preview_height"));

            if (parsedData.containsKey("creator_id"))
                creatorId = ParserUtils.parseLongNullable(parsedData.get("creator_id"));

            if (parsedData.containsKey("created_at"))
                createdAt = ParserUtils.parseLongNullable(parsedData.get("created_at"));

            posts.add(new Post(
                    previewURL,
                    sampleURL,
                    fileURL,
                    directory,
                    hash,
                    width,
                    height,
                    id,
                    image,
                    changed,
                    owner,
                    parentID,
                    rating,
                    sample,
                    sample_width,
                    sample_height,
                    score,
                    tags,
                    source,
                    status,
                    hasNotes,
                    hasComments,
                    hasChildren,
                    commentCount,
                    preview_width,
                    preview_height,
                    creatorId,
                    createdAt
            ));
        }

        return new Page(posts.toArray(new Post[0]));
    }

}
