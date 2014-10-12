package me.nonit.greetingz;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.ProtocolInjector;

public class TitleMsg
{
    private static final int FADE_IN = 5;
    private static final int FADE_OUT = 5;
    private static final int TIME = 20;

    public static void send( Player player, String message )
    {
        PlayerConnection craftPlayer = ( ( CraftPlayer ) player ).getHandle().playerConnection;

        ProtocolInjector.PacketTitle length = new ProtocolInjector.PacketTitle( ProtocolInjector.PacketTitle.Action.TIMES, FADE_IN, TIME, FADE_OUT );
        ProtocolInjector.PacketTitle titleBig = new ProtocolInjector.PacketTitle( ProtocolInjector.PacketTitle.Action.TITLE, null );
        ProtocolInjector.PacketTitle titleSmall = new ProtocolInjector.PacketTitle( ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a( "{'text': ''}" ).a( message ) );

        craftPlayer.sendPacket( length );
        craftPlayer.sendPacket( titleBig );
        craftPlayer.sendPacket( titleSmall );
    }
}