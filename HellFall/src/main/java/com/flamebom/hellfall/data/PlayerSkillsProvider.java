package com.flamebom.hellfall.data;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerSkillsProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerSkills> PLAYER_SKILLS = CapabilityManager.get(new CapabilityToken<>(){});

    private PlayerSkills playerSkills = null;
    private final LazyOptional<PlayerSkills> opt = LazyOptional.of(this::createPlayerSkills);

    @Nonnull
    private PlayerSkills createPlayerSkills() {
        if (playerSkills == null) {
        	playerSkills = new PlayerSkills();
        }
        return playerSkills;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == PLAYER_SKILLS) {
            return opt.cast();
        }
        return LazyOptional.empty();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return getCapability(cap);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerSkills().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
    	createPlayerSkills().loadNBTData(nbt);
    }
}