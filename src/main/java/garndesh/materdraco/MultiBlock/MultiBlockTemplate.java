package garndesh.materdraco.MultiBlock;

import com.google.common.collect.HashMultimap;
import com.google.gson.JsonObject;
import garndesh.materdraco.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class MultiBlockTemplate {

    private HashMap<BlockPos, Block> template = new HashMap<>();

    /**
     * @param template  a Hashmap of all the blocks and their position
     * @return the amount of Alatar blocks found. Should always be 1
     */
    public int setTemplate(HashMap<BlockPos, Block> template)
    {
        int count = 0;
        BlockPos pos = new BlockPos(0, 0, 0);
        for(BlockPos key : template.keySet())
        {
            if(template.get(key) == ModBlocks.altar) {
                pos = key;
                count++;
            }
        }

        if(count!=1) return count;

        for(BlockPos key : template.keySet())
        {
           this.template.put(key.subtract(pos), template.get(key) );
        }
        return count;
    }

    public void saveToJson(String filename)
    {

    }

    public static MultiBlockTemplate loadFromJson(JsonObject template)
    {
        return new MultiBlockTemplate();
    }


}
