package uk.ac.tees.w9354187.teesweatherapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getDayNameFromEpoch(epochTime: Long): String {
    val date = Date(epochTime * 1000) // Convert epoch time to milliseconds
    val dayNameFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
    return dayNameFormat.format(date)
}