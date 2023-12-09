package BaseStruct.Test9;

import java.util.List;

public class GetLucky extends Thread{
    List<LuckyMoney> luckys;
    Worker worker;

    public GetLucky(List<LuckyMoney> luckys, Worker worker){
        this.luckys = luckys;
        this.worker = worker;
    }

    @Override
    public void run(){
        while(true){
            synchronized (luckys){
                int r = (int)(Math.random() * 200);
                if(!luckys.get(r).isBeen_get()){
                    worker.setMoney(worker.getMoney() + luckys.get(r).getMoney());
                    luckys.get(r).setBeen_get(true);
                    System.out.printf("%s ÇÀµ½ÁË %d ºÅºì°ü %n", worker.getName(), r);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }
}
