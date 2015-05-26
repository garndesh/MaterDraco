package garndesh.materdraco.creative;

import garndesh.materdraco.items.ModItems;
import garndesh.materdraco.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class CreativeTab {

    public static CreativeTabs tabMaterDraco = new CreativeTabs(Reference.MOD_ID){
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return ModItems.dragonScale;
        }
    };


}
