package com.mao.snowballs_plus.entities.snowballs;

import com.mao.snowballs_plus.init.ModEntities;
import com.mao.snowballs_plus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BloodthirstySnowballEntity extends ModSnowballEntity{
    public BloodthirstySnowballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BloodthirstySnowballEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.BLOODTHIRSTY_SNOWBALL_ENTITY, livingEntity, world);
    }

    @Override
    public void handleStatus(byte status) {
        super.handleStatus(status);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Entity entity1 = this.getOwner();
        if (entity1 != null) {
            float health = ((LivingEntity)entity1).getHealth();
            entity.damage(this.getDamageSources().thrown(this, this.getOwner()), health / 5);
            entity1.damage(this.getDamageSources().thrown(this, this.getOwner()), health / 10);
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BLOODTHIRSTY_SNOWBALL_ITEM;
    }
}
