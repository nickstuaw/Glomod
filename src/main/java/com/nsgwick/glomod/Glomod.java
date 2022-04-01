package com.nsgwick.glomod;

import com.nsgwick.glomod.items.EdiblePaperItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Glomod implements ModInitializer {

    public static final String MOD_NAME = "glomod";


    public static final EdiblePaperItem EDIBLE_PAPER_ITEM = new EdiblePaperItem(
            new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).snack().build()));

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
            new Identifier(MOD_NAME, "general"))
            .icon(() -> new ItemStack(EDIBLE_PAPER_ITEM))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(EDIBLE_PAPER_ITEM));
            })
            .build();

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_NAME, "edible_paper"), EDIBLE_PAPER_ITEM);
    }
}
