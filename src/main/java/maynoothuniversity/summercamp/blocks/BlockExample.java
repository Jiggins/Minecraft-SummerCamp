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

public class BlockExample extends Block {
		public BlockExample() {
				super(Material.ROCK, MapColor.STONE);

				setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
				setHardness(2.0f);
				setHarvestLevel("pickaxe", 1);

				setUnlocalizedName("exampleblock");
				setRegistryName("exampleblock");
				GameRegistry.register(this);
				GameRegistry.register(new ItemBlock(this), getRegistryName());
		}

		@SideOnly(Side.CLIENT)
		public void initModel() {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
		}

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
