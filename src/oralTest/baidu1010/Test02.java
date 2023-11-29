package oralTest.baidu1010;

import oralTest.InputUtils;

public class Test02 {

    private int getAuthInt(String user, String auth) {
        boolean u = false;
        boolean g = false;
        boolean o = false;
        boolean a = false;
        for(int i = 0; i < user.length(); i++){
            if(user.charAt(i) == 'a') a = true;
            if(user.charAt(i) == 'g') g = true;
            if(user.charAt(i) == 'o') o = true;
            if(user.charAt(i) == 'a') a = true;
        }
        int authInt = shortAuthToInt(auth);
        int ans = 0;
        if(o){
            ans |= authInt;
            ans |= authInt >> 3;
            ans |= authInt >> 6;
            return ans;
        }
        if(a){
            ans |= authInt >> 6;
        }
        if(g){
            ans |= authInt >> 3;
        }
        if(o){
            ans |= authInt;
        }
        return ans;
    }
    public int authToInt(String auth){
        int res = 0;
        if(auth.charAt(0) == 'r') res += 1 >> 9;
        if(auth.charAt(1) == 'w') res += 1 >> 8;
        if(auth.charAt(2) == 'x') res += 1 >> 7;
        if(auth.charAt(3) == 'r') res += 1 >> 6;
        if(auth.charAt(4) == 'w') res += 1 >> 5;
        if(auth.charAt(5) == 'x') res += 1 >> 4;
        if(auth.charAt(6) == 'r') res += 1 >> 3;
        if(auth.charAt(7) == 'w') res += 1 >> 2;
        if(auth.charAt(8) == 'x') res += 1 >> 1;
        return res;
    }

    public int shortAuthToInt(String auth){
        int res = 0;
        if(auth.charAt(0) == 'r') res |= 4;
        if(auth.charAt(1) == 'w') res |= 2;
        if(auth.charAt(2) == 'x') res |= 1;
        return res;
    }
    public char getOps(String command){
        int ls = command.length();
        for(int i = 0; i < ls; i ++){
            if(command.charAt(i) == '+') return '+';
            if(command.charAt(i) == '-') return '-';
            if(command.charAt(i) == '=') return '=';
        }
        return '=';
    }
    public String solve(){
        String ori = InputUtils.getLine();
        int k = Integer.parseInt(InputUtils.getLine());
        int oriAuth = authToInt(ori);
        while(k-- > 0){
            String command = InputUtils.getStringArrayBySplit()[1];
            char ops = getOps(command);
            String[] strings = command.split(String.valueOf(ops));
            String user = strings[0];
            String auth = strings[1];
            int authInt = getAuthInt(user, auth);
            if(ops == '+') oriAuth |= authInt;
        }
        return "";
    }

}
