package com.farmer.farmermod.events;

import com.farmer.farmermod.FarmerMod;
import com.farmer.farmermod.events.loot.MorandiDisc;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FarmerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventBusEvent {
        @SubscribeEvent
        public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                               event) {
            event.getRegistry().registerAll(
                    new MorandiDisc.Serializer().setRegistryName
                            (new ResourceLocation(FarmerMod.MOD_ID,"morandi"))
            );
        }
}
