package ml.moecukier.nawias.DeathNote.Music

import org.bukkit.Location
import org.bukkit.entity.Player

class Note constructor(val instrument: Instrument, val pitch: Pitch, val delayInTicks: Int) {
    public fun playAtPos(location: Location, player: Player) {
        player.playNote(location,instrument.byte,pitch.byte);
    }
    public fun getTicks(): Int {
        return delayInTicks;
    }
    public fun getMilliseconds(): Long {
        return (delayInTicks * 50).toLong();
    }
}