package combat;

import content.*;
import entity.*;
import util.*;

public class StagePicker {

    public Stage[] stages;

    public WeightedPool<Stage> pool;

    public Stage pick(int stage){
        Stage out;
        if(stage <= 3){
            out = (Stage)Entities.defaultStage;
        }
        out = (Stage)pool.getRandom();
        out.stage = stage;
        return out;
    }

    public static void load(){

    }
}
