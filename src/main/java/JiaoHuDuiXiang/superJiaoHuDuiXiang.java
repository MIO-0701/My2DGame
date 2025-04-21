package JiaoHuDuiXiang;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class superJiaoHuDuiXiang {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;

    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = x - gp.getWanJia().worldX + gp.getWanJia().screenX;
        int screenY = y - gp.getWanJia().worldY + gp.getWanJia().screenY;
        if (x + gp.getXiangSu() > gp.getWanJia().worldX - gp.getWanJia().screenX && x - gp.getXiangSu() < gp.getWanJia().worldX + gp.getWanJia().screenX &&
                y + gp.getXiangSu() > gp.getWanJia().worldY - gp.getWanJia().screenY && y - gp.getXiangSu() < gp.getWanJia().worldY + gp.getWanJia().screenY) {
            g2.drawImage(image, screenX, screenY, gp.getXiangSu(), gp.getXiangSu(), null);//绘制地板
        }
    }
}
