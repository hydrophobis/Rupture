package rupture.tag;

import java.util.*;

public class TagContainer {
    List<Tag> tags = new ArrayList<>();

    public void add(Tag tag){
        tags.add(tag);
    }

    public void add(String tag){
        tags.add(new Tag(tag));
    }

    public void remove(Tag tag){
        tags.remove(tag);
    }

    public boolean has(String tag){
        return find(tag) != -1;
    }

    public boolean has(Tag tag){
        return find(tag) != -1;
    }

    int find(String tag){
        return tags.indexOf(new Tag(tag));
    }

    int find(Tag tag){
        return tags.indexOf(tag);
    }
}
