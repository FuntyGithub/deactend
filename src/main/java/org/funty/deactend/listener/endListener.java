package org.funty.deactend.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.funty.deactend.Main;

public class endListener implements Listener {
    @EventHandler
    public void onEnd(PlayerPortalEvent e){
        if(e.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            if(Main.getPlugin().getConfig().getString("end").equals("disallow")){
                e.setCancelled(true);
            }
        }
    }
}
