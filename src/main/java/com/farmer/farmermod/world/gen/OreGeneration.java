package com.farmer.farmermod.world.gen;


import com.farmer.farmermod.block.FarmerBlocks;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

public class OreGeneration {

    public static final int Magic_Ore_Veins_Max = 8;
    public static final int Magic_Ore_Veins = 3;
    public static final int Pesticides_Ore_Veins_Max = 2;
    public static final int Pesticides_Ore_Veins = 1;

    public static PlacedFeature OVERWORLD_MAGIC_ORE;
    public static PlacedFeature OVERWORLD_PESTICIDES_ORE;

    public static void OreConfiguredFeatures(){


        OreConfiguration overWorldMagicOre = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES , FarmerBlocks.MAGIC_ORE.get().defaultBlockState() , Magic_Ore_Veins_Max);
        OVERWORLD_MAGIC_ORE = registerPlacedFeature("overworld_magic_ore" , Feature.ORE.configured(overWorldMagicOre),
                CountPlacement.of(Magic_Ore_Veins),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(10) , VerticalAnchor.absolute(65)));

        OreConfiguration overWorldPesticidesOre = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES , FarmerBlocks.PESTICIDES_ORE.get().defaultBlockState() , Pesticides_Ore_Veins_Max);
        OVERWORLD_PESTICIDES_ORE = registerPlacedFeature("overworld_magic_ore" , Feature.ORE.configured(overWorldPesticidesOre),
                CountPlacement.of(Pesticides_Ore_Veins),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-20) , VerticalAnchor.absolute(40)));
    }

    private static <C extends FeatureConfiguration , F extends Feature<C>> PlacedFeature registerPlacedFeature (String name , ConfiguredFeature<C , F> feature, PlacementModifier... placementModifier){
        PlacedFeature placed = BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE , new ResourceLocation(name) , feature).placed(placementModifier);
        return PlacementUtils.register(name , placed);
    }
}
