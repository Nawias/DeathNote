package ml.moecukier.nawias.DeathNote
import ml.moecukier.nawias.DeathNote.Listener.BlockListener
import ml.moecukier.nawias.DeathNote.Listener.DeathListener
import ml.moecukier.nawias.DeathNote.Util.FileUtil
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        public lateinit var deathListener : DeathListener
        public lateinit var blockListener : BlockListener
        init {
            FileUtil.initializeFileSystem()
        }
    }
    override fun onEnable() {
        val pm = server.pluginManager
        deathListener = DeathListener()
        blockListener = BlockListener()
        pm.registerEvent(Event.Type.ENTITY_DEATH, deathListener, Event.Priority.Normal, this)
        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.High, this)

        val logger = Bukkit.getServer().logger
        logger.info(this.description.fullName + " started")
    }

    override fun onDisable() {
        val logger = Bukkit.getServer().logger
        logger.info(this.description.fullName + " stopped")
    }


}