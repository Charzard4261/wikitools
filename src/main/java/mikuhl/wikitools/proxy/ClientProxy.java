package mikuhl.wikitools.proxy;

import mikuhl.wikitools.WikiTools;
import mikuhl.wikitools.WikiToolsKeybinds;
import mikuhl.wikitools.handler.CopyNBTHandler;
import mikuhl.wikitools.handler.EntityRenderHandler;
import mikuhl.wikitools.listeners.RenderListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        MinecraftForge.EVENT_BUS.register(new CopyNBTHandler());
        MinecraftForge.EVENT_BUS.register(new EntityRenderHandler());

        WikiTools.getInstance().renderListener = new RenderListener();
        MinecraftForge.EVENT_BUS.register(WikiTools.getInstance().renderListener);

        WikiToolsKeybinds.init();
    }
}
