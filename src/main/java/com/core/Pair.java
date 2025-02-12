package main.java.com.core;

import java.util.ArrayList;
import java.util.List;

public class Pair<X, Y>{
    public X one;
    public Y two;
    public Pair(X one, Y two){
        this.one = one;
        this.two = two;
    }
    public List<X> one(List<Pair<X,Y>> l){
        List<X> out = new ArrayList<>();
        for(Pair<X,Y> p : l){
            out.add(p.one);
        }
        return out;
    }
}
