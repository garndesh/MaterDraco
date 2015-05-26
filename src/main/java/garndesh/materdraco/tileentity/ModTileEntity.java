package garndesh.materdraco.tileentity;

import garndesh.materdraco.lib.Names;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class ModTileEntity {

    public static void init(){
        GameRegistry.registerTileEntity(TileEntityAltar.class, Names.tileAltar);
    }
}
