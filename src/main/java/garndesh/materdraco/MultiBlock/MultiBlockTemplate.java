package garndesh.materdraco.MultiBlock;

import com.google.common.collect.HashMultimap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import garndesh.materdraco.blocks.ModBlocks;
import garndesh.materdraco.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class MultiBlockTemplate {

    private static String templateFolder = "MaterDracoTemplates" + File.pathSeparator;
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
            if(template.get(key) != Blocks.air)
                this.template.put(key.subtract(pos), template.get(key) );
        }

        saveToJson("");

        return count;
    }

    public void saveToJson(String filename)
    {

        //File templateFile = MinecraftServer.getServer().getFile(templateFolder + filename + LocalDateTime.now().toString() + "template");
        JsonArray total = new JsonArray();
        for(BlockPos key : this.template.keySet())
        {
            JsonObject part = new JsonObject();
            part.addProperty("x", key.getX());
            part.addProperty("y", key.getY());
            part.addProperty("z", key.getZ());
            part.addProperty("block", this.template.get(key).getUnlocalizedName());
            total.add(part);
        }

        LogHelper.info(total.toString());

    }

    public static MultiBlockTemplate loadFromJson(JsonObject template)
    {
        return new MultiBlockTemplate();
    }


}
