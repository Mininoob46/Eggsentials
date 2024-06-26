package de.hype.eggsentials.environment.packetconfig;

import de.hype.eggsentials.client.common.communication.BBsentialConnection;
import de.hype.eggsentials.shared.packets.function.PlaySoundPacket;
import de.hype.eggsentials.shared.packets.network.*;

import java.util.ArrayList;
import java.util.List;

public class PacketManager {

    private static PacketManager lastPacketManager = null;
    List<Packet<? extends AbstractPacket>> packets = new ArrayList<>();
    // Define a map to store packet classes and their associated actions
    BBsentialConnection connection;

    // Method to initialize packet actions
    public PacketManager(BBsentialConnection connection) {
        this.connection = connection;
        initializePacketActions(connection);
        lastPacketManager = this;
    }

    //   method to get a list of all packets
    public static List<Class<? extends AbstractPacket>> getAllPacketClasses() {
        if (lastPacketManager == null) {
            lastPacketManager = new PacketManager(null);
        }
        List<Class<? extends AbstractPacket>> allPackets = new ArrayList<>();
        for (int i = 0; i < lastPacketManager.packets.size(); i++) {
            allPackets.add(lastPacketManager.packets.get(i).getClazz());
        }
        return allPackets;
    }

    public List<Packet<? extends AbstractPacket>> getPackets() {
        return packets;
    }

    // Method to handle a received packet

    public void initializePacketActions(BBsentialConnection connection) {
        packets.add(new Packet<>(DisconnectPacket.class, connection::onDisconnectPacket));
        packets.add(new Packet<>(InternalCommandPacket.class, connection::onInternalCommandPacket));
//        packets.add(new Packet<>(RequestConnectPacket.class, connection::dummy));
        packets.add(new Packet<>(SystemMessagePacket.class, connection::onSystemMessagePacket));
        packets.add(new Packet<>(WelcomeEggPacket.class, connection::onWelcomeEggPacket));
        packets.add(new Packet<>(EggFoundPacket.class, connection::onEggFoundPacket));

        packets.add(new Packet<>(RequestAuthentication.class, connection::onRequestAuthentication));
        packets.add(new Packet<>(PunishedPacket.class, connection::onPunishedPacket));
        packets.add(new Packet<>(PlaySoundPacket.class, connection::onPlaySoundPacket));
    }
}
