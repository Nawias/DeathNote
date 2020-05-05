package ml.moecukier.nawias.DeathNote
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ml.moecukier.nawias.DeathNote.Music.Song
import ml.moecukier.nawias.DeathNote.Util.FileUtil
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        init {
            FileUtil.initializeFileSystem()
        }
    }
    override fun onEnable() {
        val pm = server.pluginManager
        val pl = DeathListener()
        pm.registerEvent(Event.Type.ENTITY_DEATH, pl, Event.Priority.Normal, this)


        val logger = Bukkit.getServer().logger
        logger.info(this.description.fullName + " started")
    }

    override fun onDisable() {
        val logger = Bukkit.getServer().logger
        logger.info(this.description.fullName + " stopped")
    }


}