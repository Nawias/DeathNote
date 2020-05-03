package ml.moecukier.nawias.DeathNote
import ml.moecukier.nawias.DeathNote.Music.Song
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        public val astronomia: Song = Song("astronomia");
    }
    public override fun onEnable() {
        var pm = server.pluginManager;
        var pl = DeathListener();
        pm.registerEvent(Event.Type.ENTITY_DEATH, pl, Event.Priority.Normal, this);


        var logger = Bukkit.getServer().logger
        logger.info(this.description.fullName + " started")
    }

    override fun onDisable() {
        var logger = Bukkit.getServer().logger
        logger.info(this.description.fullName + " stopped")
    }


}