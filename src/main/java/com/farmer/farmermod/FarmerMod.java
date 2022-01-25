package com.farmer.farmermod;

import com.farmer.farmermod.block.FarmerBlocks;
import com.farmer.farmermod.item.FarmerItems;
import com.farmer.farmermod.util.Sounds;
import com.farmer.farmermod.world.features.tree.Feature;
import com.farmer.farmermod.world.gen.OreGeneration;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Mod("farmermod")
public class FarmerMod
{
    public static final String MOD_ID = "farmermod";
    private static final Logger LOGGER = LogManager.getLogger();

    public FarmerMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FarmerItems.register(eventBus);
        FarmerBlocks.register(eventBus);
        Feature.register(eventBus);
        Sounds.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::Client);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AxeItem.STRIPPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPABLES).put(FarmerBlocks.CHERRY_LOG.get() , FarmerBlocks.STRIPPED_CHERRY_LOG.get())
                    .put(FarmerBlocks.CHERRY_WOOD.get() , FarmerBlocks.STRIPPED_CHERRY_WOOD.get()).build();
        });
        event.enqueueWork(() -> OreGeneration.OreConfiguredFeatures());
    }
    private void Client(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(FarmerBlocks.TOMATO_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(FarmerBlocks.CORN_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(FarmerBlocks.PEPPER_CROP.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(FarmerBlocks.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(FarmerBlocks.CHERRY_SAPLING.get(), RenderType.cutout());
    }
}
