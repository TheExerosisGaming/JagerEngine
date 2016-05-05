package me.exerosis.jager.engine.core.utilites;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

/**
 * Durpped in to existence by Exerosis on 3/17/2016.
 */
public class BlockUtilities {

    private BlockUtilities()
    {
    }

    public static ItemStack toItemStack(Block block)
    {
        return new ItemStack(block.getType(), 1, block.getData());
    }

    public static MaterialData toMaterialData(Block block)
    {
        return new MaterialData(block.getType(), block.getData());
    }


}
