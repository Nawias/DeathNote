package ml.moecukier.nawias.DeathNote.Music

import kotlinx.coroutines.delay
import org.bukkit.Location
import org.bukkit.entity.Player

class Song constructor(val name:String){

    var notes : List<Note> = listOf<Note>();
    init {
        notes = listOf<Note>(
            Note(Instrument.PIANO,Pitch.C2, 0),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.F1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),

            Note(Instrument.PIANO,Pitch.G1, 8),
            Note(Instrument.PIANO,Pitch.D2, 4),
            Note(Instrument.PIANO,Pitch.C2, 4),

            Note(Instrument.PIANO,Pitch.AS1, 8),

            Note(Instrument.PIANO,Pitch.A1, 8),

            Note(Instrument.PIANO,Pitch.A1, 8),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.C2, 4),

            Note(Instrument.PIANO,Pitch.AS1, 8),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),

            Note(Instrument.PIANO,Pitch.G1, 8),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),

            Note(Instrument.PIANO,Pitch.G1, 8),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),

            Note(Instrument.PIANO,Pitch.G1, 8),
            Note(Instrument.PIANO,Pitch.D2, 4),
            Note(Instrument.PIANO,Pitch.C2, 4),

            Note(Instrument.PIANO,Pitch.AS1, 8),

            Note(Instrument.PIANO,Pitch.A1, 8),

            Note(Instrument.PIANO,Pitch.A1, 8),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.C2, 4),

            Note(Instrument.PIANO,Pitch.AS1, 8),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),

            Note(Instrument.PIANO,Pitch.G1, 8),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.G1, 4),

            Note(Instrument.PIANO,Pitch.G1, 8),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4),
            Note(Instrument.PIANO,Pitch.A1, 4),
            Note(Instrument.PIANO,Pitch.AS1, 4)

        )
    }

    public suspend fun playSong(location: Location, player: Player) {
        for (note in notes) {
            delay(note.getMilliseconds());
            note.playAtPos(location,player);
        }
    }

}