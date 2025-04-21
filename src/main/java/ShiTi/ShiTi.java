package ShiTi;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ShiTi {//实体类
    public int worldX, worldY;//实体坐标
    public int speed;//实体速度

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;//实体图片
    public String fangXiang;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}
