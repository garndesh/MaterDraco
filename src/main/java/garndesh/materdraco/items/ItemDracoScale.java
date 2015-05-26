package garndesh.materdraco.items;

import garndesh.materdraco.creative.CreativeTab;
import garndesh.materdraco.lib.Names;
import garndesh.materdraco.lib.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class ItemDracoScale extends Item {

    public ItemDracoScale(){
        setUnlocalizedName(Reference.MOD_ID + "_" + ItemDracoScale.getName());
        setCreativeTab(CreativeTab.tabMaterDraco);
        GameRegistry.registerItem(this, ItemDracoScale.getName());
    }

    public static String getName(){
        return Names.itemDragonScale;
    }
}
