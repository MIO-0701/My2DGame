package beiJing;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HuanJing {
    GamePanel gp;
    BeiJing[] beiJing;
    int[][] mapShuJu;

    public HuanJing(GamePanel gp) {
        this.gp = gp;
        beiJing = new BeiJing[10];
        mapShuJu = new int[gp.getMaxWorldGao()][gp.getMaxWorldKuan()];
//        chuShiHuaMap("/maps/map.txt");
        chuShiHuaMap("/maps/world01.txt");

        getHuanJingImage();

    }

    public void chuShiHuaMap(String mapFile) {
        try (InputStream is = getClass().getResourceAsStream(mapFile)) {
            Scanner scanner = new Scanner(is);
            int j = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] strings = s.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    mapShuJu[j][i] = Integer.parseInt(strings[i]);
                }
                j++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getHuanJingImage() {//获取砖块图片
        try {
            beiJing[0] = new BeiJing();
            beiJing[0].image = ImageIO.read(getClass().getResourceAsStream("/ChangJing/grass.png"));//0

            beiJing[1] = new BeiJing();
            beiJing[1].image = ImageIO.read(getClass().getResourceAsStream("/ChangJing/wall.png"));//1
            beiJing[1].collision = true;

            beiJing[2] = new BeiJing();
            beiJing[2].image = ImageIO.read(getClass().getResourceAsStream("/ChangJing/water.png"));//2
            beiJing[2].collision = true;

            beiJing[3] = new BeiJing();
            beiJing[3].image = ImageIO.read(getClass().getResourceAsStream("/ChangJing/earth.png"));//3

            beiJing[4] = new BeiJing();
            beiJing[4].image = ImageIO.read(getClass().getResourceAsStream("/ChangJing/tree.png"));//4
            beiJing[4].collision = true;

            beiJing[5] = new BeiJing();
            beiJing[5].image = ImageIO.read(getClass().getResourceAsStream("/ChangJing/sand.png"));//5
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {//绘制砖块
        int worldKuan = 0;
        int worldGao = 0;

        while (worldKuan < gp.getMaxWorldKuan() && worldGao < gp.getMaxWorldGao()) {
            int worldX = worldKuan * gp.getXiangSu();
            int worldY = worldGao * gp.getXiangSu();
            int screenX = worldX - gp.getWanJia().worldX + gp.getWanJia().screenX;
            int screenY = worldY - gp.getWanJia().worldY + gp.getWanJia().screenY;
            if (worldX + gp.getXiangSu() > gp.getWanJia().worldX - gp.getWanJia().screenX && worldX - gp.getXiangSu() < gp.getWanJia().worldX + gp.getWanJia().screenX &&
                    worldY + gp.getXiangSu() > gp.getWanJia().worldY - gp.getWanJia().screenY && worldY - gp.getXiangSu() < gp.getWanJia().worldY + gp.getWanJia().screenY) {
                g2.drawImage(beiJing[mapShuJu[worldGao][worldKuan]].image, screenX, screenY, gp.getXiangSu(), gp.getXiangSu(), null);//绘制地板
            }
            worldKuan++;

            if (worldKuan == gp.getMaxWorldKuan()) {
                worldKuan = 0;
                worldGao++;


            }


        }

    }

    public GamePanel getGp() {
        return gp;
    }

    public BeiJing[] getBeiJing() {
        return beiJing;
    }

    public int[][] getMapShuJu() {
        return mapShuJu;
    }
}
