package com.farmer.farmermod.events;

import com.farmer.farmermod.FarmerMod;
import com.farmer.farmermod.block.custom.Magic_block;
import com.farmer.farmermod.item.custom.Weather_stick;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.LevelData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FarmerMod.MOD_ID)
public class CheckRain {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void World(TickEvent.WorldTickEvent event) {
        Level world = event.world;
        LevelData data = world.getLevelData();
        if(!world.isClientSide()) {
            if(Weather_stick.timer > 0){
                Weather_stick.timer--;
            }else if(Weather_stick.timer == 0){
                data.setRaining(false);
            }
        }
    }
}




