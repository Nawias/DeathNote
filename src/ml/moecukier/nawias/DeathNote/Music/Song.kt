package ml.moecukier.nawias.DeathNote.Music

import com.beust.klaxon.Klaxon
import kotlinx.coroutines.delay
import ml.moecukier.nawias.DeathNote.Util.FileUtil
import org.bukkit.Location
import org.bukkit.entity.Player

class Song constructor(private val name: String){

    var notes : List<Note> = listOf<Note>()
    init {
        loadFromJSON(FileUtil.readSongJSON(name))
    }

    suspend fun playSong(location: Location, player: Player) {
        for (note in notes) {
            delay(note.getMilliseconds())
            note.playAtPos(location,player)
        }
    }

    private fun loadFromJSON( json : String ) {
        notes = Klaxon().parseArray<Note>(json)!!
    }

}