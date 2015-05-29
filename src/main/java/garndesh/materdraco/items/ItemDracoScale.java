package garndesh.materdraco.items;

import garndesh.materdraco.creative.CreativeTab;
import garndesh.materdraco.lib.Names;
import garndesh.materdraco.lib.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class ItemDracoScale extends MaterDracoItem {

    public ItemDracoScale(){
        super(Names.itemDragonScale);
        GameRegistry.registerItem(this, getName());
    }
}
