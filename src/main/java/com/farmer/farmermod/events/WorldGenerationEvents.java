package com.farmer.farmermod.events;

import com.farmer.farmermod.FarmerMod;
import com.farmer.farmermod.world.gen.ModPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.farmer.farmermod.world.gen.OreGeneration.OVERWORLD_MAGIC_ORE;
import static com.farmer.farmermod.world.gen.OreGeneration.OVERWORLD_PESTICIDES_ORE;


@Mod.EventBusSubscriber(modid = FarmerMod.MOD_ID)
public class WorldGenerationEvents {
    @SubscribeEvent
    public static void WorldGeneration(BiomeLoadingEvent event){
        if(event.getCategory().getName().equals(Biome.BiomeCategory.FOREST.getName())){
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION , ModPlacements.CHERRY_TREE_PLACEMENT);
        }
        if(event.getCategory() != Biome.BiomeCategory.THEEND){
            if(event.getCategory() != Biome.BiomeCategory.NETHER) {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OVERWORLD_MAGIC_ORE);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OVERWORLD_PESTICIDES_ORE);
            }
        }
    }
}
