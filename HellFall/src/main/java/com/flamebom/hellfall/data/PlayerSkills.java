package com.flamebom.hellfall.data;

import net.minecraft.nbt.CompoundTag;

public class PlayerSkills {

    private int[] skills;

    public int[] getSkills() {
        return skills;
    }

    public void setSkills(int skill) {
      skills[skill]=1;
    }

    public void copyFrom(PlayerSkills source) {
        skills = source.skills;
    }


    public void saveNBTData(CompoundTag compound) {
        compound.putIntArray("skills", skills);
    }

    public void loadNBTData(CompoundTag compound) {
        skills = compound.getIntArray("skills");
    }
}