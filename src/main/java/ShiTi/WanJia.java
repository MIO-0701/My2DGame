package ShiTi;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WanJia extends ShiTi {//玩家类
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;//玩家在屏幕上的位置(摄像机位置)
    public final int screenY;//玩家在屏幕上的位置

    public WanJia(GamePanel gp,KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.getKuan() / 2 - (gp.getXiangSu() / 2);
        screenY = gp.getGao() / 2 - (gp.getXiangSu() / 2);
        solidArea = new Rectangle();//创建矩形
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;


        setDefaultValues();
        getWanJiaImage();
    }
    public void setDefaultValues(){//设置玩家默认值

        worldX = gp.getXiangSu() * 23;
        worldY = gp.getXiangSu() * 21;
        speed = 4;
        fangXiang = "down";
    }

    public void getWanJiaImage() {//获取玩家图片
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/WanJiaYiDong/boy_right_2.png"));

        } catch (IOException e) {

        }
    }

    public void genXin() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                fangXiang = "up";

            } else if (keyH.downPressed) {
                fangXiang = "down";

            } else if (keyH.leftPressed) {
                fangXiang = "left";

            } else if (keyH.rightPressed) {
                fangXiang = "right";

            }
            // 检测碰撞
            collisionOn = false;
            gp.pengZhuangXiangJianCe.JianCha(this);
            // 如果碰撞了，就不动
            if (!collisionOn) {
                switch (fangXiang) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }

            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);// 设置画笔颜色为白色
//
//        g2.fillRect(x, y, gp.getXiangSu(), gp.getXiangSu());// 绘制矩形
        BufferedImage image = null;
        switch (fangXiang) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }


        g2.drawImage(image, screenX, screenY, gp.getXiangSu(), gp.getXiangSu(), null);
        g2.setColor(Color.RED); // 设置颜色为红色
        g2.drawRect(
                screenX + solidArea.x,
                screenY + solidArea.y,
                solidArea.width,
                solidArea.height
        );

    }
}
