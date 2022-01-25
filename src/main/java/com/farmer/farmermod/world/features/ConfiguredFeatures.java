package com.farmer.farmermod.world.features;

import com.farmer.farmermod.block.FarmerBlocks;
import com.farmer.farmermod.world.features.tree.Feature;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

import java.util.OptionalInt;


public class ConfiguredFeatures {


    public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY_TREE = register("berry_tree", Feature.CHERRY_FEATURE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(FarmerBlocks.CHERRY_LOG.get()),
                    new FancyTrunkPlacer(4, 5, 0),
                    BlockStateProvider.simple(FarmerBlocks.CHERRY_LEAVES.get().defaultBlockState()),
                    new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
                    new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));

    private static <FC extends FeatureConfiguration>ConfiguredFeature<FC, ?> register (String name , ConfiguredFeature<FC, ?> configuredFeature){
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE , name , configuredFeature);
    }
}
