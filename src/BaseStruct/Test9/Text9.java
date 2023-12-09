package BaseStruct.Test9;

import java.util.ArrayList;
import java.util.List;

public class Text9 {
    public static void main(String[] args) {
        List<LuckyMoney> luckys = new ArrayList<>();
        for(int i = 0; i < 160; i++){
            luckys.add(new LuckyMoney((int)(Math.random() * 30), false));
        }
        for(int i = 0; i < 40; i++){
            luckys.add(new LuckyMoney((int)(Math.random() * 30 + 70), false));
        }
        List<Worker> workers = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            workers.add(new Worker(String.valueOf(i)));
        }
        for (Worker worker : workers) {
            new GetLucky(luckys, worker).start();
        }
    }
}
