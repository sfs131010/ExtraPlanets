package com.mjr.extraplanets.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.mjr.extraplanets.world.features.WorldGenCustomLake;

public class WorldGenHelper {
	public static void generateLake(World world, Random rand, BlockPos pos, Block fluid, Block block) {
		int x = pos.getX() + 8;
		int z = pos.getZ() + 8;
		int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY() - 2;
		new WorldGenCustomLake(fluid).generate(world, rand, new BlockPos(x, y, z), block);
	}

	public static void generateLake(World world, Random rand, BlockPos pos, Block fluid, IBlockState block) {
		int x = pos.getX() + 8;
		int z = pos.getZ() + 8;
		int y = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY() - 2;
		new WorldGenCustomLake(fluid).generate(world, rand, new BlockPos(x, y, z), block);
	}

	public static boolean checkValidSpawn(World world, BlockPos position, int size) {
		for (position = position.add(0, 0, 0); position.getY() > 5 && world.isAirBlock(position) || world.getBlockState(position).getMaterial().isLiquid(); position = position.down()) {
			;
		}

		if (position.getY() <= 4) {
			return false;
		}

		for (int i = -size; i <= size; ++i) {
			for (int j = -size; j <= size; ++j) {
				if (world.isAirBlock(position.add(i, -1, j)) && world.isAirBlock(position.add(i, -2, j)) || world.getBlockState(position.add(i, -1, j)).getMaterial().isLiquid() && world.getBlockState(position.add(i, -2, j)).getMaterial().isLiquid()) {
					return false;
				}
			}
		}
		return true;
	}
}