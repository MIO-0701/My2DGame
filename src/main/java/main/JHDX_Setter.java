package main;

import JiaoHuDuiXiang.JHDX_Chest;
import JiaoHuDuiXiang.JHDX_Door;
import JiaoHuDuiXiang.JHDX_Key;

public class JHDX_Setter {
    GamePanel gp;

    public JHDX_Setter(GamePanel gp) {
        this.gp = gp;
    }

    public void setJiaoHuDuiXiang() {
        gp.jiaoHuDuiXiang[0] = new JHDX_Key();
        gp.jiaoHuDuiXiang[0].x = 23 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[0].y = 7 * gp.getXiangSu();

        gp.jiaoHuDuiXiang[1] = new JHDX_Key();
        gp.jiaoHuDuiXiang[1].x = 23 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[1].y = 40 * gp.getXiangSu();

        gp.jiaoHuDuiXiang[2] = new JHDX_Key();
        gp.jiaoHuDuiXiang[2].x = 37 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[2].y = 7 * gp.getXiangSu();

        gp.jiaoHuDuiXiang[3] = new JHDX_Door();
        gp.jiaoHuDuiXiang[3].x = 10 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[3].y = 11 * gp.getXiangSu();

        gp.jiaoHuDuiXiang[4] = new JHDX_Door();
        gp.jiaoHuDuiXiang[4].x = 8 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[4].y = 28 * gp.getXiangSu();

        gp.jiaoHuDuiXiang[5] = new JHDX_Door();
        gp.jiaoHuDuiXiang[5].x = 12 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[5].y = 24 * gp.getXiangSu();

        gp.jiaoHuDuiXiang[6] = new JHDX_Chest();
        gp.jiaoHuDuiXiang[6].x = 10 * gp.getXiangSu();
        gp.jiaoHuDuiXiang[6].y = 7 * gp.getXiangSu();


    }
}
