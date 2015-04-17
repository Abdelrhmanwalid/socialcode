package socialcode.service;

import socialcode.model.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag tag);
    List<Tag> save(List<String> tagsStr);
}
