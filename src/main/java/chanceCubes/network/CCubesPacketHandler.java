package chanceCubes.network;

import chanceCubes.CCubesCore;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class CCubesPacketHandler
{
	private static int id = 0;
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(CCubesCore.MODID, "packets")).clientAcceptedVersions(a -> true).serverAcceptedVersions(a -> true).networkProtocolVersion(() -> FMLNetworkConstants.NETVERSION).simpleChannel();


	public static void init()
	{
		CHANNEL.registerMessage(id++, PacketCreativePendant.class, PacketCreativePendant::encode, PacketCreativePendant::decode, PacketCreativePendant::handle);
		CHANNEL.registerMessage(id++, PacketRewardSelector.class, PacketRewardSelector::encode, PacketRewardSelector::decode, PacketRewardSelector::handle);
		CHANNEL.registerMessage(id++, PacketTriggerD20.class, PacketTriggerD20::encode, PacketTriggerD20::decode, PacketTriggerD20::handle);
		CHANNEL.registerMessage(id++, PacketCubeScan.class, PacketCubeScan::encode, PacketCubeScan::decode, PacketCubeScan::handle);
	}

	public static void sendToPlayer(Object msg, ServerPlayerEntity player)
	{
		CHANNEL.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
	}
}
