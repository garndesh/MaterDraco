package garndesh.materdraco.items;

import net.minecraft.item.Item;

/**
 * Created by cte20616 on 26-5-2015.
 */
public class ModItems {

    public static MaterDracoItem dragonScale;
    public static MaterDracoItem creativeSelect;

    public static void init(){
        dragonScale  = new ItemDracoScale();
        creativeSelect = new ItemCreativeSelect();
    }
}
