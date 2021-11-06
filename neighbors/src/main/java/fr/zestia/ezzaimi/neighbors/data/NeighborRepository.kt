package fr.zestia.ezzaimi.neighbors.data

import fr.zestia.ezzaimi.neighbors.data.service.DummyNeighborApiService
import fr.zestia.ezzaimi.neighbors.data.service.NeighborApiService
import fr.zestia.ezzaimi.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun removeNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun addNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)
    fun getIdNeigbour() = getNeighbours().last().id + 1

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
