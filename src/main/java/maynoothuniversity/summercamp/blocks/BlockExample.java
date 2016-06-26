package maynoothuniversity.summercamp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A class to create a new block in Minecraft.
 * This class 'extends' the `Block` class, meaning it inherits all of the
 * methods and variables of the `Block` class.
 *
 * Take a look at net.minecraft.block.Block.java, it can be found in:
 * 		build/tmp/recompileMc/sources/net/minecraft/block/Block.java
 */
public class BlockExample extends Block {

		/**
		 * Constructor for BlockExample.
		 * This calls the Minecraft Block constructor using `super` below.
		 * The properties of the block are set here, see the Block class for what
		 * can be set.
		 */
		public BlockExample() {
				super(Material.ROCK, MapColor.STONE);

				setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
				setHardness(2.0f);
				setHarvestLevel("pickaxe", 1);

				/*
				 * The Unlocalised and Registry names are used by forge to give your
				 * block a way to be referenced by Minecraft and other mods.
				 *
				 * In this case
				 * Unlocalised name:  tile.exampleblock.name
				 * Registry name:     summercamp:exampleblock
				 */
				setUnlocalizedName("exampleblock");
				setRegistryName("exampleblock");
				GameRegistry.register(this);
				GameRegistry.register(new ItemBlock(this), getRegistryName());
		}

		/**
		 * Set the resource location (where the texture is loaded)
		 */
		@SideOnly(Side.CLIENT)
		public void initModel() {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
		}

		/**
		 * What happens when the block is right clicked.
		 * @param World world: The world the block is in
		 * @param BlockPos pos: the x,y,z position of the block
		 * @param IBlockState state: Current state of the block
		 * @param EntityPlayer player: Who clicked the block.
		 * @param EnumHand hand: Either the primary or secondary hand (new in 1.9)
		 * @param ItemStack heldItem: The item the player is holding, `null` means no item held
		 * @param EnumFacing side: The side the block was clicked, (north, east, south, west, top, botom)
		 * @param float hitX, hitY, hitZ: Where the block was clicked
		 */
		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
				if (!world.isRemote) {
						player.addChatMessage(new TextComponentString("Hello " + player.getName()));
						player.addChatMessage(new TextComponentString("Block coordinates: " + "X: " + pos.getX() + " Y: " + pos.getY() + " Z: " + pos.getZ()));
						player.addChatMessage(new TextComponentString("Block Right click: " + "hitX: " + hitX + " hitY: " + hitY + " hitZ: " + hitZ));
						player.addChatMessage(new TextComponentString("Block Side: " + side));
						player.addChatMessage(new TextComponentString("Block Unlocalised name: " + getUnlocalizedName()));
						player.addChatMessage(new TextComponentString("Block Registry name: " + getRegistryName()));
				}
				return true;
		}
}
