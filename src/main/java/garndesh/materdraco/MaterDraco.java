package garndesh.materdraco;

import garndesh.materdraco.lib.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Created by christiaan on 3/28/15.
 */


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME)
public class MaterDraco {


        //Instance of the mod you are making
        @Mod.Instance(Reference.MOD_ID)
        public static MaterDraco instance;

        @Mod.EventHandler
        public void serverStarting(FMLServerStartingEvent event)
        {

        }

        @Mod.EventHandler
        public void preInit(FMLPreInitializationEvent event){
            // set version number
            event.getModMetadata().version = Reference.VERSION_NUMBER;


        }


        @Mod.EventHandler
        public void Init(FMLInitializationEvent event){


        }

        @Mod.EventHandler
        public void PostInit(FMLPostInitializationEvent event){

        }
}
