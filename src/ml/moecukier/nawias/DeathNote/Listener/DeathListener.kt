package ml.moecukier.nawias.DeathNote.Listener

import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import ml.moecukier.nawias.DeathNote.Music.Song
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.NoteBlock
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityListener

public final class DeathListener : EntityListener() {
    lateinit var astronomia: Song
    private var noteblock: Block? = null
    override fun onEntityDeath(event: EntityDeathEvent?) {
        var player = event?.entity

        if(player is Player){
             GlobalScope.launch{ playSong(player.location, player) }
        }
        super.onEntityDeath(event)
    }

    private suspend fun playSong(playerLocation: Location, player: Player) {
        if(!this::astronomia.isInitialized){
            astronomia = Song("astronomia")
        }
        noteblock = playerLocation.block
        val blockType = noteblock?.type
        val blockData = noteblock?.data

        noteblock?.type = Material.NOTE_BLOCK
        delay(50)
        runBlocking { astronomia.playSong(playerLocation, player) }

        noteblock?.type = blockType
        noteblock?.data = blockData!!
        noteblock = null;

    }
    public fun isDeathNoteblock(block: Block): Boolean {
        return block.equals(noteblock)
    }

}