package de.hype.eggsentials.shared.packets.network;

import de.hype.eggsentials.environment.packetconfig.AbstractPacket;
import de.hype.eggsentials.shared.constants.AuthenticationConstants;

/**
 * From Client to Server. Tell the Server they want to connect.
 */
public class RequestConnectPacket extends AbstractPacket {

    /**
     * @param mcuuid           the mcuuid of the peron that wants to connect.
     * @param key              api key
     * @param clientApiVersion
     * @param authType
     */
    public RequestConnectPacket(String mcuuid, String key, int clientApiVersion, AuthenticationConstants authType) {
        super(1, 1); //Min and Max supported Version
        this.mcuuid = mcuuid;
        this.key = key;
        this.authType = authType;
        this.clientApiVersion = clientApiVersion;
    }

    public final String mcuuid;
    public final String key;
    public final AuthenticationConstants authType;
    public final int clientApiVersion;
}
