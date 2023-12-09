package BaseStruct.Test1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Prisoner> Prisoners = new LinkedList<>();
        for(int i = 0; i < 100; i++){
            int cur = (int)(Math.random() * 200);
            boolean find = false;
            for(Prisoner p : Prisoners){
                if(p.getOrder() == cur){
                    find = true;
                    break;
                }
            }
            if(!find){
                Prisoners.add(new Prisoner(cur));
            }
        }

        List<Prisoner> result = new ArrayList<>();
        for(int i = 1; i <= Prisoners.size(); i++){
            if(i % 2 == 0) result.add(Prisoners.get(i - 1));
        }
        for (Prisoner prisoner : result) {
            System.out.println(prisoner);
        }
    }
}
