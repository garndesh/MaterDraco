package garndesh.materdraco.proxy;

import garndesh.materdraco.blocks.BlockAltar;
import garndesh.materdraco.blocks.ModBlocks;
import garndesh.materdraco.items.ItemDracoScale;
import garndesh.materdraco.items.ModItems;
import garndesh.materdraco.lib.Reference;
import garndesh.materdraco.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class ClientProxy implements IProxy {

    public void registerRenderers() {
        LogHelper.info("Registering renderers");
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        //blocks
        renderItem.getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.altar), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + BlockAltar.getName(), "inventory"));


        //items
        renderItem.getItemModelMesher().register(ModItems.dragonScale, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID + ":" + ModItems.dragonScale.getName()), "inventory"));
        renderItem.getItemModelMesher().register(ModItems.creativeSelect, 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID + ":" + ModItems.creativeSelect.getName()), "inventory"));
    }
}
