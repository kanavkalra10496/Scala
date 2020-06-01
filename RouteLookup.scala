package com.mcit.scala.Mapping

import com.mcit.scala.GTFS.Routes

//
//  Created by  on 2020-05-30
//

class RouteLookup(routes: List[Routes]) {

  private val lookupTable: Map[Int, Routes] =
    routes.map(route => route.route_id -> route).toMap

  def lookup(routeId: Int): Routes = lookupTable.getOrElse(routeId, null)

}
