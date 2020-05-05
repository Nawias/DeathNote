package ml.moecukier.nawias.DeathNote.Listener

import javafx.application.Application.launch
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import ml.moecukier.nawias.DeathNote.Music.Song
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.EntityListener

public final class DeathListener : EntityListener() {
    lateinit var astronomia: Song
    private var deathBlocks: HashMap<Player,Block?> = HashMap()
    private var prevBlocks : HashMap<Player,BlockData?> = HashMap()
    override fun onEntityDeath(event: EntityDeathEvent) {
        var player = event.entity

        if(player is Player){
             GlobalScope.launch{ playSong(player.location, player) }
        }
        super.onEntityDeath(event)
    }

    private suspend fun playSong(playerLocation: Location, player: Player) {
        if(!this::astronomia.isInitialized){
            astronomia = Song("astronomia")
        }

        if(deathBlocks[player] != null) {
            deathBlocks[player]?.type = prevBlocks[player]?.type
            deathBlocks[player]?.data = prevBlocks[player]?.data!!
            deathBlocks[player] = null
        }

        deathBlocks[player] = playerLocation.block;
        prevBlocks[player] = BlockData(deathBlocks[player]?.type, deathBlocks[player]?.data)

        deathBlocks[player]?.type = Material.NOTE_BLOCK
        delay(50)
        runBlocking { astronomia.playSong(playerLocation, player) }

        deathBlocks[player]?.type = prevBlocks[player]?.type
        deathBlocks[player]?.data = prevBlocks[player]?.data!!
        deathBlocks[player] = null

    }
    public fun isDeathNoteblock(block: Block): Boolean {
        return deathBlocks.containsValue(block)
    }

}

internal class BlockData(val type: Material?, val data: Byte?)