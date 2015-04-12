package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Tag;
import socialcode.repository.TagRepository;

@Service("TagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag save(Tag tag) {
        tagRepository.save(tag);
        return tag;
    }
}
