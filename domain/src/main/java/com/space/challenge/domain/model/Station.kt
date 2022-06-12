package com.space.challenge.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
//  (
//  foreignKeys = arrayOf(
//    ForeignKey(
//      entity = FavoriteStation::class,
//      parentColumns = arrayOf("id"),
//      childColumns = arrayOf("fav"),
//      onDelete = ForeignKey.CASCADE
//    )
//  )
//)
data class Station(
  var name: String?,
  var coordinateX: Double?,
  var coordinateY: Double?,
  var capacity: Long?,
  var stock: Long?,
  var need: Long?
) : Parcelable {

  @IgnoredOnParcel
  @PrimaryKey(autoGenerate = true)
//  @ColumnInfo(name = "id")
  val id: Int = 1

  @IgnoredOnParcel
  var isFavorite: Boolean = false

  @IgnoredOnParcel
  var pos: Int = -1
}