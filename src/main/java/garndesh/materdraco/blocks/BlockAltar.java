package garndesh.materdraco.blocks;

import garndesh.materdraco.creative.CreativeTab;
import garndesh.materdraco.lib.Names;
import garndesh.materdraco.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class BlockAltar extends Block {

    protected BlockAltar() {
        super(Material.rock);
        setUnlocalizedName(Reference.MOD_ID + "_" + BlockAltar.getName());
        setCreativeTab(CreativeTab.tabMaterDraco);
        GameRegistry.registerBlock(this, BlockAltar.getName());
    }

    public static String getName(){
        return Names.blockAltarName;
    }
}
