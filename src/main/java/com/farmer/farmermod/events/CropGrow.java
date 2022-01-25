package com.farmer.farmermod.events;

import com.farmer.farmermod.FarmerMod;
import net.minecraft.world.level.storage.LevelData;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FarmerMod.MOD_ID)
public class CropGrow {
    @SubscribeEvent
    public static void Crow(BlockEvent.CropGrowEvent event) {
        LevelData data = event.getWorld().getLevelData();
        if (data.isRaining()) {
            event.setResult(Event.Result.ALLOW);
        } else {
            event.setResult(Event.Result.DENY);
        }
    }
}
