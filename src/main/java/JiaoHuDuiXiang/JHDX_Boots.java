package JiaoHuDuiXiang;

import javax.imageio.ImageIO;
import java.io.IOException;

public class JHDX_Boots extends superJiaoHuDuiXiang {
    public JHDX_Boots() {
        name = "Doots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/JiaoHuDuiXiang/Doots.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
