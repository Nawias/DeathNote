package ml.moecukier.nawias.DeathNote.Music

import com.beust.klaxon.Json
import org.bukkit.Location
import org.bukkit.entity.Player

class Note constructor(
    @Json(name = "i")
    val instrument: Instrument,
    @Json(name = "p")
    val pitch: Pitch,
    @Json(name = "d")
    val delayInTicks: Int) {
    fun playAtPos(location: Location, player: Player) {
        player.playNote(location,instrument.byte,pitch.byte)
    }
    fun getTicks(): Int {
        return delayInTicks
    }
    fun getMilliseconds(): Long {
        return (delayInTicks * 50).toLong()
    }
}