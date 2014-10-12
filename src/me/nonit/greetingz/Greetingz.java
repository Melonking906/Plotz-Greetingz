package me.nonit.greetingz;

import java.util.logging.Logger;

import me.kyle.plotz.api.events.PlotFromToEvent;
import me.kyle.plotz.obj.Plot;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Greetingz extends JavaPlugin implements Listener
{
    public static Plugin p;
    public static Logger l;

    public static String enterMessage;

    @Override
    public void onEnable()
    {
        p = this;
        l = getLogger();

        enterMessage = ChatColor.YELLOW + "Entering " + ChatColor.WHITE + "%owner%" + ChatColor.YELLOW + "'s Plot";

        getServer().getPluginManager().registerEvents( this, this );
    }

    @EventHandler
    public void onPlotFromToEvent( PlotFromToEvent e )
    {
        Player p = e.getPlayer();
        if( p.hasPermission( "plotz.greetingz" ) )
        {
            fromTo( p, e.getPlotTo() );
        }
    }

    public static void fromTo( Player p, Plot to )
    {
        enterMessage = enterMessage.replace( "%owner%", to.getOwnerName() );

        TitleMsg.send( p, enterMessage );
    }
}