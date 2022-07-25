package com.yungnickyoung.minecraft.betteroceanmonuments.mixin.accessor;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.UUID;

@Mixin(Projectile.class)
public interface ProjectileAccessor {
    @Accessor
    UUID getOwnerUUID();
}
