package com.core.random;

import java.util.List;

public class P59Shift extends java.util.Random {
    long seed;
    long state;
    long bound;
    int i = 0;
    long modifier = 1975698273459823749l;
    public long next(){
        if (state == 0) state = seed | 1;

        state ^= (state << 34);
        state ^= (state >>> 21);
        state ^= (state << 4);
        state = Math.abs(state) % bound;
        return state;
    }

    public long nextAbs() {
        if (state == 0)
            state = seed | 1;

        state ^= (state << 34);
        state ^= (state >>> 21);
        state ^= (state << 4);
        state = Math.abs(state) % bound;
        return Math.abs(state);
    }

    public int nextInt(){
        return (int)next();
    }

    public int nextIntAbs(){
        return Math.abs(nextInt());
    }

    public double nextDouble(double a, double b){
        next();
        double d = (double) state / (bound - 1);
        return Math.abs(a + d * (b - a));
    }

    public int[] intArray(int s, int a, int b){
        int[] outarr = new int[s];
        for(i = 0; i < s; i++){
            outarr[i] = (nextInt() % (b - a)) + a;
        }
        return outarr;
    }

    public boolean nextBoolean(){
        return nextInt() < 0;
    }

    public String nextChoice(String[] strings){
        return strings[(nextIntAbs()) % strings.length];
    }

    public <T> T nextChoice(List<T> l) {
        return (T) l.toArray()[(nextIntAbs()) % l.toArray().length];
    }

    public String subset(String[] strings, int length, String seperator){
        String os = "";
        for(i = 0; i < length; i++){
            os += seperator + strings[(nextIntAbs()) % strings.length];
        }
        return os;
    }

    public char nextLetter(){
        boolean a = nextBoolean();
        if(a){
            return (char)((char)(nextIntAbs() % (90 - 65)) + 65);
        }
        return (char)((char)((char)nextIntAbs() % (122 - 97)) + 97);
    }

    public int nextSquare(int upperBound){
        int a = nextIntAbs() % (int)Math.sqrt((double)upperBound + 1);
        return a * a;
    }

    public P59Shift(long seed, long bound){
        this.seed = seed;
        this.state = seed;
        this.bound = bound;
    }
    public P59Shift(long seed){
        this(seed, Long.MAX_VALUE - 1);
    }
    public P59Shift(){
        this(System.nanoTime());
    }
}
