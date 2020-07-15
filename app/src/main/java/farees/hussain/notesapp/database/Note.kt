package farees.hussain.notesapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(
    tableName = "notes"
)
data class Note(
    var title:String,
    var note:String
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id :Int?=null
}