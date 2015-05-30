package garndesh.materdraco.items;

import garndesh.materdraco.MultiBlock.MultiBlockTemplate;
import garndesh.materdraco.lib.Names;
import garndesh.materdraco.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;

/**
 * Created by cte20616 on 29-5-2015.
 */
public class ItemCreativeSelect extends MaterDracoItem {

    private static String firstPositionTAG = "firstPosition";
    private static String secondPositionTAG = "secondPosition";

    public ItemCreativeSelect() {
        super(Names.itemCreativeSelect);
        GameRegistry.registerItem(this, getName());
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
        if(!world.isRemote) {
            NBTTagCompound nbtTag = itemStack.getTagCompound();
            if (nbtTag == null) nbtTag = new NBTTagCompound();
            if (!player.isSneaking()) {
                MovingObjectPosition pos = player.rayTrace(3, 1f);
                if (pos != null && pos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    if (!nbtTag.hasKey(firstPositionTAG)) {
                        nbtTag.setIntArray(firstPositionTAG, new int[]{pos.func_178782_a().getX(), pos.func_178782_a().getY(), pos.func_178782_a().getZ()});
                        LogHelper.info("Adding first position: " + pos.toString());
                    } else if (!nbtTag.hasKey(secondPositionTAG)) {
                        nbtTag.setIntArray(secondPositionTAG, new int[]{pos.func_178782_a().getX(), pos.func_178782_a().getY(), pos.func_178782_a().getZ()});
                        LogHelper.info("Adding second position: " + pos.toString());
                    } else {
                        int[] first = nbtTag.getIntArray(firstPositionTAG);
                        int[] second = nbtTag.getIntArray(secondPositionTAG);
                        BlockPos knownBlock = new BlockPos(first[0], first[1], first[2]);
                        BlockPos knownBlock2 = new BlockPos(second[0], second[1], second[2]);
                        if (pos.func_178782_a() == knownBlock) {
                            nbtTag.removeTag(firstPositionTAG);
                        }
                        if (pos.func_178782_a() == knownBlock2) {
                            nbtTag.removeTag(firstPositionTAG);
                        }
                    }
                }
            } else {
                if (nbtTag.hasKey(firstPositionTAG) && nbtTag.hasKey(secondPositionTAG)) {
                    LogHelper.info("Creating template");
                    int[] first = nbtTag.getIntArray(firstPositionTAG);
                    int[] second = nbtTag.getIntArray(secondPositionTAG);
                    HashMap<BlockPos, Block> templateMap = new HashMap<>();
                    for(int x = Math.min(first[0], second[0]); x<= Math.max(first[0], second[0]); x++) {
                        for(int y = Math.min(first[1], second[1]); y<= Math.max(first[1], second[1]); y++) {
                            for(int z = Math.min(first[2], second[2]); z<= Math.max(first[2], second[2]); z++) {
                                BlockPos blockPos = new BlockPos(x, y, z);
                                templateMap.put(blockPos, world.getChunkFromBlockCoords(blockPos).getBlock(blockPos));
                            }
                        }
                    }
                    MultiBlockTemplate template = new MultiBlockTemplate();
                    LogHelper.info("adding blocks to template");
                    int altarCount = template.setTemplate(templateMap);
                    if(altarCount!=1){
                        player.addChatComponentMessage(new ChatComponentText("Incorrect number of altars found: " + altarCount + ". This should be exactly 1"));
                    }
                }
                if (nbtTag.hasKey(firstPositionTAG)) nbtTag.removeTag(firstPositionTAG);
                if (nbtTag.hasKey(secondPositionTAG)) nbtTag.removeTag(secondPositionTAG);

            }
            itemStack.setTagCompound(nbtTag);
        }
        return itemStack;
    }

}
