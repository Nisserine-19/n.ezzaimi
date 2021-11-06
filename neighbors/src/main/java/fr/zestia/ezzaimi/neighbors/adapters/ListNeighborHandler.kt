package fr.zestia.ezzaimi.neighbors.adapters

import fr.zestia.ezzaimi.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
}
