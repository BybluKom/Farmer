package com.farmer.farmermod.world.gen;

import com.farmer.farmermod.world.features.ConfiguredFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;



public class ModPlacements {

    public static final PlacedFeature CHERRY_TREE_PLACEMENT = PlacementUtils.register("berry_tree_placement",
            ConfiguredFeatures.CHERRY_TREE.placed(RarityFilter.onAverageOnceEvery(2),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_TOP_SOLID,
                    BiomeFilter.biome()));

}
