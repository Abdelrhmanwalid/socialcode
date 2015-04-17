package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Tag;
import socialcode.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

@Service("TagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag save(Tag tag) {
        tagRepository.save(tag);
        return tag;
    }

    public List<Tag> save(List<String> tagsStr){
        List<Tag> tags = new ArrayList<Tag>();
        for (String t : tagsStr){
            Tag tag = tagRepository.findByTag(t);
            if (tag == null){
                tag = new Tag();
                tag.setTag(t);
                tag = save(tag);
            }
            tags.add(tag);
            System.out.println(tag.getTag());
        }
        return tags;
    }
}
