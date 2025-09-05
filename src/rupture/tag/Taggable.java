package rupture.tag;

public class Taggable {
    public TagContainer tags;

    public boolean taggedAs(Tag tag){
        return tags.has(tag);
    }

    public boolean taggedAs(String tag){
        return taggedAs(new Tag(tag));
    }
}
