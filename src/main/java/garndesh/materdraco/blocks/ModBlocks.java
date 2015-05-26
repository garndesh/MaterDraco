package garndesh.materdraco.blocks;

import garndesh.materdraco.lib.Names;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class ModBlocks {

    public static BlockAltar altar;

    public static void init(){
        altar = new BlockAltar();
    }
}
