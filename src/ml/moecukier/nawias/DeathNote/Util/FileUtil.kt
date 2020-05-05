package ml.moecukier.nawias.DeathNote.Util

import ml.moecukier.nawias.DeathNote.Main
import ml.moecukier.nawias.DeathNote.Music.Song
import org.bukkit.Bukkit
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.Files
import java.nio.file.Paths

internal object FileUtil {
    val PLUGIN_DIR = "plugins/DeathNote"
    val SONGS_DIR = PLUGIN_DIR + "/songs"

    public fun initializeFileSystem() {
        val songs = File(SONGS_DIR)
        songs.mkdirs()
        val astronomia = File(SONGS_DIR+"/astronomia.json")
        if(!astronomia.exists()) try {
            Files.write(astronomia.toPath(),FileUtil::class.java.classLoader.getResource("astronomia.json").readText().toByteArray())
        } catch (e: IOException){
            e.printStackTrace()
        }
    }

        @Throws(IOException::class)
        fun readFile(path: String, encoding: Charset): String {
            val encoded = Files.readAllBytes(Paths.get(path))
            return String(encoded, encoding!!)
        }

        fun readSongJSON(name: String): String {
            return readFile("$SONGS_DIR/$name.json", UTF_8)
        }
    }
