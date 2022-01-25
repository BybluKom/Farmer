package com.farmer.farmermod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;


public class Chisel extends Item {
    public static Random random = new Random();


    public Chisel(Properties pProperties) {
        super(pProperties);
    }


    public boolean hasContainerItem(ItemStack stack) { //Может ли предметь иметь метаданные

            return true; //Да, может

        }

        @Override
        public ItemStack getContainerItem(ItemStack stack) { //Получаем контейнер метаданных

            ItemStack ret = stack.copy(); //Чтобы при крафте не исчезал копируем, его с прибавкой к мета, что уменьшает прочность

            if(ret.hurt(1, random, null)) //Если прочность ноль то...
                return ItemStack.EMPTY; //предмет исчезнет
            else
                return ret; //Если прочность не исчерпана то прибавим дальше
        }
}

