package JiaoHuDuiXiang;

import javax.imageio.ImageIO;
import java.io.IOException;

public class JHDX_Chest extends superJiaoHuDuiXiang {
    public JHDX_Chest() {
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/JiaoHuDuiXiang/Chest.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
