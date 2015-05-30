package garndesh.materdraco.MultiBlock;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import garndesh.materdraco.blocks.ModBlocks;
import garndesh.materdraco.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class MultiBlockTemplate {

    private static String templateFolder = "MaterDracoTemplates" + File.separator;
    private HashMap<BlockPos, Block> template = new HashMap<BlockPos, Block>();
    private List<Block> blocks = new ArrayList<>();
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

        if(count!=1){
            LogHelper.info("Incorrect number of altars found total is: " + count);
            return count;
        }

        for(BlockPos key : template.keySet())
        {
            if(template.get(key) != Blocks.air) {
                this.template.put(key.subtract(pos), template.get(key));
                if(!this.blocks.contains(template.get(key))){
                    this.blocks.add(template.get(key));
                }
            }
        }

        saveToJson("test");

        return count;
    }

    public void saveToJson(String filename)
    {

        LogHelper.info("Saving to file");
        JsonObject total = new JsonObject();

        JsonArray blocksJson = new JsonArray();
        for(Block b : blocks){
            JsonObject part = new JsonObject();
            part.addProperty("block", b.getUnlocalizedName());
            blocksJson.add(part);
        }
        total.add("blocks", blocksJson);

        JsonArray layout = new JsonArray();
        for(BlockPos key : this.template.keySet())
        {
            JsonObject part = new JsonObject();
            part.addProperty("x", key.getX());
            part.addProperty("y", key.getY());
            part.addProperty("z", key.getZ());
            part.addProperty("block", this.blocks.indexOf(this.template.get(key)));
            layout.add(part);
        }

        total.add("layout", layout);

        try {
            MinecraftServer.getServer().getFile(templateFolder).mkdir();
            File templateFile = MinecraftServer.getServer().getFile(templateFolder + filename + "-" + LocalDateTime.now().toString() + ".template");
            LogHelper.info(templateFile.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(new FileWriter(templateFile));
            bw.write(total.toString());
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static MultiBlockTemplate loadFromFile(String fileName)
    {
        return new MultiBlockTemplate();
    }


}
