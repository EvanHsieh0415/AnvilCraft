package dev.dubhe.anvilcraft.event;

import com.google.common.collect.Maps;
import dev.dubhe.anvilcraft.init.ModBlocks;
import dev.dubhe.anvilcraft.init.ModItemTags;
import dev.dubhe.anvilcraft.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TooltipEventListener {

    private static final Map<Item, String> map = Maps.newHashMap();

    static {
        map.put(ModItems.MAGNET.get(), "Attract surrounding items when use");
        map.put(ModItems.GEODE.get(), "Find the surrounding Amethyst Geode when using it");
        map.put(ModItems.ANVIL_HAMMER.get(), "It's a hammer, an anvil, a wrench, goggles, and a mace");
        map.put(ModItems.ROYAL_ANVIL_HAMMER.get(), "It's a hammer, an anvil, a wrench, goggles, and a mace");
        map.put(ModBlocks.CURSED_GOLD_BLOCK.asItem(), "Carriers will be cursed");
        map.put(ModItems.CURSED_GOLD_INGOT.get(), "Carriers will be cursed");
        map.put(ModItems.CURSED_GOLD_NUGGET.get(), "Carriers will be cursed");
        map.put(ModItems.TOPAZ.get(), "Containing the power of lightning");
        map.put(ModBlocks.RESIN_BLOCK.asItem(), "Use to capture friendly or weak hostile creatures LivingEntity");
        map.put(ModBlocks.CRAB_TRAP.asItem(), "Placing it in the water to help you catch aquatic products");
        map.put(ModItems.CRAB_CLAW.get(), "Increase touch distance when holding");
        map.put(ModBlocks.ROYAL_ANVIL.asItem(), "Unbreakable and powerful compatibility");
        map.put(ModBlocks.ROYAL_GRINDSTONE.asItem(), "Creeper proof, Eliminating Curses and Punishing");
        map.put(ModBlocks.ROYAL_SMITHING_TABLE.asItem(), "Creeper proof, Saving your Smithing Template");
        map.put(ModBlocks.HEATER.asItem(), "Heating the block above, consumes 8 KW");
        map.put(ModBlocks.TRANSMISSION_POLE.asItem(), "Build a power grid with a transmission distance of 8");
        map.put(ModBlocks.CHARGE_COLLECTOR.asItem(), "Collecting charges to generate power");
        map.put(ModBlocks.POWER_CONVERTER_SMALL.asItem(), "Convert power into FE, consumes 1 KW");
        map.put(ModBlocks.POWER_CONVERTER_MIDDLE.asItem(), "Convert power into FE, consumes 3 KW");
        map.put(ModBlocks.POWER_CONVERTER_BIG.asItem(), "Convert power into FE, consumes 9 KW");
        map.put(ModBlocks.PIEZOELECTRIC_CRYSTAL.asItem(), "Charge generated by an anvil fall on it");
        map.put(ModBlocks.MAGNET_BLOCK.asItem(),
            "Attracting the anvil below, when pushed and pulled by the piston, "
            + "causes adjacent copper blocks to generate charges");
        map.put(ModBlocks.HOLLOW_MAGNET_BLOCK.asItem(), "Attracting the anvil below, "
            + "when pushed and pulled by the piston, causes adjacent copper blocks to generate charges");
        map.put(ModBlocks.FERRITE_CORE_MAGNET_BLOCK.asItem(), "Attracting the anvil below, "
            + "when pushed and pulled by the piston, causes adjacent copper blocks to generate charges");
        map.put(ModBlocks.AUTO_CRAFTER.asItem(), "consumes 1 KW");
        map.put(ModBlocks.ROYAL_STEEL_BLOCK.asItem(), "Creeper proof");
        map.put(ModBlocks.SMOOTH_ROYAL_STEEL_BLOCK.asItem(), "Creeper proof");
        map.put(ModBlocks.CUT_ROYAL_STEEL_BLOCK.asItem(), "Creeper proof");
        map.put(ModBlocks.CUT_ROYAL_STEEL_STAIRS.asItem(), "Creeper proof");
        map.put(ModBlocks.CUT_ROYAL_STEEL_SLAB.asItem(), "Creeper proof");
        map.put(ModBlocks.TEMPERING_GLASS.asItem(), "Creeper proof, No tools required on collect");
        map.put(ModBlocks.REMOTE_TRANSMISSION_POLE.asItem(), "Build a power grid with a transmission distance of 8");
        map.put(ModBlocks.HEAVY_IRON_BLOCK.asItem(), "Explosion proof");
        map.put(ModBlocks.POLISHED_HEAVY_IRON_BLOCK.asItem(), "Explosion proof");
        map.put(ModBlocks.POLISHED_HEAVY_IRON_SLAB.asItem(), "Explosion proof");
        map.put(ModBlocks.POLISHED_HEAVY_IRON_STAIRS.asItem(), "Explosion proof");
        map.put(ModBlocks.CUT_HEAVY_IRON_BLOCK.asItem(), "Explosion proof");
        map.put(ModBlocks.CUT_HEAVY_IRON_SLAB.asItem(), "Explosion proof");
        map.put(ModBlocks.CUT_HEAVY_IRON_STAIRS.asItem(), "Explosion proof");
        map.put(ModBlocks.HEAVY_IRON_PLATE.asItem(), "Explosion proof");
        map.put(ModBlocks.HEAVY_IRON_COLUMN.asItem(), "Explosion proof");
        map.put(ModBlocks.HEAVY_IRON_BEAM.asItem(), "Explosion proof");
        map.put(ModBlocks.INDUCTION_LIGHT.asItem(), "Catalyze crop growth, consumes 1 KW");
        map.put(ModBlocks.ITEM_COLLECTOR.asItem(),
            "Adjust power consumption based on range and cooling"
            + ", from 30KW to 150KW");
    }

    public static final Map<Item, String> NEED_TOOLTIP_ITEM = Collections.unmodifiableMap(map);

    /**
     * 添加工具提示
     *
     * @param stack 物品堆
     * @param tooltip 提示类容
     */
    public static void addTooltip(ItemStack stack, List<Component> tooltip) {
        Item item = stack.getItem();
        if (NEED_TOOLTIP_ITEM.containsKey(item)) {
            tooltip.add(1, getItemTooltip(item));
        }
        if (stack.is(ModItemTags.REINFORCED_CONCRETE)) {
            ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
            tooltip.add(1,
                Component.translatable("tooltip.%s.item.reinforced_concrete".formatted(key.getNamespace()))
                .withStyle(ChatFormatting.GRAY)
            );
        }
    }

    private static Component getItemTooltip(Item item) {
        return Component.translatable(getTranslationKey(item)).withStyle(ChatFormatting.GRAY);
    }

    public static String getTranslationKey(Item item) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
        return "tooltip.%s.item.%s".formatted(key.getNamespace(), key.getPath());
    }
}
