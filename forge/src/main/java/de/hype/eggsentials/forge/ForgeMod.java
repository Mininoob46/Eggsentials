package de.hype.eggsentials.forge;

import de.hype.eggsentials.client.common.client.Eggsentials;
import de.hype.eggsentials.client.common.mclibraries.EnvironmentCore;
import de.hype.eggsentials.forge.client.MoulConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod(modid = "eggsentials", useMetadata = true)
public class ForgeMod {
    static boolean alreadyInialised = false;
    static Eggsentials sentials;
    public static MoulConfig config = new MoulConfig();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        printLocation();
        EnvironmentCore core = EnvironmentCore.forge(new Utils(), new MCEvents(), new ForgeChat(), new Commands(), new Options(), new DebugThread());
        MinecraftForge.EVENT_BUS.register(this);
        sentials = new Eggsentials();
        Eggsentials.init();
    }
    public void printLocation() {
//        try {
//            // Get the URL of the JAR file containing the class
//            URL jarUrl = this.getClass().getProtectionDomain().getCodeSource().getLocation();
//
//            // Convert the URL to a URI
//            File jarFile = new File(jarUrl.toURI());
//
//            // Get the absolute path of the JAR file
//            String jarPath = jarFile.getAbsolutePath();
//
////            throw new RuntimeException(jarPath);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
    }
    @SubscribeEvent
    public void onClientConnected(PlayerEvent.PlayerRespawnEvent event) {
        Eggsentials.onServerJoin();
    }

}

