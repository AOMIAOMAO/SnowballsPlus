package com.mao.snowballs_plus.items.snowballs;

import com.mao.snowballs_plus.entities.snowballs.SuctionSnowballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SuctionSnowballItem extends ModSnowballItem{
    public SuctionSnowballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        this.spawnSnowballEntity(world, user, hand, new SuctionSnowballEntity(user, world), 0.0f, 1.6f, 1.0f);
        return TypedActionResult.success(stack, world.isClient());
    }
}
