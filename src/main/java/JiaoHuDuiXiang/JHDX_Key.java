package JiaoHuDuiXiang;

import javax.imageio.ImageIO;
import java.io.IOException;

public class JHDX_Key extends superJiaoHuDuiXiang {
    public JHDX_Key() {
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/JiaoHuDuiXiang/key.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
