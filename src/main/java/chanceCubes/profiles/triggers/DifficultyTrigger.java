package chanceCubes.profiles.triggers;

import chanceCubes.profiles.IProfile;
import net.minecraft.world.Difficulty;

public class DifficultyTrigger implements ITrigger<Difficulty>
{
	private IProfile prof;
	private Difficulty diff;

	public DifficultyTrigger(IProfile prof, Difficulty diff)
	{
		this.prof = prof;
		this.diff = diff;
	}

	@Override
	public void onTrigger(String playerUUID, Difficulty[] args)
	{
		if(args.length == 2)
		{
			if(args[0].equals(diff))
				prof.setTriggerState(this, playerUUID, true);
			else if(args[1].equals(diff))
				prof.setTriggerState(this, playerUUID, false);
		}
	}

	@Override
	public String getTriggerDesc()
	{
		return "Trigger on game difficulty change";
	}
}
