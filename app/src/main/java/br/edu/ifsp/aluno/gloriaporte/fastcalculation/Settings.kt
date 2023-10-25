package br.edu.ifsp.aluno.gloriaporte.fastcalculation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Settings(
    val playerName: String = "",
    val rounds : Int = 0,
    val roundInterval: Long = 0L
) : Parcelable
