package com.mcit.scala.RW

import com.mcit.scala.GTFS.{Calender, Routes, Trips}

import scala.io.Source

//
//Created by  on 2020-05-26
//

class Reader {

  val filePathRoutes = "/home/bd-user/Desktop/gtfs_stm/routes.txt"
  val filePathCalender = "/home/bd-user/Desktop/gtfs_stm/calendar.txt"
  val filePathTrips = "/home/bd-user/Desktop/gtfs_stm/trips.txt"

  def getRouteList: List[Routes] = {

    Source.fromFile(filePathRoutes).getLines().drop(1)
      .map(k => k.split(",", -1))
      .map(a => Routes(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList

  }

  def getCalenderList: List[Calender] = {

    Source.fromFile(filePathCalender).getLines().drop(1)
      .map(k => k.split(",", -1))
      .map(a => Calender(a(0), a(1), a(2), a(3), a(4), a(5), a(6), a(7), a(8), a(9))).toList

  }

  def getTripList: List[Trips] = {

    Source.fromFile(filePathTrips).getLines().drop(1)
      .map(k => k.split(",", -1))
      .map(a => Trips(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList

  }
}
