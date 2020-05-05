package ml.moecukier.nawias.DeathNote.Listener

import ml.moecukier.nawias.DeathNote.Main
import org.bukkit.Bukkit
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockListener

class BlockListener : BlockListener() {
    override fun onBlockBreak(event: BlockBreakEvent) {
        var block = event.block;
        if(Main.deathListener.isDeathNoteblock(block))
            event.isCancelled = true

        super.onBlockBreak(event)
    }
}