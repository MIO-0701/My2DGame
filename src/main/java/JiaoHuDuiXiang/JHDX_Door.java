package JiaoHuDuiXiang;

import javax.imageio.ImageIO;
import java.io.IOException;

public class JHDX_Door extends superJiaoHuDuiXiang {
    public JHDX_Door() {
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/JiaoHuDuiXiang/door.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
