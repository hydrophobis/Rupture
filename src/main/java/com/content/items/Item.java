package com.content.items;
import com.core.AnsiColors;
import com.content.entities.Entity;

public abstract class Item {
    public String name;
    public String lore;

    public Item(String name, String lore){
        this.name = name;
        this.lore = lore;
    }

    public String toString(){
        return "[" + AnsiColors.GREEN + this.name + AnsiColors.RESET + " | " + AnsiColors.CYAN + this.lore + AnsiColors.RESET + "]";
    }

    public abstract void consume(Entity entity);
}
