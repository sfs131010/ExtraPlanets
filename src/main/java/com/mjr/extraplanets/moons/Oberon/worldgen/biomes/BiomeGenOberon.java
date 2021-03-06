package com.mjr.extraplanets.moons.Oberon.worldgen.biomes;

import net.minecraft.init.Blocks;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;

public class BiomeGenOberon extends OberonBiomes {
	public BiomeGenOberon(int par1) {
		super(par1);
		this.topBlock = Blocks.ice;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.denseIce;
		this.fillerMeta = 1;
		this.stoneBlock = ExtraPlanets_Blocks.oberonBlocks;
		this.stoneMeta = 2;
	}
}