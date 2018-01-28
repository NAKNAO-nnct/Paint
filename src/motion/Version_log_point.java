package motion;

import java.util.ArrayList;

public class Version_log_point {
    private ArrayList<Integer> x_log = new ArrayList<>();
    private ArrayList<Integer> y_log = new ArrayList<>();

    public Version_log_point(){
    }

    // Constructor
    public void version_log_point(int x, int y){
        this.x_log.add(x);
        this.y_log.add(y);
        System.out.println(x);
        System.out.println(y);
    }

    // a前分のX座標log取得
    public int[] getX(int a){
        int[] get_x_log = new int[a];
        for(int i=0; i<a; i++) {
            get_x_log[i] = x_log.get(x_log.size() - (i+1));
        }
        return get_x_log;
    }

    // a前分のY座標log取得
    public int[] getY(int a){
        int[] get_y_log = new int[a];
        for(int i=0; i<a; i++) {
            get_y_log[i] = y_log.get(y_log.size() - (i+1) );
        }
        return get_y_log;
    }
}
