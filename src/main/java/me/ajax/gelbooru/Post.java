package me.ajax.gelbooru;

public record Post(
        String previewURL,
        String sampleURL,
        String fileURL,
        Long directory,
        String hash,
        Integer width,
        Integer height,
        Long id,
        String image,
        Long changed,
        String owner,
        Long parentID,
        String rating,
        Boolean sample,
        Integer sample_width,
        Integer sample_height,
        Integer score,
        String[] tags,
        String source,
        String status,
        Boolean hasNotes,
        Boolean hasComments,
        Boolean hasChildren,
        Integer commentCount,
        Integer preview_width,
        Integer preview_height,
        Long creatorId,
        Long createdAt
) { }
