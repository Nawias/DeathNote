package ml.moecukier.nawias.DeathNote

import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import ml.moecukier.nawias.DeathNote.Music.Song
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityListener

public final class DeathListener : EntityListener() {
    lateinit var astronomia: Song
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
        var noteblock = playerLocation.block
        val block = noteblock.type

        noteblock.type = Material.NOTE_BLOCK
        delay(50)
        runBlocking { astronomia.playSong(playerLocation, player) }

        noteblock.type = block

    }

}