package garndesh.materdraco;

import garndesh.materdraco.blocks.ModBlocks;
import garndesh.materdraco.items.ModItems;
import garndesh.materdraco.lib.Reference;

import garndesh.materdraco.proxy.IProxy;
import garndesh.materdraco.util.LogHelper;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Created by christiaan on 3/28/15.
 */


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
public class MaterDraco {


    //Instance of the mod you are making
    @Mod.Instance(Reference.MOD_ID)
    public static MaterDraco instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        // set version number
        LogHelper.info("PreInit");
        event.getModMetadata().version = Reference.VERSION_NUMBER;
        ModBlocks.init();
        ModItems.init();


        LogHelper.info("PreInit done");
    }


    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
        proxy.registerRenderers();
        LogHelper.info("Init");
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event){

    }
}
