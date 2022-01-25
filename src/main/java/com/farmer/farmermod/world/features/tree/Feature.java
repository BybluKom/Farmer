package com.farmer.farmermod.world.features.tree;

import com.farmer.farmermod.FarmerMod;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Feature {

    public static final DeferredRegister<net.minecraft.world.level.levelgen.feature.Feature<?>> FEATURES
            = DeferredRegister.create(ForgeRegistries.FEATURES, FarmerMod.MOD_ID);

    public static final RegistryObject<net.minecraft.world.level.levelgen.feature.Feature<TreeConfiguration>> CHERRY_FEATURE = FEATURES.register("berry_feature", () -> new TreeFeature(TreeConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
