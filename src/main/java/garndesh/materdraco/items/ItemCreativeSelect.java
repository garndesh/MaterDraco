package garndesh.materdraco.items;

import com.sun.javafx.scene.text.HitInfo;
import garndesh.materdraco.MultiBlock.MultiBlockTemplate;
import garndesh.materdraco.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;

/**
 * Created by cte20616 on 29-5-2015.
 */
public class ItemCreativeSelect extends MaterDracoItem {

    public String firstPosition = "firstPosition";
    public String secondPosition = "secondPosition";

    public ItemCreativeSelect() {
        super(Names.itemCreativeSelect);
        GameRegistry.registerItem(this, getName());
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
        NBTTagCompound nbtTag = itemStack.getTagCompound();
        if(!player.isSneaking()) {
            MovingObjectPosition pos = player.rayTrace(3, 1f);
            if(pos != null && pos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                if (!nbtTag.hasKey(firstPosition)) {
                    nbtTag.setIntArray(firstPosition, new int[]{pos.func_178782_a().getX(), pos.func_178782_a().getY(), pos.func_178782_a().getZ()});
                } else if (!nbtTag.hasKey(secondPosition)) {
                    nbtTag.setIntArray(secondPosition, new int[]{pos.func_178782_a().getX(), pos.func_178782_a().getY(), pos.func_178782_a().getZ()});
                } else {
                    int[] first = nbtTag.getIntArray(firstPosition);
                    int[] second = nbtTag.getIntArray(secondPosition);
                    BlockPos knownBlock = new BlockPos(first[0], first[1], first[2]);
                    BlockPos knownBlock2 = new BlockPos(second[0], second[1], second[2]);
                    if(pos.func_178782_a() == knownBlock){
                        nbtTag.removeTag(firstPosition);
                    }
                    if(pos.func_178782_a() == knownBlock2){
                        nbtTag.removeTag(firstPosition);
                    }
                }
            }
        } else {
            if(nbtTag.hasKey(firstPosition) && nbtTag.hasKey(secondPosition)){
                createTemplate(itemStack, world);
            }
            if(nbtTag.hasKey(firstPosition))nbtTag.removeTag(firstPosition);
            if(nbtTag.hasKey(secondPosition))nbtTag.removeTag(secondPosition);

        }
        return itemStack;
    }

    private MultiBlockTemplate createTemplate(ItemStack itemStack, World world){
        NBTTagCompound nbtTag = itemStack.getTagCompound();
        int[] first = nbtTag.getIntArray(firstPosition);
        int[] second = nbtTag.getIntArray(secondPosition);
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
        template.setTemplate(templateMap);
        return template;
    }


}
