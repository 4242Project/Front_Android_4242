package com.wanted.wantedproject.data

data class Schedule(
   var week : ArrayList<Week>
)
data class Week(
    var startTime : Int,
    var endTime : Int,
    var className : String
)
