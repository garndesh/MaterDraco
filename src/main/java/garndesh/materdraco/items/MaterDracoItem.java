package garndesh.materdraco.items;

import garndesh.materdraco.creative.CreativeTab;
import garndesh.materdraco.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 29-5-2015.
 */
public class MaterDracoItem  extends Item {

    private String name;

    public MaterDracoItem(String name){
        setCreativeTab(CreativeTab.tabMaterDraco);
        setUnlocalizedName(Reference.MOD_ID + "_" + name);
        this.name = name;
    }

    public String getName(){return name;}

}
