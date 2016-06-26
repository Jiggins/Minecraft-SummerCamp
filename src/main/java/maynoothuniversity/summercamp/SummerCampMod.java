package maynoothuniversity.summercamp;

import maynoothuniversity.summercamp.blocks.BlockExample;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SummerCampMod.MODID, version = SummerCampMod.VERSION)
public class SummerCampMod {

		public static final String MODID = "summercamp";
		public static final String VERSION = "1.0";

		public static BlockExample blockexample;

		@SidedProxy
		public static CommonProxy proxy;

		@Mod.Instance
		public static SummerCampMod instance;

		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) {
				System.out.println("SummerCampMod preInit");
				proxy.preInit(event);
		}

		@Mod.EventHandler
		public void init(FMLInitializationEvent event) {
				System.out.println("SummerCampMod init");
				proxy.init(event);
		}

		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent event) {
				System.out.println("SummerCampMod postInit");
				proxy.postInit(event);
		}

		public static class CommonProxy {
				public void preInit(FMLPreInitializationEvent event) {
						// Initialization of blocks and items typically goes here:
						blockexample = new BlockExample();
				}

				public void init(FMLInitializationEvent event) {

				}

				public void postInit(FMLPostInitializationEvent event) {

				}
		}


		public static class ClientProxy extends CommonProxy {
				@Override
				public void preInit(FMLPreInitializationEvent event) {
						super.preInit(event);
						// Typically initialization of models and such goes here:
						blockexample.initModel();
				}
		}

		public static class ServerProxy extends CommonProxy {

		}
}
