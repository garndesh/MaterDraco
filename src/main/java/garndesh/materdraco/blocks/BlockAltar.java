package garndesh.materdraco.blocks;

import garndesh.materdraco.creative.CreativeTab;
import garndesh.materdraco.lib.Names;
import garndesh.materdraco.lib.Reference;
import garndesh.materdraco.tileentity.TileEntityAltar;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class BlockAltar extends Block implements ITileEntityProvider {

    protected BlockAltar() {
        super(Material.rock);
        setUnlocalizedName(Reference.MOD_ID + "_" + BlockAltar.getName());
        setCreativeTab(CreativeTab.tabMaterDraco);
        GameRegistry.registerBlock(this, BlockAltar.getName());
    }

    public static String getName(){
        return Names.blockAltar;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAltar();
    }
}
