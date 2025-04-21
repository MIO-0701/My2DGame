package main;

import ShiTi.ShiTi;

public class PengZhuangXiangJianCe {
    GamePanel gp;

    public PengZhuangXiangJianCe(GamePanel gp) {
        this.gp = gp;

    }

    public void JianCha(ShiTi st) {
        int wanJiaLifeWorldX = st.worldX + st.solidArea.x;
        int wanJiaRightWorldX = st.worldX + st.solidArea.x + st.solidArea.width;
        int wanJiaTopWorldY = st.worldY + st.solidArea.y;
        int wanJiaBottomWorldY = st.worldY + st.solidArea.y + st.solidArea.height;

        int wanjiaLifeKuan = wanJiaLifeWorldX / gp.getXiangSu();
        int wanjiaRightKuan = wanJiaRightWorldX / gp.getXiangSu();
        int wanjiaTopGao = wanJiaTopWorldY / gp.getXiangSu();
        int wanjiaBottomGao = wanJiaBottomWorldY / gp.getXiangSu();

        int tileNum1, tileNum2;

        switch (st.fangXiang) {
            case "up":
                wanjiaTopGao = (wanJiaTopWorldY - st.speed) / gp.getXiangSu();
                tileNum1 = gp.huanJing.getMapShuJu()[wanjiaTopGao][wanjiaLifeKuan];
                tileNum2 = gp.huanJing.getMapShuJu()[wanjiaTopGao][wanjiaRightKuan];
                if (gp.huanJing.getBeiJing()[tileNum1].collision || gp.huanJing.getBeiJing()[tileNum2].collision) {
                    st.collisionOn = true;
                }
                break;
            case "down":
                wanjiaBottomGao = (wanJiaBottomWorldY + st.speed) / gp.getXiangSu();
                tileNum1 = gp.huanJing.getMapShuJu()[wanjiaBottomGao][wanjiaLifeKuan];
                tileNum2 = gp.huanJing.getMapShuJu()[wanjiaBottomGao][wanjiaRightKuan];
                if (gp.huanJing.getBeiJing()[tileNum1].collision || gp.huanJing.getBeiJing()[tileNum2].collision) {
                    st.collisionOn = true;
                }
                break;
            case "left":
                wanjiaLifeKuan = (wanJiaLifeWorldX - st.speed) / gp.getXiangSu();
                tileNum1 = gp.huanJing.getMapShuJu()[wanjiaTopGao][wanjiaLifeKuan];
                tileNum2 = gp.huanJing.getMapShuJu()[wanjiaBottomGao][wanjiaLifeKuan];
                if (gp.huanJing.getBeiJing()[tileNum1].collision || gp.huanJing.getBeiJing()[tileNum2].collision) {
                    st.collisionOn = true;
                }
                break;
            case "right":
                wanjiaRightKuan = (wanJiaRightWorldX + st.speed) / gp.getXiangSu();
                tileNum1 = gp.huanJing.getMapShuJu()[wanjiaTopGao][wanjiaRightKuan];
                tileNum2 = gp.huanJing.getMapShuJu()[wanjiaBottomGao][wanjiaRightKuan];
                if (gp.huanJing.getBeiJing()[tileNum1].collision || gp.huanJing.getBeiJing()[tileNum2].collision) {
                    st.collisionOn = true;
                }
                break;
        }
    }

}
