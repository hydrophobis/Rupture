import combat.*;
import content.*;
import entity.*;

public class Main {

    public static StagePicker stagePicker = new StagePicker();

    public static void main(String[] args) {
        ContentManager.load();

        Player player = (Player)Entities.player;

        int stageNumber = 1;

        while(true){
            Stage stage = stagePicker.pick(stageNumber);

            for(int i = 0; i < player.getValue("turns"))

            stageNumber += 1;
        }
    }
}
