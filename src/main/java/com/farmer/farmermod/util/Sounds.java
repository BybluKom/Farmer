package com.farmer.farmermod.util;

import com.farmer.farmermod.FarmerMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvent;

public class Sounds{

    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS , FarmerMod.MOD_ID);

    //music
    public static final RegistryObject<SoundEvent> MORANDI_SAVE = registrySound("morandi_save");

    private static RegistryObject<SoundEvent> registrySound(String name){
        return SOUND_EVENT.register(name , () -> new SoundEvent(new ResourceLocation(FarmerMod.MOD_ID , name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENT.register(eventBus);
    }
}
