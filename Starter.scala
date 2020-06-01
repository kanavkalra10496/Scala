package com.mcit.scala.Starter

import com.mcit.scala.GTFS._
import com.mcit.scala.Mapping.{CalendarLookup, RouteLookup}
import com.mcit.scala.RW.{Reader, Writer}

// Created on 2020-05-28


object Starter extends App {

  val readData: Reader = new Reader

  val tripList: List[Trips] = readData.getTripList


  val routeList: List[Routes] = readData.getRouteList


  val calanderList: List[Calender] = readData.getCalenderList

  val routeLookup = new RouteLookup(routeList)

  val calenderLookUp = new CalendarLookup(calanderList)


  val enrichedTripRoute: List[TripRoute] = tripList.map(trip => TripRoute(trip,
    routeLookup.lookup(trip.route_id))).toList

  val enrichedTrip: List[EnrichedTrip] = enrichedTripRoute.map(tripRoute => EnrichedTrip(tripRoute,
    calenderLookUp.lookup(tripRoute.trips.service_id))).toList


  val writer = new Writer(enrichedTrip)

  writer.writeData
}
