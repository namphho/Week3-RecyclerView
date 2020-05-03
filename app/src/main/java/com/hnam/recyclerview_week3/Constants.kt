package com.hnam.recyclerview_week3

/**
 * Created by Nam Pham 03/05/2020
 */
const val IDOL_NAME_KEY = "IDOL_NAME_KEY"
const val IDOL_JOB_KEY = "IDOL_JOB_KEY"
const val IDOL_AVATAR_KEY = "IDOL_AVATAR_KEY"

fun generateIdols() : List<Idol>{
    val idols = ArrayList<Idol>()
    idols.add(Idol("Nguyen Quang Hai", "Footballer", R.drawable.quanghai))
    idols.add(Idol("Bui Tien Dung", "Footballer", R.drawable.buitiendung))
    idols.add(Idol("Duy Manh", "Footballer", R.drawable.duymanh))
    idols.add(Idol("Cong Phuong", "Footballer", R.drawable.congphuong))
    idols.add(Idol("Van Toan", "Footballer", R.drawable.vantoan))
    idols.add(Idol("Huynh Duc", "Football Coach", R.drawable.huynhduc))
    idols.add(Idol("Vinh Rau", "Comedian", R.drawable.vinhrau))
    idols.add(Idol("Cong Vinh", "Football Manager", R.drawable.conhvinh))
    idols.add(Idol("Dinh Manh Ninh", "Artist", R.drawable.dmninh))
    return idols
}